package com.localservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.localservice.model.Booking;
import com.localservice.model.ServicePartner;
import com.localservice.repository.BookingRepository;
import com.localservice.repository.ServicePartnerRepository;

@RestController
@RequestMapping("/api")
public class ServiceController {

    @Autowired
    private ServicePartnerRepository servicePartnerRepository;

    // 🔹 Add this repository (THIS WAS MISSING)
    @Autowired
    private BookingRepository bookingRepository;


    // Show services page
    @GetMapping("/services")
    public List<ServicePartner> getServices() {
        return servicePartnerRepository.findAll();
    }


    // Show booking form
    @GetMapping("/booking/form/{partnerId}")
    public String bookingForm(@PathVariable Long partnerId, Model model){

        Booking booking = new Booking();
        booking.setPartnerId(partnerId);

        model.addAttribute("booking", booking);

        return "booking-form";
    }



}