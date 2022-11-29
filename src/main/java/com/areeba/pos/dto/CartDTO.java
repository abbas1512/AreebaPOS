package com.areeba.pos.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CartDTO {

    private long id;
    private long itemId;
    private long saleId;
    private int quantity;
    private Double itemTotal;

}
