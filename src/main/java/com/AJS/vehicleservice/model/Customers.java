package com.AJS.vehicleservice.model;

import jakarta.persistence.*;

@Entity
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "C_id")
    private Long id;

    @Column(name = "C_name")
    private String name;

    @Column(unique = true, nullable = false,name = "C_email")
    private String email;

    @Column(name = "C_address")
    private String address;

@Column(name = "Registered Date")
    private String date;


    // Getters and Setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }


    public String getDate(){
        return date;
    }
    public void setDate(String date) {
        this.date =date;
    }

}

