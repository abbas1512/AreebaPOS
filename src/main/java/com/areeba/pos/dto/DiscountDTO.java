package com.areeba.pos.dto;

import com.areeba.pos.entity.Sales;
import com.areeba.pos.enums.Type;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DiscountDTO {

    private long id;
    private Sales saleId;
    private String name;
    private Type type;
    private double amount;

}
