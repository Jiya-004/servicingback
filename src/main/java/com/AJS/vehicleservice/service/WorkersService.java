package com.AJS.vehicleservice.service;

import com.AJS.vehicleservice.model.Workers;
import java.util.List;

public interface WorkersService {
    Workers registerMechanic(Workers mechanic);
    List<Workers> findMechanicsByLocation(String location);
    List<Workers> findMechanicsByExpertise(String expertise);
    Workers getMechanicById(Long mechanicId);
    void deleteMechanic(Long mechanicId);
}
