package com.AJS.vehicleservice.service;

import com.AJS.vehicleservice.model.Admin;
import com.AJS.vehicleservice.model.Customers;

import java.util.List;

public interface AdminService {
    Admin createAdmin(Admin admin);
    Admin getAdminById(Long id);
    List<Admin> getAllAdmins();
    Admin updateAdmin(Long id, Admin admin);
    void deleteAdmin(Long id);
  Admin findByName(String name);
}
