package com.areeba.pos.dto;

import com.areeba.pos.entity.Cart;
import com.areeba.pos.entity.Customers;
import com.areeba.pos.entity.Discounts;
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

    private long id;
    private long cartId;
    private long customerId;
    private Set<Discounts> discountsId;
    private String notes;
    private PaymentType paymentType;
    private Double subtotal;
    private Double total;
    private Date date;

}
