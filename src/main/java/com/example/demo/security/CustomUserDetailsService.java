package com.example.demo.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomUserDetailsService {

    public Map<String, Object> registerUser(
            String username,
            String password,
            String email,
            String role) {

        Map<String, Object> map = new HashMap<>();
        map.put("message", "User registered");
        return map;
    }

    public UserDetails loadUserByUsername(String username) {
        return User.withUsername(username)
                .password("password")
                .authorities("ROLE_USER")
                .build();
    }
}
