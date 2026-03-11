package com.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.marketplace.entity.ServiceCategory;

public interface ServiceCategoryRepository
        extends JpaRepository<ServiceCategory, Long> {
}