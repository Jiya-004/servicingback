package com.AJS.vehicleservice.service;

import com.AJS.vehicleservice.model.Bookings;
import java.util.List;

public interface BookingsService {
    Bookings createBooking(Bookings booking);
    List<Bookings> getBookingsByUserId(Long userId);
    List<Bookings> getBookingsByWorkerId(Long workerId);
    Bookings getBookingById(Long bookingId);
    void deleteBooking(Long bookingId);
}
