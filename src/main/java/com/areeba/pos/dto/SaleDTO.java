package com.areeba.pos.dto;

import com.areeba.pos.entity.Cart;
import com.areeba.pos.entity.Discounts;
import com.areeba.pos.enums.PaymentType;
import lombok.*;

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

    public Double getSubtotal(Set<Cart> cartId) {
        return subtotal = cartId.stream().filter(o -> o.getItemTotal() > 10).mapToDouble(Cart::getItemTotal).sum();
    }
}
