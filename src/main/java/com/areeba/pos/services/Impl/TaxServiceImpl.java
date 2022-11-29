package com.areeba.pos.services.Impl;

import com.areeba.pos.common.ErrorResponseApisEnum;
import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.TaxDTO;
import com.areeba.pos.entity.Items;
import com.areeba.pos.entity.Taxes;
import com.areeba.pos.repository.ItemRepository;
import com.areeba.pos.repository.TaxRepository;
import com.areeba.pos.services.TaxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import java.util.List;
import java.util.Set;

@Service("TaxService")
public class TaxServiceImpl implements TaxService {

    @Autowired
    private final TaxRepository taxRepository;
    @Autowired
    private final ItemRepository itemRepository;
    private final Logger log = LoggerFactory.getLogger(TaxServiceImpl.class);

    public TaxServiceImpl(TaxRepository taxRepository, ItemRepository itemRepository) {
        this.taxRepository = taxRepository;
        this.itemRepository = itemRepository;
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
    public RestCommonResponse updateTax(long id, TaxDTO taxDTO) {
        if (this.taxRepository.findById(id) != null) {
            Taxes taxById = this.taxRepository.findById(id);
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
                    (ErrorResponseApisEnum.ItemNotFound)));
        }
    }

    @Override
    public RestCommonResponse deleteTax(long id) {
        if (this.taxRepository.findById(id) != null) {
            this.taxRepository.deleteById(id);
            return new RestCommonResponse(true, "Deleted");
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.ItemNotFound)));
        }
    }

    @Override
    public Taxes getTax(long taxId) {
        log.info("Fetching Tax");
        return this.taxRepository.findById(taxId);
    }

    @Override
    public Taxes getTaxName(String name) {
        log.info("Fetching Tax");
        return this.taxRepository.findByName(name);
    }

    @Override
    public RestCommonResponse getAllTaxes() {
        log.info("Fetching All Taxes");
        List<Taxes> taxes = this.taxRepository.findAll();
        return new RestCommonResponse(true, taxes);
    }
}
