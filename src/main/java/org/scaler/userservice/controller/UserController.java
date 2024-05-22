package org.scaler.userservice.controller;

import org.scaler.userservice.dtos.SignUpRequest;
import org.scaler.userservice.dtos.UserDto;
import org.scaler.userservice.models.User;
import org.scaler.userservice.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }


    @PostMapping("/signup")
    public UserDto signUp(@RequestBody SignUpRequest request){
        User u =  userService.signUp(request.getEmail(), request.getPassword(), request.getName());

        return UserDto.from(u);
    }



}
