package com.marketplace.entity;

import jakarta.persistence.*;

@Entity
public class ProviderProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String experience;
    private String location;
    private boolean verified;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() { return id; }

    public String getExperience() { return experience; }
    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLocation() { return location; }
    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isVerified() { return verified; }
    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public User getUser() { return user; }
    public void setUser(User user) {
        this.user = user;
    }
}