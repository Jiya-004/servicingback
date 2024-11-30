package com.AJS.vehicleservice.repository;

import com.AJS.vehicleservice.model.Mechanics;
import com.AJS.vehicleservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MechanicsRepository extends JpaRepository<Mechanics,Long> {

    List<Mechanics> findByLocation(String location);

    List<Mechanics> findByExpertise(String expertise);
}
