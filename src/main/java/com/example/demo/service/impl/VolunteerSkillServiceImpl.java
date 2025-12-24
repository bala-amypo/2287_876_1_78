package com.example.demo.service.impl;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.VolunteerSkillRecordRepository;
import com.example.demo.service.VolunteerSkillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerSkillServiceImpl implements VolunteerSkillService {

    private VolunteerSkillRecordRepository volunteerSkillRecordRepository;

    public VolunteerSkillServiceImpl(VolunteerSkillRecordRepository volunteerSkillRecordRepository) {
        this.volunteerSkillRecordRepository = volunteerSkillRecordRepository;
    }

    @Override
    public VolunteerSkillRecord addOrUpdateSkill(VolunteerSkillRecord skill) {
        return volunteerSkillRecordRepository.save(skill);
    }

    @Override
    public List<VolunteerSkillRecord> getSkillsByVolunteer(Long volunteerId) {
        return volunteerSkillRecordRepository.findByVolunteerId(volunteerId);
    }
}
