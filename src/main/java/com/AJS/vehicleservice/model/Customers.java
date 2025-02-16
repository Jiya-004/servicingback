package com.AJS.vehicleservice.model;

import jakarta.persistence.*;

@Entity
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "C_id")
    private Long id;

    @Column(name = "First Name", nullable = false)
    private String firstname;

    @Column(name = "Last Name", nullable = false)
    private String lastname;

    @Column(name = "Username", unique = true, nullable = false)
    private String username;

    @Column(name = "Address")
    private String address;

    @Column(name = "Phone Number", unique = true, nullable = false)
    private String phoneNumber;

    @Column(name = "Email", unique = true, nullable = false)
    private String email;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}