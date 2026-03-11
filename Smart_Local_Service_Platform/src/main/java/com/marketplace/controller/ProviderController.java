package com.marketplace.controller;

import org.springframework.web.bind.annotation.*;

import com.marketplace.entity.ProviderProfile;
import com.marketplace.service.ProviderService;

@RestController
@RequestMapping("/api/provider")
public class ProviderController {

    private final ProviderService service;

    public ProviderController(ProviderService service) {
        this.service = service;
    }

    @PostMapping("/profile")
    public ProviderProfile createProfile(
            @RequestBody ProviderProfile profile) {

        return service.createProfile(profile);
    }
}