package com.example.demo.security;

import io.jsonwebtoken.*;
import java.util.*;
import org.springframework.security.core.Authentication;

public class JwtTokenProvider {

    private final String secret;
    private final long expiry;

    public JwtTokenProvider(String s, long e) {
        secret = s; expiry = e;
    }

    public String generateToken(
            Authentication auth, Long userId, String role) {

        return Jwts.builder()
                .setSubject(auth.getName())
                .claim("userId", userId)
                .claim("role", role)
                .claim("email", auth.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiry))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        String username = (String) claims.get("sub");

    }

    public Map<String, Object> getAllClaims(String token) {
        Claims c = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        return new HashMap<>(c);
    }
}
