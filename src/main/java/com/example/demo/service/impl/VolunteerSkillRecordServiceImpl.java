package com.example.demo.service.impl;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.VolunteerSkillRecordRepository;
import com.example.demo.service.VolunteerSkillRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerSkillRecordServiceImpl
        implements VolunteerSkillRecordService {

    private final VolunteerSkillRecordRepository repository;

    public VolunteerSkillRecordServiceImpl(
            VolunteerSkillRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public VolunteerSkillRecord addSkill(VolunteerSkillRecord record) {
        return repository.save(record);
    }

    @Override
    public List<VolunteerSkillRecord> getSkillsByVolunteer(Long volunteerId) {
        return repository.findByVolunteerId(volunteerId);
    }

    @Override
    public List<VolunteerSkillRecord> findBySkillAndLevel(
            String skill,
            String level) {
        return repository.findBySkillNameAndSkillLevel(skill, level);
    }
}
