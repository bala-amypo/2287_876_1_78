package com.example.demo.controller;

import com.example.demo.model.VolunteerSkill;
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
    public VolunteerSkill addSkill(
            @RequestBody VolunteerSkill skill) {
        return service.addSkill(skill);
    }

    @GetMapping("/volunteer/{volunteerId}")
    public List<VolunteerSkill> getSkillsByVolunteer(
            @PathVariable Long volunteerId) {
        return service.getSkillsByVolunteer(volunteerId);
    }

    @GetMapping("/skill/{skillName}")
    public List<VolunteerSkill> getSkillsByName(
            @PathVariable String skillName) {
        return service.getSkillsByName(skillName);
    }
}
