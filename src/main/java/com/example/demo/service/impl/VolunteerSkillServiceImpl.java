package com.example.demo.service.impl;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.VolunteerSkillRepository;
import com.example.demo.service.VolunteerSkillService;
import java.time.Instant;
import java.util.List;

public class VolunteerSkillServiceImpl implements VolunteerSkillService {

    private final VolunteerSkillRepository repo;

    public VolunteerSkillServiceImpl(VolunteerSkillRepository repo) {
        this.repo = repo;
    }

    @Override
    public VolunteerSkillRecord addOrUpdateSkill(VolunteerSkillRecord skill) {
        skill.setUpdatedAt(Instant.now());
        return repo.save(skill);
    }

    @Override
    public List<VolunteerSkillRecord> getSkillsByVolunteer(Long volunteerId) {
        return repo.findByVolunteerId(volunteerId);
    }
}
