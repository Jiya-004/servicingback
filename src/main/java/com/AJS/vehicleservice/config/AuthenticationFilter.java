package com.AJS.vehicleservice.config;

import com.AJS.vehicleservice.model.Admin;
import com.AJS.vehicleservice.service.AdminService;
import com.AJS.vehicleservice.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private AdminService adminService;  // Admin service to access the admin database

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwtToken;
        final String username;

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        jwtToken = authHeader.substring(7);  // Extract the JWT token from the header
        username = JwtUtil.extractUsername(jwtToken);  // Extract the username from the token

        if (username != null) {
            // Validate the token
            if (JwtUtil.validateToken(jwtToken, username)) {
                // Fetch admin details from the database
                Admin admin = adminService.findByName(username);

                // Check if the admin exists in the database
                if (admin != null) {
                    // If the admin exists, authenticate the request
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(
                                    username,  // Username (principal)
                                    null,      // Password (credentials, null in JWT context)
                                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"))  // Default "admin" authority
                            );
                    // Set the authentication in SecurityContext
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                } else {
                    // If admin not found in the database, respond with unauthorized
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid admin credentials");
                    return;
                }
            } else {
                // If token is invalid, respond with unauthorized
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid or expired token");
                return;
            }
        }
        filterChain.doFilter(request, response);  // Continue with the filter chain
    }
}
