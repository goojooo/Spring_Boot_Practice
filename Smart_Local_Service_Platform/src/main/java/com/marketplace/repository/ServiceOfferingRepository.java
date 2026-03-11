package com.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.marketplace.entity.ServiceOffering;

public interface ServiceOfferingRepository
        extends JpaRepository<ServiceOffering, Long> {
}