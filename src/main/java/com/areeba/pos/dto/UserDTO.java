package com.areeba.pos.dto;

import com.areeba.pos.entity.Business;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {

    private long id;

    private String email;

    private String password;

}
