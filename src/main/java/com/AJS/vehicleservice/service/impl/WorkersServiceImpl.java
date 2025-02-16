package com.AJS.vehicleservice.service.impl;

import com.AJS.vehicleservice.model.Workers;
import com.AJS.vehicleservice.repository.WorkersRepository;
import com.AJS.vehicleservice.service.WorkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkersServiceImpl implements WorkersService {

    @Autowired
    private WorkersRepository workersRepository;

    @Override
    public Workers registerWorker(Workers worker) {
        return workersRepository.save(worker);
    }

    @Override
    public List<Workers> findWorkersByExpertise(String expertise) {
        return workersRepository.findByExpertise(expertise);
    }

    @Override
    public List<Workers> findWorkersByEmail(String email) {
        return workersRepository.findByEmail(email);
    }

    @Override
    public Workers getWorkerById(Long workerId) {
        Optional<Workers> worker = workersRepository.findById(workerId);
        return worker.orElse(null);
    }

    @Override
    public void deleteWorker(Long id) {
        workersRepository.deleteById(id);
    }

    @Override
    public List<Workers> getAllWorkers() {
        return workersRepository.findAll();
    }
    @Override
    public Workers updateWorker(Long id, Workers updatedWorker) {
        Optional<Workers> existingWorker = workersRepository.findById(id);
        if (existingWorker.isPresent()) {
            Workers worker = existingWorker.get();
            worker.setFirstName(updatedWorker.getFirstName());
            worker.setLastName(updatedWorker.getLastName());
            worker.setExpertise(updatedWorker.getExpertise());
            worker.setEmail(updatedWorker.getEmail());
            worker.setContactInfo(updatedWorker.getContactInfo());
            worker.setAddress(updatedWorker.getAddress());
            return workersRepository.save(worker);
        }
        return null; // Return null if the worker is not found
    }
}
