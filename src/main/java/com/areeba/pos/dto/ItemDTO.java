package com.areeba.pos.dto;

import com.areeba.pos.entity.*;
import com.areeba.pos.enums.Unit;
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

    private long id;
    private long businessId;
    private Set<Taxes> taxId;
    private String category;
    private String name;
    private Blob image;
    private String SKU;
    private Unit unit;
    private float price;
    private int stock;

}
