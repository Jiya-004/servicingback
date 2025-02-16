package com.AJS.vehicleservice.repository;

import com.AJS.vehicleservice.model.Servicetype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicetypeRepository extends JpaRepository<Servicetype, Long> {
    // Custom query methods (if needed) can be added here
}
