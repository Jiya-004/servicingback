package com.AJS.vehicleservice.service.impl;

import com.AJS.vehicleservice.model.Service;
import com.AJS.vehicleservice.repository.ServiceRepository;
import com.AJS.vehicleservice.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public Service addService(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public Service getServiceById(Long serviceId) {
        return serviceRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service not found with id: " + serviceId));
    }

    @Override
    public List<Service> getServicesByVehicleNumber(String vehicleNumber) {
        return serviceRepository.findByVehicleNumber(vehicleNumber);
    }

    @Override
    public List<Service> getServicesByOwnerName(String ownerName) {
        return serviceRepository.findByOwnerName(ownerName);
    }

    @Override
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    @Override
    public Service updateService(Long serviceId, Service service) {
        Service existingService = getServiceById(serviceId);
        existingService.setVehicleNumber(service.getVehicleNumber());
        existingService.setOwnerName(service.getOwnerName());
        existingService.setServiceType(service.getServiceType());
        existingService.setServiceCost(service.getServiceCost());
        return serviceRepository.save(existingService);
    }

    @Override
    public void deleteService(Long serviceId) {
        Service service = getServiceById(serviceId);
        serviceRepository.delete(service);
    }
}