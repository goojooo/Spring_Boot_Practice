package com.example.Demoapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Demoapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
