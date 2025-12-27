package com.example.demo.controller;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class VolunteerSkillController {

    @Autowired
    private VolunteerSkillService volunteerSkillService;

    @PostMapping
    public ResponseEntity<VolunteerSkillRecord> addSkill(@RequestBody VolunteerSkillRecord skill) {
        if (skill.getVolunteerId() == null || skill.getSkillName() == null || skill.getSkillName().isEmpty()) {
            throw new BadRequestException("Volunteer ID and Skill Name are required");
        }
        VolunteerSkillRecord created = volunteerSkillService.addOrUpdateSkill(skill);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/volunteer/{volunteerId}")
    public ResponseEntity<List<VolunteerSkillRecord>> getSkillsByVolunteer(@PathVariable Long volunteerId) {
        List<VolunteerSkillRecord> skills = volunteerSkillService.getSkillsByVolunteer(volunteerId);
        return ResponseEntity.ok(skills);
    }
}
