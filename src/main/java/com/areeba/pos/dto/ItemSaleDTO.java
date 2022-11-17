package com.areeba.pos.dto;

import com.areeba.pos.entity.Items;
import com.areeba.pos.entity.Sales;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ItemSaleDTO {

    private long Id;
    private Items itemId;
    private Sales saleId;
    private int quantity;

}
