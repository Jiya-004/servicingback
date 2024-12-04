package com.AJS.vehicleservice.service;

import com.AJS.vehicleservice.model.Customers;
import java.util.List;

public interface CustomersService {
    Customers registerUser(Customers customers);
    Customers getUserById(Long userId);
    Customers findUserByEmail(String email);
    List<Customers> getAllUsers();
    void deleteUser(Long userId);
    Customers findByName(String name);
}
