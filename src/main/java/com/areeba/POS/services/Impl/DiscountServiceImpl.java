package com.areeba.POS.services.Impl;

import com.areeba.POS.common.ErrorResponseApisEnum;
import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.DiscountDTO;
import com.areeba.POS.entity.Discounts;
import com.areeba.POS.repository.DiscountRepository;
import com.areeba.POS.services.DiscountService;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import java.util.List;
import java.util.logging.Logger;

@Service("DiscountServices")
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private final DiscountRepository discountRepository;
    private static final Logger log = (Logger) LoggerFactory.getLogger(DiscountServiceImpl.class);

    public DiscountServiceImpl(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    @Override
    public Discounts createDiscount(DiscountDTO discountDTO) {
        Discounts discount = new Discounts();
        discount.setSaleId(discountDTO.getSaleId());
        discount.setName(discountDTO.getName());
        discount.setType(discountDTO.getType());
        discount.setAmount(discountDTO.getAmount());
        return discountRepository.save(discount);
    }

    @Override
    public RestCommonResponse updateDiscount(long Id, DiscountDTO discountDTO) {
        if (this.discountRepository.findById(Id) != null) {
            Discounts discountsById = this.discountRepository.findById(Id);
            discountsById.setSaleId(discountDTO.getSaleId());
            discountsById.setName(discountDTO.getName());
            discountsById.setType(discountDTO.getType());
            discountsById.setAmount(discountDTO.getAmount());
            Discounts updatedDiscounts = this.discountRepository.save(discountsById);
            return new RestCommonResponse(true, new Discounts(
                    updatedDiscounts.getSaleId(),
                    updatedDiscounts.getName(),
                    updatedDiscounts.getType(),
                    updatedDiscounts.getAmount()
            ));
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.DoesNotExist)));
        }
    }

    @Override
    public RestCommonResponse deleteDiscount(long Id) {
        if (this.discountRepository.findById(Id) != null) {
            this.discountRepository.deleteById(Id);
            return new RestCommonResponse(true, "Deleted");
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.DoesNotExist)));
        }
    }

    @Override
    public RestCommonResponse saveDiscount(DiscountDTO discountDTO, String name) {
        Discounts discounts = this.discountRepository.findByName(name);
        if (discounts == null) {
            log.info("Saving discount to the database");
            return new RestCommonResponse(true, this.discountRepository.save(discounts));
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.AlreadyRegistered)));
        }
    }

    @Override
    public Discounts findById(long Id) {
        log.info("Fetching Discount");
        return this.discountRepository.findById(Id);
    }

    @Override
    public Discounts findByName(String name) {
        log.info("Fetching Discount");
        return this.discountRepository.findByName(name);
    }

    @Override
    public RestCommonResponse getAll() {
        log.info("Fetching All Discounts");
        List<Discounts> discounts = this.discountRepository.findAll();
        return new RestCommonResponse(true, discounts);
    }
}
