package com.example.demo.controller;

import com.example.demo.security.CustomUserDetailsService;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody Map<String, String> request) {
        String fullName = request.get("fullName");
        String email = request.get("email");
        String password = passwordEncoder.encode(request.get("password"));
        String role = request.get("role");
        return customUserDetailsService.registerUser(fullName, email, password, role);
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String password = request.get("password");
        // In a real app, validate password here
        Authentication auth = new UsernamePasswordAuthenticationToken(email, password, Collections.emptyList());
        Map<String, Object> user = customUserDetailsService.getUserByEmail(email);
        if (user != null) {
            return jwtTokenProvider.generateToken(auth, (Long) user.get("userId"), (String) user.get("role"));
        }
        throw new RuntimeException("Invalid credentials");
    }
}
