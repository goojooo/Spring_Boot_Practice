package com.localservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.localservice.service.CustomUserDetailsService;

@Configuration
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth

            	    // ✅ Static files (must be first)
            	    .requestMatchers(
            	        "/",
            	        "/index.html",
            	        "/assets/**",
            	        "/css/**",
            	        "/js/**",
            	        "/images/**"
            	    ).permitAll()

            	    // ✅ ALL HTML PAGES (IMPORTANT 🔥)
            	    .requestMatchers(
            	        "/login",
            	        "/logout",
            	        "/dashboard",
            	        "/admin-login",
            	        "/partner-login",
            	        "/partner-register",
            	        "/user-register",
            	        "/services",
            	        "/home",
            	        "/error"
            	    ).permitAll()

            	    // ✅ AUTH APIs
            	    .requestMatchers("/api/auth/**").permitAll()

            	    // 🔒 PROTECTED APIs ONLY
            	    .requestMatchers("/api/admin/**").hasRole("ADMIN")
            	    .requestMatchers("/api/services/**").hasAnyRole("USER", "ADMIN")

            	    // 🔒 Everything else
            	    .anyRequest().authenticated()
            	)

            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)

            .formLogin(form -> form.disable())
            .httpBasic(httpBasic -> httpBasic.disable());

        return http.build();
    }
}