package com.marketplace.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.marketplace.entity.Booking;
import com.marketplace.entity.BookingStatus;
import com.marketplace.repository.BookingRepository;

@Service
public class BookingService {

    private final BookingRepository repo;

    public BookingService(BookingRepository repo) {
        this.repo = repo;
    }

    public Booking createBooking(Booking booking) {
        booking.setBookingTime(LocalDateTime.now());
        booking.setStatus(BookingStatus.PENDING);
        return repo.save(booking);
    }
    
    public Booking acceptBooking(Long id) {

        Booking booking = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setStatus(BookingStatus.ACCEPTED);
        return repo.save(booking);
    }

    public Booking completeBooking(Long id) {

        Booking booking = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setStatus(BookingStatus.COMPLETED);
        return repo.save(booking);
    }

    public List<Booking> getAllBookings() {
        return repo.findAll();
    }
}