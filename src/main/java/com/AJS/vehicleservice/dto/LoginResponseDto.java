package com.AJS.vehicleservice.dto;

public class LoginResponseDto {
    private String token;
    private Long userId;
    private String userRole;

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public LoginResponseDto(String token, Long userId, String userRole) {
        this.token = token;
        this.userId = userId;
        this.userRole= userRole;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}