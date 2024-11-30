package com.AJS.vehicleservice.controller;

import com.AJS.vehicleservice.model.Bookings;
import com.AJS.vehicleservice.service.BookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingsController {

    @Autowired
    private BookingsService bookingsService;

    @PostMapping
    public Bookings createBooking(@RequestBody Bookings booking) {
        return bookingsService.createBooking(booking);
    }

    @GetMapping("/user/{userId}")
    public List<Bookings> getBookingsByUserId(@PathVariable Long userId) {
        return bookingsService.getBookingsByUserId(userId);
    }

    @GetMapping("/worker/{workerId}")
    public List<Bookings> getBookingsByWorkerId(@PathVariable Long workerId) {
        return bookingsService.getBookingsByWorkerId(workerId);
    }

    @GetMapping("/{id}")
    public Bookings getBookingById(@PathVariable Long id) {
        return bookingsService.getBookingById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingsService.deleteBooking(id);
    }
}

