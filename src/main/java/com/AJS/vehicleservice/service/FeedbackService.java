package com.AJS.vehicleservice.service;

import com.AJS.vehicleservice.model.Feedback;
import java.util.List;
import java.util.Optional;

public interface FeedbackService {
    Feedback saveFeedback(Feedback feedback);
    Optional<Feedback> getFeedbackById(Long id);
    List<Feedback> getAllFeedbacks();
    void deleteFeedback(Long id);
    Feedback updateFeedback(Long id, Feedback feedback);
}
