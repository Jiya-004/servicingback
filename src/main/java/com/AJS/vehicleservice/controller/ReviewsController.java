package com.AJS.vehicleservice.controller;

import com.AJS.vehicleservice.model.Reviews;
import com.AJS.vehicleservice.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {

    @Autowired
    private ReviewsService reviewsService;

    @PostMapping("/add")
    public Reviews addReview(@RequestBody Reviews review) {
        System.out.println("Incoming review: " + review);
        return reviewsService.addReview(review);
    }


    @GetMapping("/worker/{workerId}")
    public List<Reviews> getReviewsByWorkerId(@PathVariable Long workerId) {
        return reviewsService.getReviewsByWorkerId(workerId);
    }

    @GetMapping("/user/{userId}")
    public List<Reviews> getReviewsByUserId(@PathVariable Long userId) {
        return reviewsService.getReviewsByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewsService.deleteReview(id);
    }
}
