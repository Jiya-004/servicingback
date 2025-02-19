package com.AJS.vehicleservice.controller;

import com.AJS.vehicleservice.model.User;
import com.AJS.vehicleservice.repository.UserRepository;
import com.AJS.vehicleservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService adminService;

    @PostMapping
    public ResponseEntity<User> createAdmin(@RequestBody User user) {
        User createdUser = adminService.createAdmin(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getAdminById(@PathVariable Long id) {
        User user = adminService.getAdminById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllAdmins() {
        List<User> users = adminService.getAllAdmins();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateAdmin(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = adminService.updateAdmin(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<User> getAdminByName(@PathVariable String name) {
        User user = adminService.findByUsername(name);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/total-customers")
    public ResponseEntity<Map<String, Long>> getTotalCustomers() {
        long count = userRepository.count();  // Get total customers
        Map<String, Long> response = new HashMap<>();
        response.put("count", count);
        return ResponseEntity.ok(response);
    }
}
