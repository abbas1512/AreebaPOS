package com.areeba.POS.services;

import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.CategoryDTO;
import com.areeba.POS.dto.DiscountDTO;
import com.areeba.POS.entity.Category;
import com.areeba.POS.entity.Discounts;

import java.util.List;

public interface DiscountService {

    Discounts createDiscount(DiscountDTO discountDTO);

    RestCommonResponse updateDiscount(long Id, DiscountDTO discountDTO);

    RestCommonResponse deleteDiscount(long Id);

    RestCommonResponse saveDiscount(DiscountDTO discountDTO, String name);

    Discounts findById(long Id);

    Discounts findByName(String name);

    RestCommonResponse getAll();

}
