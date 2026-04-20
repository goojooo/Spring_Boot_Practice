package com.localservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.localservice.config.JwtUtil;
import com.localservice.dto.LoginRequest;
import com.localservice.dto.LoginResponse;
import com.localservice.model.User;
import com.localservice.service.UserService;

/**
 * REST API Controller (returns JSON, not HTML)
 */
@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;
    /**
     * Login API
     */
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        // ✅ Remove extra spaces
        String email = request.getEmail().trim();
        String password = request.getPassword().trim();

        User user = userService.login(email, password);

        System.out.println("EMAIL: " + email);
        if (user == null) {
            return new LoginResponse("Invalid credentials", null);
        }

//        String token = jwtUtil.generateToken(user.getEmail());
        String token = jwtUtil.generateToken(user.getEmail(), user.getRole());
        return new LoginResponse("Login successful", token);
    }
}