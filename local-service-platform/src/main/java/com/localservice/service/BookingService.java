package com.localservice.service;

import com.localservice.model.Booking;
import com.localservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public void createBooking(Booking booking){

        booking.setStatus("PENDING");

        bookingRepository.save(booking);

    }

    public List<Booking> getPartnerBookings(Long partnerId){

        return bookingRepository.findByPartnerId(partnerId);
    }

    public void acceptBooking(Long id){

        Booking booking = bookingRepository.findById(id).orElseThrow();

        booking.setStatus("CONFIRMED");

        bookingRepository.save(booking);
    }

    public void rejectBooking(Long id){

        Booking booking = bookingRepository.findById(id).orElseThrow();

        booking.setStatus("REJECTED");

        bookingRepository.save(booking);
    }
}