package com.areeba.pos.dto;

import com.areeba.pos.entity.Options;
import com.areeba.pos.entity.Variations;
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
