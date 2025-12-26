package com.example.demo.config;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    // ✔ Dummy token generate
    public String generateToken(String username) {
        return "dummy-jwt-token";
    }

    // ✔ Dummy validation – always true
    public boolean validateToken(String token) {
        return true;
    }

    // ✔ Dummy username extract
    public String getUsernameFromToken(String token) {
        return "test-user";
    }
}
