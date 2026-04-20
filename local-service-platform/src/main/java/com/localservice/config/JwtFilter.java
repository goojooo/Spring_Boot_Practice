package com.localservice.config;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * This filter runs on EVERY request
 * It checks JWT token before accessing any API
 */
@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;
@Override
protected void doFilterInternal(HttpServletRequest request,
                                HttpServletResponse response,
                                FilterChain filterChain)
        throws ServletException, IOException {

//    String path = request.getRequestURI();
//
//    if (path.startsWith("/api/auth")) {
//        filterChain.doFilter(request, response);
//        return;
//    }
	String path = request.getRequestURI();

	// ✅ Skip JWT check for HTML pages
	if (!path.startsWith("/api/")) {
	    filterChain.doFilter(request, response);
	    return;
	}

    String header = request.getHeader("Authorization");

    if (header != null && header.startsWith("Bearer ")) {

        String token = header.substring(7);

        if (jwtUtil.validateToken(token) &&
            SecurityContextHolder.getContext().getAuthentication() == null) {

//            String email = jwtUtil.extractUsername(token);
//
//            UsernamePasswordAuthenticationToken auth =
//                    new UsernamePasswordAuthenticationToken(
//                            email,
//                            null,
//                            Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
//                    );
        	
        	Claims claims = jwtUtil.extractClaims(token);

        	String email = claims.getSubject();
        	String role = claims.get("role", String.class);

        	UsernamePasswordAuthenticationToken auth =
        	        new UsernamePasswordAuthenticationToken(
        	                email,
        	                null,
        	                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role))
        	        );

            SecurityContextHolder.getContext().setAuthentication(auth);
        }
    }

    filterChain.doFilter(request, response);
}
}