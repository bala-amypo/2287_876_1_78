package com.example.demo.controller;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillRecordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/volunteer-skills")
public class VolunteerSkillRecordController {

    private final VolunteerSkillRecordService volunteerSkillRecordService;

    public VolunteerSkillRecordController(
            VolunteerSkillRecordService volunteerSkillRecordService) {
        this.volunteerSkillRecordService = volunteerSkillRecordService;
    }

    @PostMapping
    public VolunteerSkillRecord addSkill(
            @RequestBody VolunteerSkillRecord record) {
        return volunteerSkillRecordService.addOrUpdateSkill(record);
    }
}
