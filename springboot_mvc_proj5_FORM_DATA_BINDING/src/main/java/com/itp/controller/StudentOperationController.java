package com.itp.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.itp.model.Student;

@Controller
public class StudentOperationController {

    // Homepage
    @GetMapping("/")
    public String showHomepage() {
        System.out.println("Homepage called");
        return "welcome";
    }

    // Show registration form
    @GetMapping("/register")
    public String showStudentRegistrationForm() {
        System.out.println("Form page called");
        return "student_register";
    }

    // Handle form submission
    @PostMapping("/register")
    public String registerStudent(@ModelAttribute("stud") Student s,
                                  Map<String, Object> map) {

        System.out.println("Register method called");

        String result;

        if (s.getAverage() <= 35) {
            result = "Fail";
        } else if (s.getAverage() < 50) {
            result = "Third Class";
        } else if (s.getAverage() < 60) {
            result = "Second Class";
        } else if (s.getAverage() < 75) {
            result = "First Class";
        } else {
            result = "Distinction";
        }

        // store result in model
        map.put("resultMsg", result);
        map.put("studData", s);

        return "display"; // display.jsp
    }
}