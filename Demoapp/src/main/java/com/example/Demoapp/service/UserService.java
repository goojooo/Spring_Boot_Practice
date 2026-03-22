package com.example.Demoapp.service;


import java.util.List;

import com.example.Demoapp.entity.User;

public interface UserService {

    public void saveUser(User user);
    public List<User> getAllUsers();
}
