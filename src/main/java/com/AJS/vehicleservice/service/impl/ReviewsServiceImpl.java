package com.AJS.vehicleservice.service.impl;

import com.AJS.vehicleservice.model.Reviews;
import com.AJS.vehicleservice.repository.ReviewsRepository;
import com.AJS.vehicleservice.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewsServiceImpl implements ReviewsService {

    @Autowired
    private ReviewsRepository reviewsRepository;

    @Override
    public Reviews addReview(Reviews review) {
        return reviewsRepository.save(review);
    }

    @Override
    public List<Reviews> getReviewsByWorkerId(Long workerId) {
        return reviewsRepository.findByWorker_Id(workerId);
    }

    @Override
    public List<Reviews> getReviewsByUserId(Long userId) {
        return reviewsRepository.findByUser_Id(userId);
    }

    @Override
    public void deleteReview(Long reviewId) {
        reviewsRepository.deleteById(reviewId);
    }
}
