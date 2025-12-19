package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.VolunteerSkillRecordRepository;
import com.example.demo.service.VolunteerSkillService;
import com.example.demo.util.SkillLevelUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerSkillServiceImpl implements VolunteerSkillService {

    private final VolunteerSkillRecordRepository volunteerSkillRecordRepository;

    public VolunteerSkillServiceImpl(VolunteerSkillRecordRepository volunteerSkillRecordRepository) {
        this.volunteerSkillRecordRepository = volunteerSkillRecordRepository;
    }

    @Override
    public List<VolunteerSkillRecord> getSkillsByVolunteer(Long volunteerId) {
        return volunteerSkillRecordRepository.findByVolunteerId(volunteerId);
    }

    @Override
    public VolunteerSkillRecord addOrUpdateSkill(VolunteerSkillRecord skill) {
        if (skill.getSkillName() == null || skill.getSkillName().isBlank()) {
            throw new BadRequestException("Skill name must not be blank");
        }
        if (!SkillLevelUtil.meetsOrExceeds(skill.getSkillLevel(), "BEGINNER")) {
            throw new BadRequestException("Invalid skill level");
        }
        return volunteerSkillRecordRepository.save(skill);
    }
}
