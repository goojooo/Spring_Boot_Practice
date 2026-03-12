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
    private ServicePartnerService partnerService;

    @GetMapping("/register")
    public String registerForm(Model model){

        model.addAttribute("partner", new ServicePartnerRequest());
        return "partner-register";
    }

    @PostMapping("/register")
    public String submitRequest(@ModelAttribute ServicePartnerRequest request){

        partnerService.submitRequest(request);

        return "request-submitted";
    }
}