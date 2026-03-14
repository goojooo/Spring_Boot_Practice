package com.localservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.localservice.model.User;
import com.localservice.repository.ServicePartnerRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ServiceController {

    @Autowired
    private ServicePartnerRepository servicePartnerRepository;

    @GetMapping("/services")
    public String services(Model model, HttpSession session) {

    User user = (User) session.getAttribute("loggedUser");

    if(user == null){
    return "redirect:/login";
    }

    model.addAttribute("services", servicePartnerRepository.findAll());

    return "services";
    }
    
    
}