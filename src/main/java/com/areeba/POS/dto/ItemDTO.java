package com.areeba.POS.dto;

import com.areeba.POS.entity.*;
import com.areeba.POS.enums.Unit;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ItemDTO {

    private long Id;
    private Set<Taxes> taxId;
    private Set<ItemSales> itemSaleId;
    private Business businessId;
    private Category categoryId;
    private Set<Variations> variationId;
    private String name;
    private Blob image;
    private String SKU;
    private Unit unit;
    private BigDecimal price;
    private int stock;

}
