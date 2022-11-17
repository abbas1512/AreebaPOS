package com.areeba.pos.services.Impl;

import com.areeba.pos.common.ErrorResponseApisEnum;
import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.UserDTO;
import com.areeba.pos.entity.User;
import com.areeba.pos.repository.UserRepository;
import com.areeba.pos.services.UserService;
import com.mchange.util.AlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;
    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(UserDTO userDTO) throws AlreadyExistsException {
        if (emailExists(userDTO.getEmail())) {
            throw new AlreadyExistsException("There is an account with that email address: " + userDTO.getEmail());
        }
        BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
        User user = new User();
        user.setBusinessId(userDTO.getBusinessId());
        user.setEmail(userDTO.getEmail());
        user.setPassword(pwEncoder.encode(userDTO.getPassword()));
        return userRepository.save(user);
    }

    private boolean emailExists(String email) {
        return userRepository.findByEmail(email) != null;
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
                    (ErrorResponseApisEnum.InvalidUser)));
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
                    (ErrorResponseApisEnum.InvalidUser)));
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
                    (ErrorResponseApisEnum.InvalidUser)));
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
                    (ErrorResponseApisEnum.InvalidUser)));
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
}
