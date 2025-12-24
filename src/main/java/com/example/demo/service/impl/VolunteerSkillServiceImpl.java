package com.example.demo.service.impl;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillService;
import org.springframework.stereotype.Service;

@Service
public class VolunteerSkillServiceImpl
        implements VolunteerSkillService {

    @Override
    public VolunteerSkillRecord addOrUpdateSkill(
            VolunteerSkillRecord record) {
        return record;
    }
}
