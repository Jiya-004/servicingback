package com.AJS.vehicleservice.service;

import com.AJS.vehicleservice.model.Service;

import java.util.List;

public interface ServiceService {
    Service addService(Service service);
    Service getServiceById(Long serviceId);
    List<Service> getServicesByVehicleNumber(String vehicleNumber);
    List<Service> getServicesByOwnerName(String ownerName); // Updated method name
    List<Service> getAllServices();
    Service updateService(Long serviceId, Service service);
    void deleteService(Long serviceId);
}