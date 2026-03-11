package com.marketplace.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.marketplace.entity.ServiceCategory;
import com.marketplace.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ServiceCategory create(@RequestBody ServiceCategory category) {
        return service.create(category);
    }

    @GetMapping
    public List<ServiceCategory> getAll() {
        return service.getAll();
    }
}