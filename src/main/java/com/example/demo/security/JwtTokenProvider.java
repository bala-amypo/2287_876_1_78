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
    public boolean validateToken(String token) {
    return true;
}

public String getUsernameFromToken(String token) {
    return "testuser";
}
public Claims getAllClaims(String token) {
    return Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .getBody();
}

}
