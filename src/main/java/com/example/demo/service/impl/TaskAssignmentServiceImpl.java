package com.example.demo.service.impl;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.model.TaskRecord;
import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.repository.VolunteerSkillRecordRepository;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    private final TaskAssignmentRecordRepository repo;
    private final VolunteerSkillRecordRepository skillRepo;

    public TaskAssignmentServiceImpl(
            TaskAssignmentRecordRepository repo,
            VolunteerSkillRecordRepository skillRepo) {
        this.repo = repo;
        this.skillRepo = skillRepo;
    }

    @Override
    public TaskAssignmentRecord assignTask(TaskAssignmentRecord rec) {

        List<VolunteerSkillRecord> skills =
                skillRepo.findByVolunteerId(rec.getVolunteerId());

        for (VolunteerSkillRecord s : skills) {
            if (s.getSkillLevel() >= 3) {
                rec.setStatus("ASSIGNED");
                break;
            }
        }

        rec.setTaskStatus(TaskRecord.Status.ASSIGNED);
        return repo.save(rec);
    }

    @Override
    public List<TaskAssignmentRecord> getAll() {
        return repo.findAll();
    }
}
