package com.example.demo.controller;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volunteers")
public class VolunteerProfileController {

    private final VolunteerProfileService service;

    public VolunteerProfileController(VolunteerProfileService service) {
        this.service = service;
    }

    @PostMapping
    public VolunteerProfile createVolunteer(@RequestBody VolunteerProfile profile) {
        return service.createVolunteer(profile);
    }

    @GetMapping
    public List<VolunteerProfile> getAllVolunteers() {
        return service.getAllVolunteers();
    }

    @GetMapping("/code/{volunteerCode}")
    public VolunteerProfile getByVolunteerCode(@PathVariable String volunteerCode) {
        return service.getByVolunteerCode(volunteerCode);
    }

    @PutMapping("/{id}")
    public VolunteerProfile updateVolunteer(
            @PathVariable Long id,
            @RequestBody VolunteerProfile profile) {
        return service.updateVolunteer(id, profile);
    }
}
