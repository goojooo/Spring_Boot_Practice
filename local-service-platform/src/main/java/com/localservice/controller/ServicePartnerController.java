package com.localservice.controller;

import com.localservice.model.ServicePartnerRequest;
import com.localservice.service.ServicePartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/partner")
public class ServicePartnerController {

    @Autowired
    private ServicePartnerService servicePartnerService;

    // Show partner registration form
    @GetMapping("/register")
    public String registerForm(Model model) {

        model.addAttribute("partner", new ServicePartnerRequest());

        return "partner-register";
    }

    // Waiting page after submitting request
    @GetMapping("/waiting")
    public String waitingPage() {

        return "waiting";
    }

    // Submit partner request
    @PostMapping("/register")
    public String registerPartner(@ModelAttribute ServicePartnerRequest request) {

        servicePartnerService.submitRequest(request);

        return "redirect:/partner/waiting";
    }

}