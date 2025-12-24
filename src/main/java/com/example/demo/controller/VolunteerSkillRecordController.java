package com.example.demo.controller;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class VolunteerSkillRecordController {

    private final VolunteerSkillRecordService volunteerSkillRecordService;

    public VolunteerSkillRecordController(VolunteerSkillRecordService volunteerSkillRecordService) {
        this.volunteerSkillRecordService = volunteerSkillRecordService;
    }

    @PostMapping
    public VolunteerSkillRecord addOrUpdateSkill(@RequestBody VolunteerSkillRecord skill) {
        return volunteerSkillRecordService.addOrUpdateSkill(skill);
    }

    @GetMapping("/volunteer/{volunteerId}")
    public List<VolunteerSkillRecord> getSkills(@PathVariable Long volunteerId) {
        return volunteerSkillRecordService.getSkillsByVolunteer(volunteerId);
    }
}
