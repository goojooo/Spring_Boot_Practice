package com.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.marketplace.entity.ProviderProfile;

public interface ProviderProfileRepository
        extends JpaRepository<ProviderProfile, Long> {
}