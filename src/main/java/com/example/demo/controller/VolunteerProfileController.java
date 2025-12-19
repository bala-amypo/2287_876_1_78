package com.example.demo.controller;

import com.example.demo.dto.AvailabilityUpdateRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/volunteers")
public class VolunteerProfileController {

    private final VolunteerProfileService volunteerProfileService;

    public VolunteerProfileController(VolunteerProfileService volunteerProfileService) {
        this.volunteerProfileService = volunteerProfileService;
    }

    @PostMapping
    public ResponseEntity<VolunteerProfile> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(volunteerProfileService.registerVolunteer(request));
    }

    @PatchMapping("/{id}/availability")
    public ResponseEntity<VolunteerProfile> updateAvailability(@PathVariable Long id,
                                                               @RequestBody AvailabilityUpdateRequest request) {
        return ResponseEntity.ok(volunteerProfileService.updateAvailability(id, request.getAvailabilityStatus()));
    }
}
