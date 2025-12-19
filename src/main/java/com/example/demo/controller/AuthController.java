package com.example.demo.controller;




import com.example.demo.model.VolunteerProfile;

import com.example.demo.service.VolunteerProfileService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final VolunteerProfileService volunteerProfileService;

    public AuthController(AuthenticationManager authenticationManager,
                          JwtTokenProvider jwtTokenProvider,
                          VolunteerProfileService volunteerProfileService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.volunteerProfileService = volunteerProfileService;
    }

    @PostMapping("/register")
    public VolunteerProfile register(@RequestBody RegisterRequest request) {
        return volunteerProfileService.registerVolunteer(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(), request.getPassword())
        );

        String token = jwtTokenProvider.generateToken(
                request.getUsername(), "ROLE_USER");

        return new AuthResponse(token, null, "ROLE_USER");
    }
}
