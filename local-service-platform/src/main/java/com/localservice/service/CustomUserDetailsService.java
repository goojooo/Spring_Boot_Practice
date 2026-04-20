package com.localservice.service;

import com.localservice.model.User;
import com.localservice.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * This class tells Spring Security:
 * "How to load user from database"
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /**
     * This method is called during login
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 🔍 Fetch user from DB
        User user = userRepository.findByEmail(username);

        // ❌ If user not found
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // ✅ Return user to Spring Security
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .roles("USER") // For now fixed role
                .build();
    }
}