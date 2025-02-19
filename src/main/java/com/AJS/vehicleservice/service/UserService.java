package com.AJS.vehicleservice.service;

import com.AJS.vehicleservice.model.User;

import java.util.List;

public interface UserService {
    User createAdmin(User user);
    User getAdminById(Long id);
    List<User> getAllAdmins();
    User updateAdmin(Long id, User user);
    void deleteAdmin(Long id);

    User findByUsername(String username);
}
