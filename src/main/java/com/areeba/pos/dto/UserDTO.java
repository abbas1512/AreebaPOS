package com.areeba.pos.dto;

import com.areeba.pos.entity.Business;
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
