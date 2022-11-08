package com.areeba.POS.services.Impl;

import com.areeba.POS.common.ErrorResponseApisEnum;
import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.TaxDTO;
import com.areeba.POS.entity.Taxes;
import com.areeba.POS.repository.TaxRepository;
import com.areeba.POS.services.TaxServices;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import java.util.List;
import java.util.logging.Logger;

@Service("TaxService")
public class TaxServiceImpl implements TaxServices {

    @Autowired
    private final TaxRepository taxRepository;
    private static final Logger log = (Logger) LoggerFactory.getLogger(TaxServiceImpl.class);

    public TaxServiceImpl(TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }

    @Override
    public Taxes createTax(TaxDTO taxDTO) {
        Taxes tax = new Taxes();
        tax.setItemId(taxDTO.getItemId());
        tax.setName(taxDTO.getName());
        tax.setPercentage(taxDTO.getPercentage());
        return taxRepository.save(tax);
    }

    @Override
    public RestCommonResponse updateTax(long Id, TaxDTO taxDTO) {
        if (this.taxRepository.findById(Id) != null) {
            Taxes taxById = this.taxRepository.findById(Id);
            taxById.setItemId(taxDTO.getItemId());
            taxById.setName(taxDTO.getName());
            taxById.setPercentage(taxDTO.getPercentage());
            Taxes updatedTaxes = this.taxRepository.save(taxById);
            return new RestCommonResponse(true, new Taxes(
                    updatedTaxes.getItemId(),
                    updatedTaxes.getName(),
                    updatedTaxes.getPercentage()
            ));
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.DoesntExist)));
        }
    }

    @Override
    public RestCommonResponse deleteTax(long Id) {
        if (this.taxRepository.findById(Id) != null) {
            this.taxRepository.deleteById(Id);
            return new RestCommonResponse(true, "Deleted");
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.DoesntExist)));
        }
    }


    @Override
    public RestCommonResponse saveTax(TaxDTO taxDTO, String name) {
        Taxes tax = this.taxRepository.findByName(name);
        if (tax == null) {
            log.info("Saving tax to the database");
            return new RestCommonResponse(true, this.taxRepository.save(tax));
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.AlreadyRegistered)));
        }
    }

    @Override
    public Taxes findById(long Id) {
        log.info("Fetching Tax");
        return this.taxRepository.findById(Id);
    }

    @Override
    public Taxes findByName(String name) {
        log.info("Fetching Tax");
        return this.taxRepository.findByName(name);
    }

    @Override
    public RestCommonResponse getAll() {
        log.info("Fetching All Taxes");
        List<Taxes> taxes = this.taxRepository.findAll();
        return new RestCommonResponse(true, taxes);
    }
}
