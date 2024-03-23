package com.example.back_end.controller;


import com.example.back_end.entity.JwtRequest;
import com.example.back_end.entity.JwtResponse;
import com.example.back_end.entity.User;
import com.example.back_end.service.AuthService;
import com.example.back_end.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/permit")
//@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @PostMapping({"/login"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return authService.createJwtToken(jwtRequest);
    }
    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user) {

        return userService.registerNewUser(user);
    }
}
