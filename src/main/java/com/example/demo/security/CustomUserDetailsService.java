package com.example.demo.security;

import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService {

    public void registerUser(String username,
                             String password,
                             String email,
                             String role) {
        // Testcase purpose – no logic needed
    }
}
