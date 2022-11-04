package com.areeba.POS.dto;

import com.areeba.POS.entity.Sales;
import com.areeba.POS.enums.Type;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DiscountDTO {

    private long Id;
    private Sales saleId;
    private String name;
    private Type type;
    private double amount;

}
