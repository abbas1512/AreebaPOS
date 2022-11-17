package com.areeba.pos.dto;

import com.areeba.pos.entity.Items;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TaxDTO {

    private long Id;
    private Items itemId;
    private String name;
    private BigDecimal percentage;

}
