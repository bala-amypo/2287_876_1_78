package com.example.demo.controller;

import com.example.demo.service.JwtService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/token")
    public String generateToken(@RequestParam String username) {
        return jwtService.generateToken(username);
    }
}
