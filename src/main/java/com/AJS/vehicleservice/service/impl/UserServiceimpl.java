package com.AJS.vehicleservice.service.impl;

import com.AJS.vehicleservice.model.User;
import com.AJS.vehicleservice.repository.UserRepository;
import com.AJS.vehicleservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createAdmin(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getAdminById(Long id) {
        Optional<User> admin = userRepository.findById(id);
        return admin.orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public List<User> getAllAdmins() {
        return userRepository.findAll();
    }

    @Override
    public User updateAdmin(Long id, User updatedUser) {
        User user = getAdminById(id);
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setEmail(updatedUser.getEmail());
        user.setPhoneNumber(updatedUser.getPhoneNumber());
        user.setAddress(updatedUser.getAddress());
        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        user.setRole(updatedUser.getRole());
        return userRepository.save(user);
    }

    @Override
    public void deleteAdmin(Long id) {
        User user = getAdminById(id);
        userRepository.delete(user);
    }



    @Override
    public User findByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.orElseThrow(() -> new RuntimeException("User not found with username: " + username));
    }

}
