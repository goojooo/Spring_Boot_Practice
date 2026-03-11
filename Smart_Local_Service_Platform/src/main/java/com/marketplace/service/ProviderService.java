package com.marketplace.service;

import org.springframework.stereotype.Service;

import com.marketplace.entity.ProviderProfile;
import com.marketplace.repository.ProviderProfileRepository;

@Service
public class ProviderService {

    private final ProviderProfileRepository repo;

    public ProviderService(ProviderProfileRepository repo) {
        this.repo = repo;
    }

    public ProviderProfile createProfile(ProviderProfile profile) {
        return repo.save(profile);
    }
}