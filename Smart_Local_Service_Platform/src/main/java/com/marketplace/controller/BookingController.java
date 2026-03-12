package com.marketplace.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.marketplace.entity.Booking;
import com.marketplace.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return service.createBooking(booking);
    }
    
    @PutMapping("/{id}/accept")
    public Booking acceptBooking(@PathVariable Long id) {
        return service.acceptBooking(id);
    }

    @PutMapping("/{id}/complete")
    public Booking completeBooking(@PathVariable Long id) {
        return service.completeBooking(id);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return service.getAllBookings();
    }
}