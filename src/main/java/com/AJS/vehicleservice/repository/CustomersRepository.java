package com.AJS.vehicleservice.repository;

import com.AJS.vehicleservice.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {
    // Find a user by email (useful for login)
    Customers findByEmail(String email);

    // Check if a user exists by email
    boolean existsByEmail(String email);

    // Find a user by username
    Customers findByUsername(String username);

    // Check if a user exists by username
    boolean existsByUsername(String username);
}