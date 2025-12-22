// package com.example.demo.controller;

// import com.example.demo.dto.AuthRequest;
// import com.example.demo.dto.AuthResponse;
// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.model.VolunteerProfile;
// import com.example.demo.security.JwtTokenProvider;
// import com.example.demo.service.VolunteerProfileService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final AuthenticationManager authenticationManager;
//     private final JwtTokenProvider jwtTokenProvider;
//     private final VolunteerProfileService volunteerProfileService;

//     public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider,
//                           VolunteerProfileService volunteerProfileService) {
//         this.authenticationManager = authenticationManager;
//         this.jwtTokenProvider = jwtTokenProvider;
//         this.volunteerProfileService = volunteerProfileService;
//     }

//     @PostMapping("/register")
//     public ResponseEntity<VolunteerProfile> register(@RequestBody RegisterRequest request) {
//         VolunteerProfile created = volunteerProfileService.registerVolunteer(request);
//         return ResponseEntity.ok(created);
//     }

//     @PostMapping("/login")
//     public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
//         Authentication auth = authenticationManager.authenticate(
//                 new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
//         String token = jwtTokenProvider.generateToken(auth.getName(), "ROLE_USER");
//         // In a real app, map to actual user id and role
//         AuthResponse response = new AuthResponse(token, 0L, "ROLE_USER");
//         return ResponseEntity.ok(response);
//     }
// }
