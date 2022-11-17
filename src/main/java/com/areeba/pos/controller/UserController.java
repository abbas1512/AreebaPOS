package com.areeba.pos.controller;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.UserDTO;
import com.areeba.pos.entity.User;
import com.areeba.pos.services.Impl.UserServiceImpl;
import com.areeba.pos.services.UserService;
import com.mchange.util.AlreadyExistsException;
import io.swagger.annotations.Api;
import org.apache.kafka.common.protocol.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping({"/user"})
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
@Api(tags = "user controller")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceImpl userServiceImpl;

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

    @PostMapping("/register")
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
