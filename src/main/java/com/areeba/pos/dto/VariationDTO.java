package com.areeba.pos.dto;

import com.areeba.pos.entity.Items;
import com.areeba.pos.entity.OptionVariations;
import com.areeba.pos.enums.Unit;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class VariationDTO {

    private long Id;
    private Items itemId;
    private OptionVariations optionVariationId;
    private String name;
    private Unit unit;
    private BigDecimal price;
    private int stock;

}
