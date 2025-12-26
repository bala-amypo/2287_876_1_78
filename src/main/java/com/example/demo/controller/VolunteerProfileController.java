package com.example.demo.controller;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/volunteers")
public class VolunteerProfileController {

    @Autowired
    private VolunteerProfileService service;

    @PutMapping("/{id}")
    public VolunteerProfile updateVolunteer(@PathVariable Long id, @RequestBody VolunteerProfile profile) {
        return service.updateVolunteer(id, profile);
    }

    @GetMapping("/code/{code}")
    public VolunteerProfile getByVolunteerCode(@PathVariable String code) {
        return service.getByVolunteerCode(code);
    }
}
