package com.AJS.vehicleservice.service.impl;

import com.AJS.vehicleservice.model.Customers;
import com.AJS.vehicleservice.repository.CustomersRepository;
import com.AJS.vehicleservice.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomersServiceImpl implements CustomersService {

    @Autowired
    private CustomersRepository customersRepository;

    @Override
    public Customers registerUser(Customers customers) {
        return customersRepository.save(customers);
    }

    @Override
    public Customers getUserById(Long userId) {
        return customersRepository.findById(userId).orElse(null);
    }

    @Override
    public Customers findUserByEmail(String email) {
        return customersRepository.findByEmail(email);
    }

    @Override
    public List<Customers> getAllUsers() {
        return customersRepository.findAll();
    }

    @Override
    public void deleteUser(Long userId) {
        customersRepository.deleteById(userId);
    }

    @Override
    public Customers findByName(String name) {
        return customersRepository.findByName(name);
    }

}