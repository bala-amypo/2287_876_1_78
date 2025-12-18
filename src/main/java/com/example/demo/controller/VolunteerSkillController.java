package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Skill;
import com.example.demo.service.SkillService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/skills")
@Tag(name = "Volunteer Skills", description = "Volunteer skill APIs")
public class VolunteerSkillController {

    @Autowired
    private SkillService skillService;

    @Operation(summary = "Add or update skill")
    @PostMapping
    public Skill addOrUpdateSkill(@RequestBody Skill skill) {
        return skillService.saveSkill(skill);
    }

    @Operation(summary = "Get skills by volunteer")
    @GetMapping("/volunteer/{volunteerId}")
    public List<Skill> getSkillsByVolunteer(@PathVariable Long volunteerId) {
        return skillService.getSkillsByVolunteer(volunteerId);
    }

    @Operation(summary = "Get skill by ID")
    @GetMapping("/{id}")
    public Skill getSkill(@PathVariable Long id) {
        return skillService.getSkillById(id);
    }

    @Operation(summary = "List all skills")
    @GetMapping
    public List<Skill> getAllSkills() {
        return skillService.getAllSkills();
    }
}
