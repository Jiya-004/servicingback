package com.AJS.vehicleservice.controller;

import com.AJS.vehicleservice.dto.LoginDto;
import com.AJS.vehicleservice.dto.LoginResponseDto;
import com.AJS.vehicleservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto) {
        LoginResponseDto response = authService.login(
                loginDto.getUsername(), loginDto.getPassword(), loginDto.getRole()
        );
        return ResponseEntity.ok(response);
    }
}