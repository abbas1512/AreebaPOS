package com.areeba.POS.dto;

import com.areeba.POS.entity.Items;
import com.areeba.POS.entity.Sales;
import lombok.*;

import java.math.BigDecimal;

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
