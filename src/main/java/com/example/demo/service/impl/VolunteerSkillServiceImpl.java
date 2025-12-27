package com.example.demo.service.impl;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.VolunteerSkillRepository;
import com.example.demo.service.VolunteerSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class VolunteerSkillServiceImpl implements VolunteerSkillService {

    private final VolunteerSkillRepository volunteerSkillRepository;

    @Autowired
    public VolunteerSkillServiceImpl(VolunteerSkillRepository volunteerSkillRepository) {
        this.volunteerSkillRepository = volunteerSkillRepository;
    }

    @Override
    public VolunteerSkillRecord addSkill(VolunteerSkillRecord skillRecord) {
        skillRecord.setAddedTime(LocalDateTime.now());
        return volunteerSkillRepository.save(skillRecord);
    }
}
