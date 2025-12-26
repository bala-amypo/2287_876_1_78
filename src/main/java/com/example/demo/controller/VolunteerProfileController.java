package com.example.demo.controller;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/volunteers")
public class VolunteerProfileController {

    private final VolunteerProfileService service;

    public VolunteerProfileController(VolunteerProfileService service) {
        this.service = service;
    }

    @PostMapping
    public VolunteerProfile create(@RequestBody VolunteerProfile profile) {
        return service.save(profile);
    }

    @GetMapping("/{volunteerId}")
    public VolunteerProfile getByVolunteerId(
            @PathVariable String volunteerId) {
        return service.findByVolunteerId(volunteerId);
    }

    @PutMapping("/{id}")
    public VolunteerProfile update(@PathVariable Long id,
                                   @RequestBody VolunteerProfile profile) {
        return service.updateVolunteer(id, profile);
    }
}
