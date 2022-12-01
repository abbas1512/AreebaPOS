package com.areeba.pos.services;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.CartDTO;
import com.areeba.pos.dto.SaleDTO;
import com.areeba.pos.entity.Cart;
import com.areeba.pos.entity.Sales;

public interface SaleService {

    Cart addItem(CartDTO cartDTO);

    RestCommonResponse removeItem(long id);

    Cart viewCart(long id);

    Sales createSale(SaleDTO saleDTO);

    RestCommonResponse cancelSale(long id);

    Sales getSale(long id);

    RestCommonResponse getAllSales();

}
