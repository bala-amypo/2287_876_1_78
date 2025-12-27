package com.example.demo.config;
import com.example.demo.security.JwtTokenProvider;
package com.example.demo.security;

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
