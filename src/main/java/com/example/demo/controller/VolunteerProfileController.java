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
    public VolunteerProfile create(@RequestBody VolunteerProfile v) {
        return service.create(v);
    }

    @GetMapping("/{id}")
    public VolunteerProfile get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<VolunteerProfile> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public VolunteerProfile update(@PathVariable Long id,
                                   @RequestBody VolunteerProfile v) {
        return service.update(id, v);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
