package com.areeba.pos.dto;

import com.areeba.pos.entity.Items;
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
