package com.example.demo.controller;

import com.example.demo.model.AuthRequest;
import com.example.demo.model.AuthResponse;
import com.example.demo.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/token")
    public AuthResponse generateToken(@RequestBody AuthRequest request) {
        return service.generateToken(request);
    }
}
