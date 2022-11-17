package com.areeba.pos.dto;

import com.areeba.pos.entity.OptionVariations;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OptionDTO {

    private long Id;
    private Set<OptionVariations> optionVariationId;
    private String name;

}
