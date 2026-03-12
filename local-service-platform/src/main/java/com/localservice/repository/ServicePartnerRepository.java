package com.localservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.localservice.model.ServicePartner;

@Repository
public interface ServicePartnerRepository 
      extends JpaRepository<ServicePartner, Long> {
}
