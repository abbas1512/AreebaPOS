package com.areeba.POS.services;

import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.UserDTO;
import com.areeba.POS.entity.User;
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
