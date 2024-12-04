package com.AJS.vehicleservice.service.impl;

import com.AJS.vehicleservice.model.Vehicle;
import com.AJS.vehicleservice.repository.VehicleRepository;
import com.AJS.vehicleservice.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id));
    }

    @Override
    public Vehicle getVehicleByNumber(String vehicleNumber) {
        return vehicleRepository.findByVehicleNumber(vehicleNumber)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with number: " + vehicleNumber));
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle updateVehicle(Long id, Vehicle vehicle) {
        Vehicle existingVehicle = getVehicleById(id);
        existingVehicle.setVehicleNumber(vehicle.getVehicleNumber());
        existingVehicle.setCustomer(vehicle.getCustomer());
        existingVehicle.setVehicleModel(vehicle.getVehicleModel());
        existingVehicle.setFuelType(vehicle.getFuelType());
        existingVehicle.setDate(vehicle.getDate());
        return vehicleRepository.save(existingVehicle);
    }

    @Override
    public void deleteVehicle(Long id) {
        Vehicle vehicle = getVehicleById(id);
        vehicleRepository.delete(vehicle);
    }
}

