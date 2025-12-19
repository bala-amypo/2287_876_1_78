package com.example.demo.controller;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final VolunteerProfileService service;

    public AuthController(VolunteerProfileService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public VolunteerProfile register(@RequestBody VolunteerProfile profile) {
        return service.register(profile);
    }

    @PostMapping("/login")
    public String login(@RequestBody VolunteerProfile profile) {
        return "Login successful";
    }
}
