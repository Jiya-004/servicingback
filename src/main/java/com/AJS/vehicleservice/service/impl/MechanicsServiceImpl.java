package com.AJS.vehicleservice.service.impl;

import com.AJS.vehicleservice.model.Mechanics;
import com.AJS.vehicleservice.repository.BookingsRepository;
import com.AJS.vehicleservice.repository.MechanicsRepository;
import com.AJS.vehicleservice.repository.ReviewsRepository;
import com.AJS.vehicleservice.service.MechanicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class MechanicsServiceImpl implements MechanicsService {

    @Autowired
    private MechanicsRepository mechanicsRepository;


    @Override
    public Mechanics registerMechanic(Mechanics mechanic) {
        return mechanicsRepository.save(mechanic);
    }

    @Override
    public List<Mechanics> findMechanicsByLocation(String location) {
        return mechanicsRepository.findByLocation(location);
    }

    @Override
    public List<Mechanics> findMechanicsByExpertise(String expertise) {
        return mechanicsRepository.findByExpertise(expertise);
    }

    @Override
    public Mechanics getMechanicById(Long mechanicId) {
        return null;
    }

    public void deleteMechanic( Long id) {
        mechanicsRepository.deleteById(id);
    }



}
