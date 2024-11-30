package com.AJS.vehicleservice.controller;

import com.AJS.vehicleservice.model.Mechanics;
import com.AJS.vehicleservice.service.MechanicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mechanics")
public class MechanicsController{

    @Autowired
    private MechanicsService mechanicsService;

    @PostMapping("/add")
    public Mechanics registerMechanic(@RequestBody Mechanics mechanic) {
        return mechanicsService.registerMechanic(mechanic);
    }

    @GetMapping("/location/{location}")
    public List<Mechanics> findMechanicsByLocation(@PathVariable String location) {
        return mechanicsService.findMechanicsByLocation(location);
    }

    @GetMapping("/expertise/{expertise}")
    public List<Mechanics> findMechanicsByExpertise(@PathVariable String expertise) {
        return mechanicsService.findMechanicsByExpertise(expertise);
    }

    @GetMapping("/{id}")
    public Mechanics getMechanicById(@PathVariable Long id) {
        return mechanicsService.getMechanicById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMechanic(@PathVariable Long id) {
         mechanicsService.deleteMechanic(id);
    }

}

