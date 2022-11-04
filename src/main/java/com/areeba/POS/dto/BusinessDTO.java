package com.areeba.POS.dto;

import com.areeba.POS.entity.Items;
import com.areeba.POS.entity.User;
import lombok.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BusinessDTO {

    private long Id;
    private User userId;
    private Set<Items> itemId;
    private String name;
    private String firstName;
    private String lastName;
    private String type;
    private String category;
    private String address;
    private String city;
    private String postalCode;

}
