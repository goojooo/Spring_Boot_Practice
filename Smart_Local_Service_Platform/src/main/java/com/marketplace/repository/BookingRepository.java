package com.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.marketplace.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}