package com.areeba.POS.services.Impl;

import com.areeba.POS.dto.DiscountDTO;
import com.areeba.POS.entity.Discounts;
import com.areeba.POS.repository.DiscountRepository;
import com.areeba.POS.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DiscountServices")
public class DiscountServicesImpl implements DiscountService {

    @Autowired
    DiscountRepository discountRepository;

    @Override
    public void createDiscount(DiscountDTO discountDTO) {
        Discounts discount = new Discounts();
        discount.setSaleId(discountDTO.getSaleId());
        discount.setName(discountDTO.getName());
        discount.setType(discountDTO.getType());
        discount.setAmount(discountDTO.getAmount());
        discountRepository.save(discount);
    }

    @Override
    public void updateDiscount(DiscountDTO discountDTO, long Id) {
        Discounts discountById = discountRepository.findById(Id);
        discountById.setSaleId(discountDTO.getSaleId());
        discountById.setName(discountDTO.getName());
        discountById.setType(discountDTO.getType());
        discountById.setAmount(discountDTO.getAmount());
        discountRepository.save(discountById);
    }

    @Override
    public void deleteDiscount(long Id) {
        discountRepository.deleteById(Id);
    }

    @Override
    public Discounts findById(long Id) {
        return discountRepository.findById(Id);
    }

    @Override
    public Discounts findByName(String name) {
        return discountRepository.findByName(name);
    }

    @Override
    public List<Discounts> getAll() {
        return discountRepository.findAll();
    }
}
