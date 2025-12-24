package com.example.demo.controller;

import com.example.demo.security.CustomUserDetailsService;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final CustomUserDetailsService userDetailsService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(CustomUserDetailsService userDetailsService,
                          JwtTokenProvider jwtTokenProvider) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public Map<String, Object> register(@RequestParam String name,
                                        @RequestParam String email,
                                        @RequestParam String password,
                                        @RequestParam String role) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return userDetailsService.registerUser(
                name,
                email,
                encoder.encode(password),
                role
        );
    }

    @PostMapping("/token")
    public String generateToken(@RequestParam String email,
                                @RequestParam Long userId,
                                @RequestParam String role) {

        Authentication auth =
                new UsernamePasswordAuthenticationToken(
                        email, "password", Collections.emptyList());

        return jwtTokenProvider.generateToken(auth, userId, role);
    }
}
