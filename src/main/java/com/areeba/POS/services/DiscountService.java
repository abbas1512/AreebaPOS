package com.areeba.POS.services;

import com.areeba.POS.dto.DiscountDTO;
import com.areeba.POS.entity.Discounts;

import java.util.List;

public interface DiscountService {

    void createDiscount(DiscountDTO discountDTO);

    void updateDiscount(DiscountDTO discountDTO, long Id);

    void deleteDiscount(long Id);

    Discounts findById(long Id);

    Discounts findByName(String name);

    List<Discounts> getAll();

}
