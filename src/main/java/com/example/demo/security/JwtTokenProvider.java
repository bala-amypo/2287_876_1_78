package com.example.demo.security;

import io.jsonwebtoken.*;
import java.util.Date;
import java.util.Map;

public class JwtTokenProvider {

    private String secretKey;
    private long validityInMs;

    public JwtTokenProvider() {}

    public JwtTokenProvider(String secretKey, long validityInMs) {
        this.secretKey = secretKey;
        this.validityInMs = validityInMs;
    }

    public String generateToken(
            org.springframework.security.core.Authentication auth,
            Long userId,
            String role) {

        Claims claims = Jwts.claims();
        claims.put("email", auth.getName());
        claims.put("userId", userId);
        claims.put("role", role);

        Date now = new Date();
        Date exp = new Date(now.getTime() + validityInMs);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey)
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        return getAllClaims(token).get("email", String.class);
    }

    public Map<String, Object> getAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }
}
