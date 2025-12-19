package com.example.demo.service.impl;


import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.VolunteerSkillRecordRepository;
import com.example.demo.service.VolunteerSkillService;
import com.example.demo.util.SkillLevelUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerSkillServiceImpl implements VolunteerSkillService {

    private final VolunteerSkillRecordRepository repository;

    public VolunteerSkillServiceImpl(VolunteerSkillRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<VolunteerSkillRecord> getSkillsByVolunteer(Long volunteerId) {
        return repository.findByVolunteerId(volunteerId);
    }

    public VolunteerSkillRecord addSkill(VolunteerSkillRecord skill) {

        if (skill.getSkillName() == null || skill.getSkillName().isBlank()) {
            throw new BadRequestException("Skill name cannot be empty");
        }

        if (!SkillLevelUtil.isValidLevel(skill.getSkillLevel())) {
            throw new BadRequestException("Invalid skill level");
        }

        return repository.save(skill);
    }
}
