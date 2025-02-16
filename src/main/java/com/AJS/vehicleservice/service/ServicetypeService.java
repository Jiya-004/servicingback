package com.AJS.vehicleservice.service;

import com.AJS.vehicleservice.model.Servicetype;

import java.util.List;
import java.util.Optional;

public interface ServicetypeService {
    List<Servicetype> getAllServiceTypes();
    Optional<Servicetype> getServicetypeById(Long id);
    Servicetype saveServicetype(Servicetype servicetype);
    Servicetype updateServicetype(Long id, Servicetype servicetype);
    void deleteServicetype(Long id);
}
