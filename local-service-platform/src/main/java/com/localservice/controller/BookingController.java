package com.localservice.controller;

import com.localservice.model.Booking;
import com.localservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping("/booking/create")
    public String createBooking(@ModelAttribute Booking booking){

        booking.setStatus("PENDING");

        bookingRepository.save(booking);

        return "redirect:/services";
    }
}