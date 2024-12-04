package com.AJS.vehicleservice.repository;

import com.AJS.vehicleservice.model.Workers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkersRepository extends JpaRepository<Workers,Long> {

    List<Workers> findByLocation(String location);

    List<Workers> findByExpertise(String expertise);
}
