package com.AJS.vehicleservice.service;

import com.AJS.vehicleservice.model.Reviews;
import java.util.List;

public interface ReviewsService {
    Reviews addReview(Reviews review);
    List<Reviews> getReviewsByWorkerId(Long workerId);
    List<Reviews> getReviewsByUserId(Long userId);
    void deleteReview(Long reviewId);
}
