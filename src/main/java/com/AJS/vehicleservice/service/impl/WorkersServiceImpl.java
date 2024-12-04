package com.AJS.vehicleservice.service.impl;

import com.AJS.vehicleservice.model.Workers;
import com.AJS.vehicleservice.repository.WorkersRepository;
import com.AJS.vehicleservice.service.WorkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkersServiceImpl implements WorkersService {

    @Autowired
    private WorkersRepository workersRepository;


    @Override
    public Workers registerMechanic(Workers mechanic) {
        return workersRepository.save(mechanic);
    }

    @Override
    public List<Workers> findMechanicsByLocation(String location) {
        return workersRepository.findByLocation(location);
    }

    @Override
    public List<Workers> findMechanicsByExpertise(String expertise) {
        return workersRepository.findByExpertise(expertise);
    }

    @Override
    public Workers getMechanicById(Long mechanicId) {
        return null;
    }

    public void deleteMechanic( Long id) {
        workersRepository.deleteById(id);
    }



}
