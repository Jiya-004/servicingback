package com.AJS.vehicleservice.service;

import com.AJS.vehicleservice.model.Workers;
import java.util.List;

public interface WorkersService {
    Workers registerWorker(Workers worker);
    List<Workers> findWorkersByExpertise(String expertise);
    List<Workers> findWorkersByEmail(String email);
    Workers getWorkerById(Long workerId);
    void deleteWorker(Long workerId);
    List<Workers> getAllWorkers();

    Workers updateWorker(Long id, Workers updatedWorker);
}
