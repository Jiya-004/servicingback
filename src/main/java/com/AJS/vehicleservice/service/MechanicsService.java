package com.AJS.vehicleservice.service;

import com.AJS.vehicleservice.model.Mechanics;
import java.util.List;

public interface MechanicsService {
    Mechanics registerMechanic(Mechanics mechanic);
    List<Mechanics> findMechanicsByLocation(String location);
    List<Mechanics> findMechanicsByExpertise(String expertise);
    Mechanics getMechanicById(Long mechanicId);
    void deleteMechanic(Long mechanicId);
}
