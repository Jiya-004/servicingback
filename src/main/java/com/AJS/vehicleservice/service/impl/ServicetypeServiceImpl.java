package com.AJS.vehicleservice.service.impl;

import com.AJS.vehicleservice.model.Servicetype;
import com.AJS.vehicleservice.repository.ServicetypeRepository;
import com.AJS.vehicleservice.service.ServicetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicetypeServiceImpl implements ServicetypeService {

    @Autowired
    private ServicetypeRepository servicetypeRepository;

    @Override
    public List<Servicetype> getAllServiceTypes() {
        return servicetypeRepository.findAll();
    }

    @Override
    public Optional<Servicetype> getServicetypeById(Long id) {
        return servicetypeRepository.findById(id);
    }

    @Override
    public Servicetype saveServicetype(Servicetype servicetype) {
        return servicetypeRepository.save(servicetype);
    }

    @Override
    public Servicetype updateServicetype(Long id, Servicetype servicetype) {
        if (servicetypeRepository.existsById(id)) {
            servicetype.setId(id);  // Ensure the ID is set correctly
            return servicetypeRepository.save(servicetype);
        }
        return null;
    }

    @Override
    public void deleteServicetype(Long id) {
        servicetypeRepository.deleteById(id);
    }

    @Override
    public long getTotalServiceTypes() {
        return servicetypeRepository.count();
    }
}
