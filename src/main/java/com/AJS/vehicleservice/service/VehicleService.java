package com.AJS.vehicleservice.service;

import com.AJS.vehicleservice.model.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle addVehicle(Vehicle vehicle);
    Vehicle getVehicleById(Long id);
    Vehicle getVehicleByNumber(String vehicleNumber);
    List<Vehicle> getAllVehicles();
    Vehicle updateVehicle(Long id, Vehicle vehicle);
    void deleteVehicle(Long id);
}
