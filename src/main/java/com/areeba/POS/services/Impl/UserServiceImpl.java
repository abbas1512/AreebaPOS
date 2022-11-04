package com.areeba.POS.services.Impl;

import com.areeba.POS.dto.BusinessDTO;
import com.areeba.POS.dto.UserDTO;
import com.areeba.POS.entity.Business;
import com.areeba.POS.entity.User;
import com.areeba.POS.repository.BusinessRepository;
import com.areeba.POS.repository.UserRepository;
import com.areeba.POS.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BusinessRepository businessRepository;

    @Override
    public void createUser(UserDTO userDTO) throws Exception {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);
    }

    @Override
    public void createBusiness(BusinessDTO businessDTO) throws Exception {
        Business business = new Business();
        business.setUserId(businessDTO.getUserId());
        business.setType(businessDTO.getType());
        business.setCategory(businessDTO.getCategory());
        business.setName(businessDTO.getName());
        business.setFirstName(businessDTO.getFirstName());
        business.setLastName(businessDTO.getLastName());
        business.setAddress(businessDTO.getAddress());
        business.setCity(businessDTO.getCity());
        business.setPostalCode(businessDTO.getPostalCode());
        businessRepository.save(business);
    }

    @Override
    public void updateUser(UserDTO userDTO, long Id) {
        User userById = userRepository.findById(Id);
        userById.setEmail(userDTO.getEmail());
        userById.setPassword(userDTO.getPassword());
        userRepository.save(userById);
    }

    @Override
    public void updateBusiness(BusinessDTO businessDTO, long Id) {
        Business businessById = businessRepository.findById(Id);
        businessById.setUserId(businessDTO.getUserId());
        businessById.setType(businessDTO.getType());
        businessById.setCategory(businessDTO.getCategory());
        businessById.setName(businessDTO.getName());
        businessById.setFirstName(businessDTO.getFirstName());
        businessById.setLastName(businessDTO.getLastName());
        businessById.setAddress(businessDTO.getAddress());
        businessById.setCity(businessDTO.getCity());
        businessById.setPostalCode(businessDTO.getPostalCode());
        businessRepository.save(businessById);
    }

    @Override
    public void deleteUser(long Id) {
        userRepository.deleteById(Id);
    }

    @Override
    public void deleteBusiness(long Id) {
        businessRepository.deleteById(Id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findById(long Id) {
        return userRepository.findById(Id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
