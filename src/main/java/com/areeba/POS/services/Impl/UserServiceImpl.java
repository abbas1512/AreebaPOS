package com.areeba.POS.services.Impl;

import com.areeba.POS.common.ErrorResponseApisEnum;
import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.UserDTO;
import com.areeba.POS.entity.User;
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
    private static final Logger log = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
    public User findById(long Id) {
        log.info("Fetching user");
        return this.userRepository.findById(Id);
    }

    @Override
    public User findByEmail(String email) {
        log.info("Fetching user");
        return this.userRepository.findByEmail(email);
    }

    @Override
    public RestCommonResponse getAll() {
        log.info("Fetching All Users");
        List<User> user = this.userRepository.findAll();
        return new RestCommonResponse(true, user);
    }
}
