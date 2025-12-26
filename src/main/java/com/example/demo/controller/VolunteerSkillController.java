package com.example.demo.controller;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volunteer-skills")
public class VolunteerSkillController {

    private final VolunteerSkillService service;

    public VolunteerSkillController(
            VolunteerSkillService service) {
        this.service = service;
    }

    @PostMapping
    public VolunteerSkillRecord addSkill(
            @RequestBody VolunteerSkillRecord record) {
        return service.addSkill(record);
    }

    @GetMapping("/volunteer/{volunteerId}")
    public List<VolunteerSkillRecord> getByVolunteer(
            @PathVariable Long volunteerId) {
        return service.getSkillsByVolunteer(volunteerId);
    }
}
