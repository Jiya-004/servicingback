package com.AJS.vehicleservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private Long feedback_id;

    @Column(name = "name")
    private String name;

    @Column
    private String message;

    // Getter for feedback_id
    public Long getFeedback_id() {
        return feedback_id;
    }

    // Setter for feedback_id
    public void setFeedback_id(Long feedback_id) {
        this.feedback_id = feedback_id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for message
    public String getMessage() {
        return message;
    }

    // Setter for message
    public void setMessage(String message) {
        this.message = message;
    }
}
