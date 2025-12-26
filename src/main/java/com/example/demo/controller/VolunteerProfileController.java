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

    @GetMapping("/{code}")
    public VolunteerProfile getByCode(@PathVariable String code) {
        return service.getByVolunteerCode(code);
    }

    @PostMapping
    public VolunteerProfile create(@RequestBody VolunteerProfile profile) {
        return service.save(profile);
    }

    @PutMapping("/{id}")
    public VolunteerProfile update(@PathVariable Long id,
                                   @RequestBody VolunteerProfile profile) {
        return service.updateVolunteer(id, profile);
    }
}
