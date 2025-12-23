package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.TaskAssignmentService;
import com.example.demo.util.SkillLevelUtil;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    private final TaskAssignmentRecordRepository assignRepo;
    private final TaskRecordRepository taskRepo;
    private final VolunteerProfileRepository volRepo;
    private final VolunteerSkillRecordRepository skillRepo;

    public TaskAssignmentServiceImpl(
            TaskAssignmentRecordRepository a,
            TaskRecordRepository t,
            VolunteerProfileRepository v,
            VolunteerSkillRecordRepository s) {

        this.assignRepo = a;
        this.taskRepo = t;
        this.volRepo = v;
        this.skillRepo = s;
    }

    @Override
    public TaskAssignmentRecord assignTask(Long taskId) {

        if (assignRepo.existsByTaskIdAndStatus(taskId, "ACTIVE")) {
            throw new BadRequestException("ACTIVE assignment already exists");
        }

        TaskRecord task = taskRepo.findById(taskId)
                .orElseThrow(() -> new BadRequestException("Task not found"));

        List<VolunteerProfile> volunteers =
                volRepo.findByAvailability("AVAILABLE");

        for (VolunteerProfile v : volunteers) {

            List<VolunteerSkillRecord> skills =
                    skillRepo.findByVolunteerId(v.getId());

            for (VolunteerSkillRecord s : skills) {

                if (s.getSkillName().equalsIgnoreCase(task.getRequiredSkill())
                        && SkillLevelUtil.levelRank(s.getSkillLevel())
                        >= SkillLevelUtil.levelRank(task.getRequiredSkillLevel())) {

                    TaskAssignmentRecord rec = new TaskAssignmentRecord();
                    rec.setTaskId(taskId);
                    rec.setVolunteerId(v.getId());
                    rec.setStatus("ACTIVE");
                    rec.setAssignedDate(LocalDate.now().toString());

                    task.setStatus("ACTIVE");

                    taskRepo.save(task);
                    return assignRepo.save(rec);
                }
            }
        }

        throw new BadRequestException("No volunteer meets required skill level");
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByTask(Long id) {
        return assignRepo.findByTaskId(id);
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long id) {
        return assignRepo.findByVolunteerId(id);
    }

    @Override
    public List<TaskAssignmentRecord> getAllAssignments() {
        return assignRepo.findAll();
    }
}
