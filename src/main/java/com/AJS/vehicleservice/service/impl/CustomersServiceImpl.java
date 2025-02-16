package com.AJS.vehicleservice.service.impl;

import com.AJS.vehicleservice.model.Customers;
import com.AJS.vehicleservice.repository.CustomersRepository;
import com.AJS.vehicleservice.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
    public Customers findByUsername(String username) {
        return customersRepository.findByUsername(username);
    }

    @Override
    public Customers updateUser(Long id, Customers updatedCustomer) {
        Optional<Customers> existingCustomer = customersRepository.findById(id);
        if (existingCustomer.isPresent()) {
            Customers customer = existingCustomer.get();
            customer.setFirstname(updatedCustomer.getFirstname());
            customer.setLastname(updatedCustomer.getLastname());
            customer.setAddress(updatedCustomer.getAddress());
            customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
            customer.setEmail(updatedCustomer.getEmail());
            customer.setUsername(updatedCustomer.getUsername());
            return customersRepository.save(customer);
        }
        return null; // Return null if the user is not found
    }

}