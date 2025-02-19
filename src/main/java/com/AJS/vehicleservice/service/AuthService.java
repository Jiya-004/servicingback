package com.AJS.vehicleservice.service;

import com.AJS.vehicleservice.dto.LoginResponseDto;

public interface AuthService {
    LoginResponseDto login(String username, String password, String role);
    boolean changePassword(String oldPassword, String newPassword);
}