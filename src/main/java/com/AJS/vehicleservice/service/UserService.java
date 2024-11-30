package com.AJS.vehicleservice.service;

import com.AJS.vehicleservice.model.User;
import java.util.List;

public interface UserService {
    User registerUser(User user);
    User getUserById(Long userId);
    User findUserByEmail(String email);
    List<User> getAllUsers();
    void deleteUser(Long userId);
    User findByName(String name);
}
