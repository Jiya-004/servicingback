package com.AJS.vehicleservice.controller;

import com.AJS.vehicleservice.model.Service;
import com.AJS.vehicleservice.repository.ServiceRepository;
import com.AJS.vehicleservice.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private ServiceService serviceService;

    @PostMapping
    public ResponseEntity<Service> addService(@RequestBody Service service) {
        service.setStatus("Pending"); // Set default status to Pending
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

    @GetMapping("/owner/{ownerName}")
    public ResponseEntity<List<Service>> getServicesByOwnerName(@PathVariable String ownerName) {
        List<Service> services = serviceService.getServicesByOwnerName(ownerName);
        return ResponseEntity.ok(services);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Service>> getServicesByUserId(@PathVariable Long userId) {
        List<Service> services = serviceService.getServicesByUserId(userId);
        return ResponseEntity.ok(services);
    }

    @GetMapping
    public ResponseEntity<List<Service>> getAllServices() {
        List<Service> services = serviceService.getAllServices();
        return ResponseEntity.ok(services);
    }

    @GetMapping("/status/{status}") // New endpoint to get services by status
    public ResponseEntity<List<Service>> getServicesByStatus(@PathVariable String status) {
        List<Service> services = serviceService.getServicesByStatus(status);
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

    @PutMapping("/approve/{id}") // Endpoint to approve service
    public ResponseEntity<Service> approveService(@PathVariable Long id) {
        Service approvedService = serviceService.approveService(id);
        return ResponseEntity.ok(approvedService);
    }

    @GetMapping("/total-services-made")
    public ResponseEntity<Map<String, Long>> getTotalServicesMade() {
        long count = serviceRepository.count();  // Get total services made
        Map<String, Long> response = new HashMap<>();
        response.put("count", count);
        return ResponseEntity.ok(response);
    }
}
