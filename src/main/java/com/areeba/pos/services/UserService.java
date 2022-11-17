package com.areeba.pos.services;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.UserDTO;
import com.areeba.pos.entity.User;
import com.mchange.util.AlreadyExistsException;

public interface UserService {

    User registerUser(UserDTO userDTO) throws AlreadyExistsException;

    RestCommonResponse updateUser(long Id, UserDTO userDTO);

    RestCommonResponse updatePassword(long Id, String password);

    RestCommonResponse updatePasswordEmail(String email, String password);

    RestCommonResponse activateUser(String email);

    RestCommonResponse deleteUser(long Id);

    RestCommonResponse saveUser(UserDTO userDTO, String email);

    User getUser(long userId);

    User getUserEmail(String email);

    RestCommonResponse getAllUsers();

}
