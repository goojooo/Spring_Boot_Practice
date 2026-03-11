package com.marketplace.entity;

import jakarta.persistence.*;

@Entity
public class ServiceOffering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private double price;
    private int durationMinutes;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ServiceCategory category;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private ProviderProfile provider;

    public Long getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public ServiceCategory getCategory() { return category; }
    public void setCategory(ServiceCategory category) {
        this.category = category;
    }

    public ProviderProfile getProvider() { return provider; }
    public void setProvider(ProviderProfile provider) {
        this.provider = provider;
    }
}