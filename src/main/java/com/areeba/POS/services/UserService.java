package com.areeba.POS.services;

import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.UserDTO;
import com.areeba.POS.entity.User;

public interface UserService {

    User createUser(UserDTO userDTO);

    RestCommonResponse updateUser(long Id, UserDTO userDTO);

    RestCommonResponse updatePassword(long Id, String password);

    RestCommonResponse updatePasswordEmail(String email, String password);

    RestCommonResponse activateUser(String email);

    RestCommonResponse deleteUser(long Id);

    RestCommonResponse saveUser(UserDTO userDTO, String email);

    User findById(long Id);

    User findByEmail(String email);

    RestCommonResponse getAll();

}
