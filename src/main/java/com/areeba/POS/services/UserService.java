package com.areeba.POS.services;

import com.areeba.POS.dto.BusinessDTO;
import com.areeba.POS.dto.UserDTO;
import com.areeba.POS.entity.User;

import java.util.List;

public interface UserService {

    void createUser(UserDTO userDTO) throws Exception;

    void updateUser(UserDTO userDTO, long Id);

    void deleteUser(long Id);

    void createBusiness(BusinessDTO businessDTO) throws Exception;

    void updateBusiness(BusinessDTO businessDTO, long Id);

    void deleteBusiness(long Id);

    User findById(long Id);

    User findByEmail(String email);

    List<User> getAll();

}
