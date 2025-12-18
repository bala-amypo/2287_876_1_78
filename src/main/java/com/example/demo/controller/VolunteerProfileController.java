package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Volunteer;
import com.example.demo.service.VolunteerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/volunteers")
@Tag(name = "Volunteer Profile", description = "Volunteer profile APIs")
public class VolunteerProfileController {

    @Autowired
    private VolunteerService volunteerService;

    @Operation(summary = "Create volunteer")
    @PostMapping
    public Volunteer createVolunteer(@RequestBody Volunteer volunteer) {
        return volunteerService.createVolunteer(volunteer);
    }

    @Operation(summary = "Get volunteer by ID")
    @GetMapping("/{id}")
    public Volunteer getVolunteer(@PathVariable Long id) {
        return volunteerService.getVolunteerById(id);
    }

    @Operation(summary = "List all volunteers")
    @GetMapping
    public List<Volunteer> getAllVolunteers() {
        return volunteerService.getAllVolunteers();
    }

    @Operation(summary = "Update availability status")
    @PutMapping("/{id}/availability")
    public Volunteer updateAvailability(
            @PathVariable Long id,
            @RequestParam boolean available) {
        return volunteerService.updateAvailability(id, available);
    }

    @Operation(summary = "Lookup volunteer by ID")
    @GetMapping("/lookup/{volunteerId}")
    public Volunteer lookupVolunteer(@PathVariable Long volunteerId) {
        return volunteerService.getVolunteerById(volunteerId);
    }
}
