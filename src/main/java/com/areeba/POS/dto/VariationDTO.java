package com.areeba.POS.dto;

import com.areeba.POS.entity.Items;
import com.areeba.POS.entity.OptionVariations;
import com.areeba.POS.enums.Unit;
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
