package com.AJS.vehicleservice.service.impl;

import com.AJS.vehicleservice.model.User;
import com.AJS.vehicleservice.service.AuthService;
import com.AJS.vehicleservice.service.UserService;
import com.AJS.vehicleservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class AuthServiceImpl implements AuthService {

    @Autowired
    private UserService userService;

    @Override
    public String login(String name, String password) {
        User user = userService.findByName(name);
        if(user==null||!user.getPassword().equals(password)){
            throw new RuntimeException("login failed!");

        } else {


            return JwtUtil.generateToken(user);
        }
    }

    @Override
    public boolean changePassword(String oldPassword, String newPassword) {
        return false;
    }
}