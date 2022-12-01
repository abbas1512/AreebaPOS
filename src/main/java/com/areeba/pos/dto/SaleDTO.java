package com.areeba.pos.dto;

import com.areeba.pos.enums.PaymentType;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SaleDTO {

    private long id;
    private long cartId;
    private long customerId;
    private long discountsId;
    private String notes;
    private PaymentType paymentType;
    private Double subtotal;
    private Double total;
    private Date date;

}
