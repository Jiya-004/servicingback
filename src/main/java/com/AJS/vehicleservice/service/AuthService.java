package com.AJS.vehicleservice.service;

public interface AuthService {
    String login(String name, String password);
    boolean changePassword(String oldPassword, String newPassword);
}