package com.areeba.POS.services;

import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.ItemSaleDTO;
import com.areeba.POS.dto.SaleDTO;
import com.areeba.POS.entity.ItemSales;
import com.areeba.POS.entity.Sales;

public interface SaleService {

    ItemSales createItemSale(ItemSaleDTO itemSaleDTO);

    Sales createSale(SaleDTO saleDTO);

    RestCommonResponse cancelSale(long Id);

    RestCommonResponse confirmSale(SaleDTO saleDTO, long Id);

    Sales getSale(long Id);

    RestCommonResponse getAllSales();

}
