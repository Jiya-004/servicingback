package com.AJS.vehicleservice.controller;

import com.AJS.vehicleservice.model.Workers;
import com.AJS.vehicleservice.repository.WorkersRepository;
import com.AJS.vehicleservice.service.WorkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workers")
public class WorkersController {
    @Autowired
    private WorkersRepository workerRepository;
    @Autowired
    private WorkersService workersService;

    @PostMapping("/add")
    public Workers registerWorker(@RequestBody Workers worker) {
        return workersService.registerWorker(worker);
    }

    @GetMapping("/expertise/{expertise}")
    public List<Workers> findWorkersByExpertise(@PathVariable String expertise) {
        return workersService.findWorkersByExpertise(expertise);
    }

    @GetMapping("/email/{email}")
    public List<Workers> findWorkersByEmail(@PathVariable String email) {
        return workersService.findWorkersByEmail(email);
    }

    @GetMapping("/{id}")
    public Workers getWorkerById(@PathVariable Long id) {
        return workersService.getWorkerById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteWorker(@PathVariable Long id) {
        workersService.deleteWorker(id);
    }

    @GetMapping("/all")
    public List<Workers> getAllWorkers() {
        return workersService.getAllWorkers();
    }
    @PutMapping("/{id}")
    public Workers updateWorker(@PathVariable Long id, @RequestBody Workers updatedWorker) {
        return workersService.updateWorker(id, updatedWorker);
    }
    @GetMapping("/total-workers")
    public ResponseEntity<Map<String, Long>> getTotalWorkers() {
        long count = workerRepository.count();  // Get total workers
        Map<String, Long> response = new HashMap<>();
        response.put("count", count);
        return ResponseEntity.ok(response);
    }
}
