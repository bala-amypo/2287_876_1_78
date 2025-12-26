package com.example.demo.service;

import com.example.demo.model.VolunteerSkillRecord;

import java.util.List;

public interface VolunteerSkillService {

    VolunteerSkillRecord addOrUpdateSkill(VolunteerSkillRecord record);

    List<VolunteerSkillRecord> getSkillsByVolunteer(Long volunteerId);
}
