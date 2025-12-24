package com.example.demo.controller;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volunteers")
public class VolunteerProfileController {

    private final VolunteerProfileService service;

    // Constructor injection
    public VolunteerProfileController(VolunteerProfileService service) {
        this.service = service;
    }

    // Create volunteer
    @PostMapping
    public VolunteerProfile createVolunteer(@RequestBody VolunteerProfile profile) {
        return service.save(profile);
    }

    // Get all volunteers
    @GetMapping
    public List<VolunteerProfile> getAllVolunteers() {
        return service.getAllVolunteers();
    }

    // Get volunteers by skill
    @GetMapping("/skill/{skill}")
    public List<VolunteerProfile> getVolunteersBySkill(@PathVariable String skill) {
        return service.getVolunteersBySkill(skill);
    }
}
