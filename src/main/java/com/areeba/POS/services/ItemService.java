package com.areeba.POS.services;

import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.ItemDTO;
import com.areeba.POS.dto.TaxDTO;
import com.areeba.POS.entity.Items;
import com.areeba.POS.entity.Taxes;

public interface ItemService {

    Items createItem(ItemDTO itemDTO);

    RestCommonResponse updateItem(long Id, ItemDTO itemDTO);

    RestCommonResponse deleteItem(long Id);

    RestCommonResponse saveItem(ItemDTO itemDTO, String name);

    Taxes createTax(TaxDTO taxDTO);

    RestCommonResponse updateTax(long Id, TaxDTO taxDTO);

    RestCommonResponse deleteTax(long Id);

    RestCommonResponse saveTax(TaxDTO taxDTO, String name);

    RestCommonResponse assignTaxToItem(long itemId, long taxId);

    Items getItem(long itemId);

    Items getItemName(String name);

    RestCommonResponse getAllItems();

    Taxes getTax(long taxId);

    Taxes getTaxName(String name);

    RestCommonResponse getAllTaxes();

}
