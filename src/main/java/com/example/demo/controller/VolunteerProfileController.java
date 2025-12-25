package com.example.demo.controller;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/volunteers")
public class VolunteerProfileController {

    private final VolunteerProfileService service;

    public VolunteerProfileController(
            VolunteerProfileService service) {
        this.service = service;
    }

    @PostMapping
    public VolunteerProfile createVolunteer(
            @RequestBody VolunteerProfile volunteer) {
        return service.createVolunteer(volunteer);
    }

    @PutMapping("/{id}")
    public VolunteerProfile updateVolunteer(
            @PathVariable Long id,
            @RequestBody VolunteerProfile volunteer) {
        return service.updateVolunteer(id, volunteer);
    }

    @GetMapping
    public List<VolunteerProfile> getAllVolunteers() {
        return service.getAllVolunteers();
    }

    @GetMapping("/available")
    public List<VolunteerProfile> getAvailableVolunteers() {
        return service.getAvailableVolunteers();
    }

    @GetMapping("/code/{volunteerCode}")
    public Optional<VolunteerProfile> getByCode(
            @PathVariable String volunteerCode) {
        return service.getByVolunteerCode(volunteerCode);
    }
}
