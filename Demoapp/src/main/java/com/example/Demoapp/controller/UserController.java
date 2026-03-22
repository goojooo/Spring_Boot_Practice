package com.example.Demoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Demoapp.entity.User;
import com.example.Demoapp.repository.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Show users
    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }

    // Add new user
    @PostMapping("/addUser")
    public String addUser(@RequestParam String name,
                          @RequestParam String email) {

        User user = new User();
        user.setName(name);
        user.setEmail(email);

        userRepository.save(user);

        return "redirect:/users";
    }

    // Delete user
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "redirect:/users";
    }

    // Open edit page
    @GetMapping("/editUser/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        User user = userRepository.findById(id).orElse(null);
        model.addAttribute("user", user);
        return "editUser";
    }

    // Update user
    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/users";
    }
}
