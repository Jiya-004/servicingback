package com.AJS.vehicleservice.controller;

import com.AJS.vehicleservice.model.Servicetype;
import com.AJS.vehicleservice.service.ServicetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servicetypes")
public class ServicetypeController {

    @Autowired
    private ServicetypeService servicetypeService;  // Ensure the name matches

    // Get all service types
    @GetMapping
    public ResponseEntity<List<Servicetype>> getAllServiceTypes() {
        List<Servicetype> serviceTypes = servicetypeService.getAllServiceTypes();
        return new ResponseEntity<>(serviceTypes, HttpStatus.OK);
    }

    // Get service type by ID
    @GetMapping("/{id}")
    public ResponseEntity<Servicetype> getServiceTypeById(@PathVariable Long id) {
        Optional<Servicetype> serviceType = servicetypeService.getServicetypeById(id);  // Ensure the name matches
        return serviceType.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new service type
    @PostMapping
    public ResponseEntity<Servicetype> createServiceType(@RequestBody Servicetype servicetype) {
        Servicetype savedServiceType = servicetypeService.saveServicetype(servicetype);  // Ensure the name matches
        return new ResponseEntity<>(savedServiceType, HttpStatus.CREATED);
    }

    // Update an existing service type
    @PutMapping("/{id}")
    public ResponseEntity<Servicetype> updateServiceType(@PathVariable Long id, @RequestBody Servicetype servicetype) {  // Changed from ServiceType to Servicetype
        Servicetype updatedServiceType = servicetypeService.updateServicetype(id, servicetype);  // Ensure the name matches
        return updatedServiceType != null ? new ResponseEntity<>(updatedServiceType, HttpStatus.OK)
                : ResponseEntity.notFound().build();
    }

    // Delete service type by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceType(@PathVariable Long id) {
        servicetypeService.deleteServicetype(id);  // Ensure the name matches
        return ResponseEntity.noContent().build();
    }
}
