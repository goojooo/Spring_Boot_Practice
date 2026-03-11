package com.marketplace.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.marketplace.entity.ServiceOffering;
import com.marketplace.service.ServiceOfferingService;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    private final ServiceOfferingService service;

    public ServiceController(ServiceOfferingService service) {
        this.service = service;
    }

    @PostMapping
    public ServiceOffering createService(
            @RequestBody ServiceOffering s) {

        return service.create(s);
    }

    @GetMapping
    public List<ServiceOffering> getAllServices() {
        return service.getAll();
    }
}