package com.areeba.POS.dto;

import com.areeba.POS.entity.Sales;
import lombok.*;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDTO {

    private long Id;
    private Set<Sales> saleId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
    private String company;
    private Date birthday;
    private String name = firstName + " " + lastName;

}
