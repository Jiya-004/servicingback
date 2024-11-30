package com.AJS.vehicleservice.service.impl;

import com.AJS.vehicleservice.model.Bookings;
import com.AJS.vehicleservice.repository.BookingsRepository;
import com.AJS.vehicleservice.service.BookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
class BookingsServiceImpl implements BookingsService {

    @Autowired
    private BookingsRepository bookingsRepository;

    @Override
    public Bookings createBooking(Bookings booking) {
        return bookingsRepository.save(booking);
    }

    @Override
    public List<Bookings> getBookingsByUserId(Long userId) {
        return bookingsRepository.findByUser_Id(userId);
    }

    @Override
    public List<Bookings> getBookingsByWorkerId(Long workerId) {
        return bookingsRepository.findByWorker_Id(workerId);
    }

    @Override
    public Bookings getBookingById(Long bookingId) {
        return bookingsRepository.findById(bookingId).orElse(null);
    }

    @Override
    public void deleteBooking(Long bookingId) {
        bookingsRepository.deleteById(bookingId);
    }
}
