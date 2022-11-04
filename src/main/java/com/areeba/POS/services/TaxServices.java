package com.areeba.POS.services;

import com.areeba.POS.dto.TaxDTO;
import com.areeba.POS.entity.Taxes;

import java.util.List;

public interface TaxServices {

    void createTax(TaxDTO taxDTO);

    void updateTax(TaxDTO taxDTO, long Id);

    void deleteTax(long Id);

    Taxes findById(long Id);

    Taxes findByName(String name);

    List<Taxes> getAll();

}
