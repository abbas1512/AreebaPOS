package com.areeba.POS.dto;

import com.areeba.POS.entity.Business;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {

    private long Id;

    private Business businessId;

    private String email;

    private String password;

}
