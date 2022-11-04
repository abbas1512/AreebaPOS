package com.areeba.POS.dto;

import com.areeba.POS.entity.Options;
import com.areeba.POS.entity.Variations;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OptionVariationDTO {

    private long Id;
    private Set<Variations> variationId;
    private Options optionId;
    private String name;

}
