package com.AJS.vehicleservice.controller;

import com.AJS.vehicleservice.model.Workers;
import com.AJS.vehicleservice.service.WorkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mechanics")
public class WorkersController {

    @Autowired
    private WorkersService workersService;

    @PostMapping("/add")
    public Workers registerMechanic(@RequestBody Workers mechanic) {
        return workersService.registerMechanic(mechanic);
    }

    @GetMapping("/location/{location}")
    public List<Workers> findMechanicsByLocation(@PathVariable String location) {
        return workersService.findMechanicsByLocation(location);
    }

    @GetMapping("/expertise/{expertise}")
    public List<Workers> findMechanicsByExpertise(@PathVariable String expertise) {
        return workersService.findMechanicsByExpertise(expertise);
    }

    @GetMapping("/{id}")
    public Workers getMechanicById(@PathVariable Long id) {
        return workersService.getMechanicById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMechanic(@PathVariable Long id) {
         workersService.deleteMechanic(id);
    }

}

