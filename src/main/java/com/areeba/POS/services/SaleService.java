package com.areeba.POS.services;

import com.areeba.POS.dto.ItemSaleDTO;
import com.areeba.POS.dto.SaleDTO;
import com.areeba.POS.entity.Sales;

import java.util.List;

public interface SaleService {

    void createSale(SaleDTO saleDTO);

    void createItemSale(ItemSaleDTO itemSaleDTO);

    void deleteSale(long Id);

    void deleteItemSale(long Id);

    Sales findById(long Id);

    List<Sales> getAll();

}
