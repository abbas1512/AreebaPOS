package com.areeba.POS.controller;

import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.UserDTO;
import com.areeba.POS.entity.User;
import com.areeba.POS.services.Impl.UserServiceImpl;
import com.areeba.POS.services.UserService;
import com.mchange.util.AlreadyExistsException;
import org.apache.kafka.common.protocol.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping({"/user"})
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private final UserService userService;
    @Autowired
    private final UserServiceImpl userServiceImpl;

    public UserController(AuthenticationManager authenticationManager, UserService userService, UserServiceImpl userServiceImpl) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping
    public User getUsers(long Id) {
        return this.userService.getUser(Id);
    }

    @GetMapping({"/all"})
    public RestCommonResponse getAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping({"/email"})
    public User getUserEmail(String email) {
        return this.userService.getUserEmail(email);
    }

    @PostMapping({"/save"})
    public RestCommonResponse saveUser(@RequestBody UserDTO userDTO) {
        return this.userService.saveUser(userDTO, userDTO.getEmail());
    }

    @PostMapping("/registration")
    public ModelAndView registerUser(@ModelAttribute("user") @Valid UserDTO userDTO,
                                            HttpServletRequest request, Errors errors) {
        try {
            User registered = userService.registerUser(userDTO);
        } catch (AlreadyExistsException alreadyExistsException) {
            ModelAndView mav = null;
            mav.addObject("message", "An account for that email already exists.");
            return mav;
        }
        return new ModelAndView("successRegister", "user", userDTO);
    }

    @PostMapping({"/activate"})
    public RestCommonResponse activateUser(String email) {
        return this.userService.activateUser(email);
    }

    @DeleteMapping({"/{Id}"})
    public RestCommonResponse deleteUser(@PathVariable("Id") long Id) {
        return this.userService.deleteUser(Id);
    }

    @PutMapping(value = {"/{id}"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public RestCommonResponse updateUser(@PathVariable("Id") long Id, @RequestBody UserDTO userDTO) {
        return this.userService.updateUser(Id, userDTO);
    }

    @PutMapping(value = {"/{id}/updatePassword"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public RestCommonResponse updatePassword(@PathVariable("Id") long Id, String password) {
        return this.userService.updatePassword(Id, password);
    }

    @PutMapping(value = {"/{id}/updatePasswordEmail"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public RestCommonResponse updatePasswordEmail(String email, String password) {
        return this.userService.updatePasswordEmail(email, password);
    }
}
