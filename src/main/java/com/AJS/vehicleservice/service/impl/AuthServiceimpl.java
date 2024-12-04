package com.AJS.vehicleservice.service.impl;

import com.AJS.vehicleservice.model.Admin;
import com.AJS.vehicleservice.model.Customers;
import com.AJS.vehicleservice.service.AdminService;
import com.AJS.vehicleservice.service.AuthService;
import com.AJS.vehicleservice.service.CustomersService;
import com.AJS.vehicleservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class AuthServiceImpl implements AuthService {

    @Autowired
    private AdminService adminService;

    @Override
    public String login(String name, String password) {
        Admin admin=  adminService.findByName(name);
        if(admin ==null||!admin.getPassword().equals(password)){
            throw new RuntimeException("login failed!");

        } else {


            return JwtUtil.generateToken(admin);
        }
    }

    @Override
    public boolean changePassword(String oldPassword, String newPassword) {
        return false;
    }
}