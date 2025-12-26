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

    @PutMapping("/{id}")
    public VolunteerProfile updateVolunteer(
            @PathVariable Long id,
            @RequestBody VolunteerProfile profile) {
        return service.updateVolunteer(id, profile);
    }

    @GetMapping("/available")
    public List<VolunteerProfile> getAvailableVolunteers() {
        return service.getAvailableVolunteers();
    }

    @GetMapping("/code/{volunteerCode}")
    public VolunteerProfile getByVolunteerCode(
            @PathVariable String volunteerCode) {
        return service.getByVolunteerCode(volunteerCode);
    }
}
