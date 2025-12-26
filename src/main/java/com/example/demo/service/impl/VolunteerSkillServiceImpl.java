package com.example.demo.service.impl;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.VolunteerSkillRecordRepository;
import com.example.demo.service.VolunteerSkillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerSkillServiceImpl
        implements VolunteerSkillService {

    private final VolunteerSkillRecordRepository repo;

    public VolunteerSkillServiceImpl(
            VolunteerSkillRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public VolunteerSkillRecord addSkill(
            VolunteerSkillRecord record) {
        return repo.save(record);
    }

    @Override
    public List<VolunteerSkillRecord> getSkillsByVolunteer(
            Long volunteerId) {
        return repo.findByVolunteerId(volunteerId);
    }
}
