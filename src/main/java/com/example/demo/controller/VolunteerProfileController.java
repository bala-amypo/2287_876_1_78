package com.example.demo.controller;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volunteers")
public class VolunteerProfileController {

    private final VolunteerProfileService volunteerProfileService;

    public VolunteerProfileController(VolunteerProfileService volunteerProfileService) {
        this.volunteerProfileService = volunteerProfileService;
    }

    @PostMapping
    public VolunteerProfile createVolunteer(@RequestBody VolunteerProfile profile) {
        return volunteerProfileService.createVolunteer(profile);
    }

    @GetMapping("/{id}")
    public VolunteerProfile getVolunteer(@PathVariable Long id) {
        return volunteerProfileService.getVolunteerById(id);
    }

    @GetMapping
    public List<VolunteerProfile> getAllVolunteers() {
        return volunteerProfileService.getAllVolunteers();
    }
}
