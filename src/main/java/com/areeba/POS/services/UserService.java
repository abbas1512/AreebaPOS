package com.areeba.POS.services;

import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.BusinessDTO;
import com.areeba.POS.dto.UserDTO;
import com.areeba.POS.entity.Business;
import com.areeba.POS.entity.User;

public interface UserService {

    User createUser(UserDTO userDTO);

    RestCommonResponse updateUser(long Id, UserDTO userDTO);

    RestCommonResponse updatePassword(long Id, String password);

    RestCommonResponse updatePasswordEmail(String email, String password);

    RestCommonResponse activateUser(String email);

    RestCommonResponse deleteUser(long Id);

    RestCommonResponse saveUser(UserDTO userDTO, String email);

    Business createBusiness(BusinessDTO businessDTO);

    RestCommonResponse updateBusiness(long Id, BusinessDTO businessDTO);

    RestCommonResponse deleteBusiness(long Id);

    RestCommonResponse saveBusiness(BusinessDTO businessDTO, String name);

    RestCommonResponse assignBusinessToUser(long userId, long businessId);

    User getUser(long userId);

    User getUserEmail(String email);

    RestCommonResponse getAllUsers();

    Business getBusiness(long businessId);

    Business getBusinessName(String name);

    RestCommonResponse getAllBusiness();

}
