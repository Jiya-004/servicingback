package com.AJS.vehicleservice.model;

import jakarta.persistence.*;

@Entity
public class Workers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String expertise; // e.g., mechanic, electrician

    @Column(nullable = false)
    private String location;

    @Enumerated(EnumType.STRING)
    private Availability availability;

    @Column(name = "contact_info")
    private String contactInfo;

    public enum Availability {
        AVAILABLE,
        BUSY
    }
//methods
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }
    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

}

