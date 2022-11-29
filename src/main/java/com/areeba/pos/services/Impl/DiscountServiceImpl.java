package com.areeba.pos.services.Impl;

import com.areeba.pos.common.ErrorResponseApisEnum;
import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.DiscountDTO;
import com.areeba.pos.entity.Discounts;
import com.areeba.pos.repository.DiscountRepository;
import com.areeba.pos.services.DiscountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import java.util.List;


@Service("DiscountServices")
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private final DiscountRepository discountRepository;
    private final Logger log = LoggerFactory.getLogger(DiscountServiceImpl.class);

    public DiscountServiceImpl(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    @Override
    public Discounts createDiscount(DiscountDTO discountDTO) {
        Discounts discount = new Discounts();
        BeanUtils.copyProperties(discountDTO, discount);
        return discountRepository.save(discount);
    }

    @Override
    public RestCommonResponse updateDiscount(long id, DiscountDTO discountDTO) {
        if (this.discountRepository.findById(id) != null) {
            Discounts discountsById = this.discountRepository.findById(id);
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
    public RestCommonResponse deleteDiscount(long id) {
        if (this.discountRepository.findById(id) != null) {
            this.discountRepository.deleteById(id);
            return new RestCommonResponse(true, "Deleted");
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.DoesNotExist)));
        }
    }

    @Override
    public Discounts findById(long id) {
        log.info("Fetching Discount");
        return this.discountRepository.findById(id);
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
