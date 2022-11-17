package com.areeba.pos.services;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.ItemSaleDTO;
import com.areeba.pos.dto.SaleDTO;
import com.areeba.pos.entity.ItemSales;
import com.areeba.pos.entity.Sales;

public interface SaleService {

    ItemSales addItem(ItemSaleDTO itemSaleDTO);

    RestCommonResponse removeItem(long Id);

    Sales createSale(SaleDTO saleDTO);

    RestCommonResponse cancelSale(long Id);

    RestCommonResponse confirmSale(SaleDTO saleDTO, long Id);

    Sales getSale(long Id);

    RestCommonResponse getAllSales();

}
