package com.synergen.vitos.controller;

import com.synergen.vitos.dto.LoginDTO;
import com.synergen.vitos.dto.LoginResponse;
import com.synergen.vitos.dto.UserResponse;
import com.synergen.vitos.dto.ValidationError;
import com.synergen.vitos.enums.RecordStatusEnum;
import com.synergen.vitos.enums.ResponseEnum;
import com.synergen.vitos.model.User;
import com.synergen.vitos.service.PasswordService;
import com.synergen.vitos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="*")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public UserResponse createUser(@RequestBody User user) {

        UserResponse response = new UserResponse();

        response = userService.createUser(user);
                
        return response;


    }

    @GetMapping
    public UserResponse getAllUser(){

        UserResponse response = new UserResponse();
        response = userService.getAllUser();
        return response;
    }

    @PostMapping("/login")
    public LoginResponse authenticate(ServletRequest request, @RequestBody LoginDTO loginDTO, HttpServletResponse resp){

        LoginResponse response = new LoginResponse();
        response = userService.authenticate(loginDTO);
        return response;

    }
}
