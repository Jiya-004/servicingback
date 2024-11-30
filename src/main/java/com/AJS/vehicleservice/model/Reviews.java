package com.AJS.vehicleservice.model;

import jakarta.persistence.*;

@Entity
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user; // Ensure this field exists and is correctly mapped to the User entity

    @OneToOne
    @JoinColumn(name = "worker_id",nullable = false)
    private Mechanics worker; // Ensure this field exists and is mapped to Mechanics

    private String reviewText;
    private int rating;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Mechanics getWorker() {
        return worker;
    }

    public void setWorker(Mechanics worker) {
        this.worker = worker;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }



}
