package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.model.TaskRecord;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.*;
import com.example.demo.service.TaskAssignmentService;
import com.example.demo.util.SkillLevelUtil;
import java.util.List;

public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    private final TaskAssignmentRecordRepository assignmentRepo;
    private final TaskRecordRepository taskRepo;
    private final VolunteerProfileRepository volunteerRepo;
    private final VolunteerSkillRepository skillRepo;

    public TaskAssignmentServiceImpl(TaskAssignmentRecordRepository assignmentRepo,
                                     TaskRecordRepository taskRepo,
                                     VolunteerProfileRepository volunteerRepo,
                                     VolunteerSkillRepository skillRepo) {
        this.assignmentRepo = assignmentRepo;
        this.taskRepo = taskRepo;
        this.volunteerRepo = volunteerRepo;
        this.skillRepo = skillRepo;
    }

    @Override
    public TaskAssignmentRecord assignTask(Long taskId) {
        TaskRecord task = taskRepo.findById(taskId).orElseThrow();

        if (assignmentRepo.existsByTaskIdAndStatus(taskId, "ACTIVE")) {
            throw new BadRequestException("Task already has ACTIVE assignment");
        }

        List<VolunteerProfile> volunteers = volunteerRepo.findByAvailabilityStatus("AVAILABLE");
        if (volunteers.isEmpty()) {
            throw new BadRequestException("No AVAILABLE volunteers");
        }

        for (VolunteerProfile v : volunteers) {
            List<VolunteerSkillRecord> skills = skillRepo.findByVolunteerId(v.getId());
            for (VolunteerSkillRecord s : skills) {
                if (s.getSkillName().equals(task.getRequiredSkill()) &&
                    SkillLevelUtil.levelRank(s.getSkillLevel()) >=
                    SkillLevelUtil.levelRank(task.getRequiredSkillLevel())) {

                    TaskAssignmentRecord assignment = new TaskAssignmentRecord();
                    assignment.setTaskId(taskId);
                    assignment.setVolunteerId(v.getId());
                    return assignmentRepo.save(assignment);
                }
            }
        }

        throw new BadRequestException("No volunteer meets required skill level");
    }

    @Override
    public List<TaskAssignmentRecord> getAllAssignments() {
        return assignmentRepo.findAll();
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId) {
        return assignmentRepo.findByTaskId(taskId);
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId) {
        return assignmentRepo.findByVolunteerId(volunteerId);
    }
}
