package com.example.demo.controller;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/volunteers")
public class VolunteerProfileController {

    private final VolunteerProfileService volunteerService;

    public VolunteerProfileController(VolunteerProfileService volunteerService) {
        this.volunteerService = volunteerService;
    }

    @PostMapping
    public VolunteerProfile createVolunteer(@RequestBody VolunteerProfile profile) {
        return volunteerService.createVolunteer(profile);
    }

    @GetMapping("/{id}")
    public VolunteerProfile getVolunteerById(@PathVariable Long id) {
        return volunteerService.getVolunteerById(id);
    }

    @GetMapping
    public List<VolunteerProfile> getAllVolunteers() {
        return volunteerService.getAllVolunteers();
    }

    @GetMapping("/lookup/{volunteerId}")
    public Optional<VolunteerProfile> findByVolunteerId(@PathVariable String volunteerId) {
        return volunteerService.findByVolunteerId(volunteerId);
    }
}
