package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class JwtTokenProvider {

    private String secretKey;
    private long validityInMs;
    private Key key;

    // REQUIRED by Spring
    public JwtTokenProvider() {
        this.secretKey = "default-secret-key-default-secret-key";
        this.validityInMs = 3600000;
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    // REQUIRED by TEST CASE
    public JwtTokenProvider(String secretKey, long validityInMs) {
        this.secretKey = secretKey;
        this.validityInMs = validityInMs;
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String generateToken(Authentication authentication, Long userId, String role) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityInMs);

        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        return getAllClaims(token).getSubject();
    }

    // REQUIRED by TEST CASE
    public Claims getAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
