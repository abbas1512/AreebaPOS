package com.areeba.pos.controller;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.UserDTO;
import com.areeba.pos.entity.User;
import com.areeba.pos.services.Impl.UserServiceImpl;
import com.areeba.pos.services.UserService;
import com.mchange.util.AlreadyExistsException;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping({"/user"})
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping({"/id/{id}"})
    public User getUser(@PathVariable long id) {
        return this.userService.getUser(id);
    }

    @GetMapping({"/all"})
    public RestCommonResponse getAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping({"/email/{email}"})
    public User getUserEmail(@PathVariable String email) {
        return this.userService.getUserEmail(email);
    }


    @PostMapping("/register")
    public User registerUser(@RequestBody UserDTO userDTO) throws AlreadyExistsException {
        return this.userService.registerUser(userDTO);
    }

    @DeleteMapping({"/delete/{id}"})
    public RestCommonResponse deleteUser(@PathVariable("id") long id) {
        return this.userService.deleteUser(id);
    }

    @PutMapping(value = {"/update/{id}"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public RestCommonResponse updateUser(@PathVariable("id") long id, @RequestBody UserDTO userDTO) {
        return this.userService.updateUser(id, userDTO);
    }

    @PutMapping(value = {"/updatePassword/{id}"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public RestCommonResponse updatePassword(@PathVariable("id") long id, String password) {
        return this.userService.updatePassword(id, password);
    }

    @PutMapping(value = {"/updatePasswordEmail/{id}"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public RestCommonResponse updatePasswordEmail(String email, String password) {
        return this.userService.updatePasswordEmail(email, password);
    }
}
