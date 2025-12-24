package com.example.demo.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public String generateToken(String username) {
        return "dummy-token";
    }

    // 🔥 THIS FIXES YOUR ERROR
    public String generateToken(Authentication authentication,
                                Long userId,
                                String role) {
        return "dummy-token";
    }
}
