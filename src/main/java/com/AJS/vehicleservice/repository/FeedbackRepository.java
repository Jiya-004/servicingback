package com.AJS.vehicleservice.repository;

import com.AJS.vehicleservice.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    // You can add custom queries if needed (e.g., find by name, etc.)
}
