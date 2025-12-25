package com.example.demo.controller;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volunteer-skills")
public class VolunteerSkillController {

    private final VolunteerSkillService skillService;

    public VolunteerSkillController(VolunteerSkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping
    public VolunteerSkillRecord addOrUpdateSkill(@RequestBody VolunteerSkillRecord skill) {
        return skillService.addOrUpdateSkill(skill);
    }

    @GetMapping("/volunteer/{volunteerId}")
    public List<VolunteerSkillRecord> getSkillsByVolunteer(@PathVariable Long volunteerId) {
        return skillService.getSkillsByVolunteer(volunteerId);
    }

    @GetMapping
    public List<VolunteerSkillRecord> getAllSkills() {
        return skillService.getAllSkills();
    }
}
