package com.areeba.pos.services;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.DiscountDTO;
import com.areeba.pos.entity.Discounts;

public interface DiscountService {

    Discounts createDiscount(DiscountDTO discountDTO);

    RestCommonResponse updateDiscount(long Id, DiscountDTO discountDTO);

    RestCommonResponse deleteDiscount(long Id);

    RestCommonResponse saveDiscount(DiscountDTO discountDTO, String name);

    Discounts findById(long Id);

    Discounts findByName(String name);

    RestCommonResponse getAll();

}
