package com.example.demo.controller;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final VolunteerProfileService volunteerProfileService;

    public AuthController(VolunteerProfileService volunteerProfileService) {
        this.volunteerProfileService = volunteerProfileService;
    }

   @PostMapping("/register")
    public VolunteerProfile register(@RequestBody VolunteerProfile profile) {
    return volunteerProfileService.register(profile);
}

