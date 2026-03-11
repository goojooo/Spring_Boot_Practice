package com.marketplace.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.marketplace.entity.ServiceOffering;
import com.marketplace.repository.ServiceOfferingRepository;

@Service
public class ServiceOfferingService {

    private final ServiceOfferingRepository repo;

    public ServiceOfferingService(ServiceOfferingRepository repo) {
        this.repo = repo;
    }

    public ServiceOffering create(ServiceOffering service) {
        return repo.save(service);
    }

    public List<ServiceOffering> getAll() {
        return repo.findAll();
    }
}