package com.AJS.vehicleservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Table(name="auth")
public class Auth {

    private String username;
    @Column(nullable = false)
    private String password;
    private String role;
    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }
    public String getRole(){
        return role;
    }
}