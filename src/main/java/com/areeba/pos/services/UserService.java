package com.areeba.pos.services;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.UserDTO;
import com.areeba.pos.entity.User;
import com.mchange.util.AlreadyExistsException;

public interface UserService {

    User registerUser(UserDTO userDTO) throws AlreadyExistsException;

    RestCommonResponse updateUser(long id, UserDTO userDTO);

    RestCommonResponse updatePassword(long id, String password);

    RestCommonResponse updatePasswordEmail(String email, String password);

    RestCommonResponse deleteUser(long id);

    User getUser(long userId);

    User getUserEmail(String email);

    RestCommonResponse getAllUsers();

}
