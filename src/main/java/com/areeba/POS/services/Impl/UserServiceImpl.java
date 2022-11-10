package com.areeba.POS.services.Impl;

import com.areeba.POS.common.ErrorResponseApisEnum;
import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.BusinessDTO;
import com.areeba.POS.dto.UserDTO;
import com.areeba.POS.entity.Business;
import com.areeba.POS.entity.User;
import com.areeba.POS.repository.BusinessRepository;
import com.areeba.POS.repository.UserRepository;
import com.areeba.POS.services.UserService;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import java.util.List;
import java.util.logging.Logger;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final BusinessRepository businessRepository;
    private static final Logger log = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository, BusinessRepository businessRepository) {
        this.userRepository = userRepository;
        this.businessRepository = businessRepository;
    }

    @Override
    public User createUser(UserDTO userDTO) {
        BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
        User user = new User();
        user.setBusinessId(userDTO.getBusinessId());
        user.setEmail(userDTO.getEmail());
        user.setPassword(pwEncoder.encode(userDTO.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public RestCommonResponse updateUser(long Id, UserDTO userDTO) {
        BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
        if (this.userRepository.findById(Id) != null) {
            User existingUser = this.userRepository.findById(Id);
            existingUser.setEmail(userDTO.getEmail());
            existingUser.setPassword(pwEncoder.encode(userDTO.getPassword()));
            User updatedUser = this.userRepository.save(existingUser);
            return new RestCommonResponse(true, new User(
                    updatedUser.getEmail(),
                    updatedUser.getPassword()
            ));
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.DoesntExist)));
        }
    }

    @Override
    public RestCommonResponse updatePassword(long Id, String password) {
        BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
        if (this.userRepository.findById(Id) != null) {
            User existingUser = this.userRepository.findById(Id);
            existingUser.setPassword(pwEncoder.encode(password));
            User updatedUser = this.userRepository.save(existingUser);
            return new RestCommonResponse(true, new User(updatedUser.getId(), updatedUser.getPassword()));
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.DoesntExist)));
        }
    }

    @Override
    public RestCommonResponse updatePasswordEmail(String email, String password) {
        BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
        if (this.userRepository.findByEmail(email) != null) {
            User existingUser = this.userRepository.findByEmail(email);
            existingUser.setPassword(pwEncoder.encode(password));
            User updatedUser = this.userRepository.save(existingUser);
            return new RestCommonResponse(true, new User(updatedUser.getEmail(), updatedUser.getPassword()));
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.DoesntExist)));
        }
    }

    @Override
    public RestCommonResponse activateUser(String email) {
        User userAuth = this.userRepository.findByEmail(email);
        if (userAuth != null) {
            return new RestCommonResponse(true, this.userRepository.save(userAuth));
        } else {
            return new RestCommonResponse(false, new Exception("Error, Could not activate user"));
        }
    }

    @Override
    public RestCommonResponse deleteUser(long Id) {
        if (this.userRepository.findById(Id) != null) {
            this.userRepository.deleteById(Id);
            return new RestCommonResponse(true, "Deleted");
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.DoesntExist)));
        }
    }

    @Override
    public RestCommonResponse saveUser(UserDTO userDTO, String email) {
        BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
        User userAuth = this.userRepository.findByEmail(email);
        if (userAuth == null) {
            log.info("Saving new user to the database");
            userDTO.setPassword(pwEncoder.encode(userDTO.getPassword()));
            return new RestCommonResponse(true, this.userRepository.save(userAuth));
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.AlreadyRegistered)));
        }
    }

    @Override
    public Business createBusiness(BusinessDTO businessDTO) {
        Business business = new Business();
        business.setUserId(businessDTO.getUserId());
        business.setItemId(businessDTO.getItemId());
        business.setName(businessDTO.getName());
        business.setType(businessDTO.getType());
        business.setCategory(businessDTO.getCategory());
        business.setAddress(businessDTO.getAddress());
        business.setCity(businessDTO.getCity());
        business.setPostalCode(businessDTO.getPostalCode());
        return businessRepository.save(business);
    }

    @Override
    public RestCommonResponse updateBusiness(long Id, BusinessDTO businessDTO) {
        if (this.businessRepository.findById(Id) != null) {
            Business businessById = this.businessRepository.findById(Id);
            businessById.setUserId(businessDTO.getUserId());
            businessById.setItemId(businessDTO.getItemId());
            businessById.setName(businessDTO.getName());
            businessById.setType(businessDTO.getType());
            businessById.setCategory(businessDTO.getCategory());
            businessById.setAddress(businessDTO.getAddress());
            businessById.setCity(businessDTO.getCity());
            businessById.setPostalCode(businessDTO.getPostalCode());
            Business updatedBusiness = this.businessRepository.save(businessById);
            return new RestCommonResponse(true, new Business(
                    updatedBusiness.getUserId(),
                    updatedBusiness.getItemId(),
                    updatedBusiness.getName(),
                    updatedBusiness.getType(),
                    updatedBusiness.getCategory(),
                    updatedBusiness.getAddress(),
                    updatedBusiness.getCity(),
                    updatedBusiness.getPostalCode()
            ));
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.DoesntExist)));
        }
    }

    @Override
    public RestCommonResponse deleteBusiness(long Id) {
        if (this.businessRepository.findById(Id) != null) {
            this.businessRepository.deleteById(Id);
            return new RestCommonResponse(true, "Deleted");
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.DoesntExist)));
        }
    }

    @Override
    public RestCommonResponse saveBusiness(BusinessDTO businessDTO, String name) {
        Business business = this.businessRepository.findByName(name);
        if (business == null) {
            log.info("Saving business to the database");
            return new RestCommonResponse(true, this.businessRepository.save(business));
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.AlreadyRegistered)));
        }
    }

    @Override
    public RestCommonResponse assignBusinessToUser(long userId, long businessId) {
        if (this.userRepository.findById(userId) != null) {
            User user = this.userRepository.findById(userId);
            Business business = this.businessRepository.findById(businessId);
            user.setBusinessId(business);
            return new RestCommonResponse(true, "Business Assigned");
        } else {
            return new RestCommonResponse(false, ErrorResponseApisEnum.DoesntExist);
        }
    }

    @Override
    public User getUser(long userId) {
        log.info("Fetching User");
        return this.userRepository.findById(userId);
    }

    @Override
    public User getUserEmail(String email) {
        log.info("Fetching user");
        return this.userRepository.findByEmail(email);
    }

    @Override
    public RestCommonResponse getAllUsers() {
        log.info("Fetching All Users");
        List<User> user = this.userRepository.findAll();
        return new RestCommonResponse(true, user);
    }

    @Override
    public Business getBusiness(long businessId) {
        log.info("Fetching Business");
        return this.businessRepository.findById(businessId);
    }

    @Override
    public Business getBusinessName(String name) {
        log.info("Fetching Business");
        return this.businessRepository.findByName(name);
    }

    @Override
    public RestCommonResponse getAllBusiness() {
        log.info("Fetching All Business");
        List<Business> businesses = this.businessRepository.findAll();
        return new RestCommonResponse(true, businesses);
    }
}
