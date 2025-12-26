package com.example.demo.service;

import com.example.demo.model.VolunteerSkillRecord;
import java.util.List;

public interface VolunteerSkillService {

    // 🔥 Controller expects this
    VolunteerSkillRecord addSkill(VolunteerSkillRecord skill);

    List<VolunteerSkillRecord> getSkillsByVolunteer(Long volunteerId);

    List<VolunteerSkillRecord> getSkillsBySkill(String skillName);
}
