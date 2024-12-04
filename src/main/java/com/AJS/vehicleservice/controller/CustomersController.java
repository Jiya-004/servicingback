package com.AJS.vehicleservice.controller;

import com.AJS.vehicleservice.model.Customers;
import com.AJS.vehicleservice.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class CustomersController {

    @Autowired
    private CustomersService customersService;

    @PostMapping("/add")
    public Customers registerUser(@RequestBody Customers customers) {
        return customersService.registerUser(customers);
    }

    @GetMapping("/{id}")
    public Customers getUserById(@PathVariable Long id) {
        return customersService.getUserById(id);
    }

    @GetMapping("/email/{email}")
    public Customers findUserByEmail(@PathVariable String email) {
        return customersService.findUserByEmail(email);
    }

    @GetMapping("/list")
    public List<Customers> getAllUsers() {
        return customersService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        customersService.deleteUser(id);
    }
}
