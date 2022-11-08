package com.areeba.POS.services;

import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.TaxDTO;
import com.areeba.POS.entity.Taxes;

import java.util.List;

public interface TaxServices {

    Taxes createTax(TaxDTO taxDTO);

    RestCommonResponse updateTax(long Id, TaxDTO taxDTO);

    RestCommonResponse deleteTax(long Id);

    RestCommonResponse saveTax(TaxDTO taxDTO, String name);

    Taxes findById(long Id);

    Taxes findByName(String name);

    RestCommonResponse getAll();

}
