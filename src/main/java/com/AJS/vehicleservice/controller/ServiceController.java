package com.AJS.vehicleservice.controller;

import com.AJS.vehicleservice.model.Service;
import com.AJS.vehicleservice.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping
    public ResponseEntity<Service> addService(@RequestBody Service service) {
        Service createdService = serviceService.addService(service);
        return ResponseEntity.ok(createdService);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Service> getServiceById(@PathVariable Long id) {
        Service service = serviceService.getServiceById(id);
        return ResponseEntity.ok(service);
    }

    @GetMapping("/vehicle/{vehicleNumber}")
    public ResponseEntity<List<Service>> getServicesByVehicleNumber(@PathVariable String vehicleNumber) {
        List<Service> services = serviceService.getServicesByVehicleNumber(vehicleNumber);
        return ResponseEntity.ok(services);
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<Service>> getServicesByOwnerId(@PathVariable Long ownerId) {
        List<Service> services = serviceService.getServicesByOwnerId(ownerId);
        return ResponseEntity.ok(services);
    }

    @GetMapping
    public ResponseEntity<List<Service>> getAllServices() {
        List<Service> services = serviceService.getAllServices();
        return ResponseEntity.ok(services);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Service> updateService(@PathVariable Long id, @RequestBody Service service) {
        Service updatedService = serviceService.updateService(id, service);
        return ResponseEntity.ok(updatedService);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
        return ResponseEntity.noContent().build();
    }
}

