package com.areeba.pos.services;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.DiscountDTO;
import com.areeba.pos.entity.Discounts;

public interface DiscountService {

    Discounts createDiscount(DiscountDTO discountDTO);

    RestCommonResponse updateDiscount(long id, DiscountDTO discountDTO);

    RestCommonResponse deleteDiscount(long id);

    Discounts findById(long id);

    Discounts findByName(String name);

    RestCommonResponse getAll();

}
