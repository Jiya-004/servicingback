package com.AJS.vehicleservice.service.impl;

import com.AJS.vehicleservice.model.Admin;
import com.AJS.vehicleservice.repository.AdminRepository;
import com.AJS.vehicleservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin getAdminById(Long id) {
        Optional<Admin> admin = adminRepository.findById(id);
        return admin.orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin updateAdmin(Long id, Admin updatedAdmin) {
        Admin admin = getAdminById(id); // Check if admin exists
        admin.setName(updatedAdmin.getName());
        admin.setPassword(updatedAdmin.getPassword());
        return adminRepository.save(admin);
    }

    @Override
    public void deleteAdmin(Long id) {
        Admin admin = getAdminById(id); // Check if admin exists
        adminRepository.delete(admin);
    }

    @Override
    public Admin findByName(String name) {
        Optional<Admin> admin = adminRepository.findByName(name);
        return admin.orElseThrow(() -> new RuntimeException("Admin not found with name: " + name));
    }
}
