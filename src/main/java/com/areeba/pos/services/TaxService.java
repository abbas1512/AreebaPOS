package com.areeba.pos.services;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.TaxDTO;
import com.areeba.pos.entity.Taxes;

public interface TaxService {

    Taxes createTax(TaxDTO taxDTO);

    RestCommonResponse updateTax(long Id, TaxDTO taxDTO);

    RestCommonResponse deleteTax(long Id);

    RestCommonResponse saveTax(TaxDTO taxDTO, String name);

    RestCommonResponse assignTaxToItem(long itemId, long taxId);

    Taxes getTax(long taxId);

    Taxes getTaxName(String name);

    RestCommonResponse getAllTaxes();

}
