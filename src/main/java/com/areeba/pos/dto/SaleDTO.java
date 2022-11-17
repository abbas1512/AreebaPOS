package com.areeba.pos.dto;

import com.areeba.pos.entity.Customers;
import com.areeba.pos.entity.Discounts;
import com.areeba.pos.entity.ItemSales;
import com.areeba.pos.enums.PaymentType;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SaleDTO {

    private long Id;
    private Set<ItemSales> itemSaleId;
    private Customers customerId;
    private Set<Discounts> discountsId;
    private String notes;
    private PaymentType paymentType;
    private BigDecimal subtotal;
    private BigDecimal total;
    private Date date;

}
