package com.example.demo.service;

import com.example.demo.model.VolunteerSkillRecord;
import java.util.List;

public interface VolunteerSkillRecordService {

    VolunteerSkillRecord addSkill(VolunteerSkillRecord record);

    List<VolunteerSkillRecord> getSkillsByVolunteer(Long volunteerId);

    List<VolunteerSkillRecord> findBySkillAndLevel(
            String skill,
            String level
    );
}
