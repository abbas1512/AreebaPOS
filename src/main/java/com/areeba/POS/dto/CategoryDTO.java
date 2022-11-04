package com.areeba.POS.dto;

import com.areeba.POS.entity.Items;
import lombok.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CategoryDTO {

    private long Id;
    private Set<Items> itemId;
    private String name;

}
