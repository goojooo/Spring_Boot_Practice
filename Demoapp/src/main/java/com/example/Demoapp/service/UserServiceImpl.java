package com.example.Demoapp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Demoapp.entity.User;
import com.example.Demoapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public void saveUser(User user) {
        repo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return repo.findAll();
    }
}
