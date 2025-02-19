package com.AJS.vehicleservice.service.impl;

import com.AJS.vehicleservice.dto.LoginResponseDto;
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
    public LoginResponseDto login(String username, String password, String role) {
        User user = userService.findByUsername(username);
        if (user == null || !user.getPassword().equals(password) || !user.getRole().equals(role)) {
            throw new RuntimeException("Login failed. Invalid credentials or role mismatch.");
        }

        // Generate JWT token
        String token = JwtUtil.generateToken(user);

        // Return both token and userId
        return new LoginResponseDto(token, (long) user.getId(), role);
    }

    @Override
    public boolean changePassword(String oldPassword, String newPassword) {
        return false;
    }
}