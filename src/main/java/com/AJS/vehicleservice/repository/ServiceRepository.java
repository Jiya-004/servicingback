package com.AJS.vehicleservice.repository;

import com.AJS.vehicleservice.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    List<Service> findByVehicleNumber(String vehicleNumber); // Find services by vehicle number
    List<Service> findByOwnerName(String ownerName); // Find services by owner name
    List<Service> findByUserId(Long userId); // Find services by userId

    List<Service> findByStatus(String status);
}
