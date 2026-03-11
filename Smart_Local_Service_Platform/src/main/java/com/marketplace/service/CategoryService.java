package com.marketplace.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.marketplace.entity.ServiceCategory;
import com.marketplace.repository.ServiceCategoryRepository;

@Service
public class CategoryService {

    private final ServiceCategoryRepository repo;

    public CategoryService(ServiceCategoryRepository repo) {
        this.repo = repo;
    }

    public ServiceCategory create(ServiceCategory category) {
        return repo.save(category);
    }

    public List<ServiceCategory> getAll() {
        return repo.findAll();
    }
}