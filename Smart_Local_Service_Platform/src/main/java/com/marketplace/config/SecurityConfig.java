package com.marketplace.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.marketplace.security.JwtFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    	http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth

                .requestMatchers("/api/auth/**").permitAll()

                // categories
                .requestMatchers(HttpMethod.POST, "/api/categories").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/categories").authenticated()

                // provider profile
                .requestMatchers("/api/provider/**").hasRole("PROVIDER")

                // services
                .requestMatchers(HttpMethod.POST, "/api/services").hasRole("PROVIDER")
                .requestMatchers(HttpMethod.GET, "/api/services").authenticated()
                
                .requestMatchers(HttpMethod.POST, "/api/bookings").hasRole("CUSTOMER")
                .requestMatchers(HttpMethod.GET, "/api/bookings").authenticated()
                
                .requestMatchers(HttpMethod.POST, "/api/bookings").hasRole("CUSTOMER")

                .requestMatchers(HttpMethod.POST, "/api/bookings/*/accept")
                .hasRole("PROVIDER")

                .requestMatchers(HttpMethod.POST, "/api/bookings/*/complete")
                .hasRole("PROVIDER")

                .requestMatchers("/api/admin/**").hasRole("ADMIN")

                .anyRequest().authenticated()
        )
        .addFilterBefore(
            new JwtFilter(),
            UsernamePasswordAuthenticationFilter.class
        );

        return http.build();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}