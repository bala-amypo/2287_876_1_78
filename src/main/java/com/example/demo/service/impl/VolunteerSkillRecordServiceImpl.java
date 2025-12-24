package com.example.demo.service.impl;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillRecordService;
import org.springframework.stereotype.Service;

@Service
public class VolunteerSkillRecordServiceImpl
        implements VolunteerSkillRecordService {

    @Override
    public VolunteerSkillRecord addOrUpdateSkill(
            VolunteerSkillRecord record) {
        return record;
    }
}
