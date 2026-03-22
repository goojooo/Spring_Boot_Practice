package com.example.Demoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Demoapp.entity.User;
import com.example.Demoapp.service.UserService;

@Controller
public class HomeController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("user", new User());
        return "home";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {
        service.saveUser(user);
        return "redirect:/users";
    }


    
    
}