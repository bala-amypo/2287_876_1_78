package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.TaskAssignmentService;
import com.example.demo.util.SkillLevelUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskAssignmentServiceImpl
        implements TaskAssignmentService {

    private final TaskAssignmentRecordRepository assignmentRepo;
    private final TaskRecordRepository taskRepo;
    private final VolunteerProfileRepository profileRepo;
    private final VolunteerSkillRecordRepository skillRepo;

    public TaskAssignmentServiceImpl(
            TaskAssignmentRecordRepository assignmentRepo,
            TaskRecordRepository taskRepo,
            VolunteerProfileRepository profileRepo,
            VolunteerSkillRecordRepository skillRepo) {

        this.assignmentRepo = assignmentRepo;
        this.taskRepo = taskRepo;
        this.profileRepo = profileRepo;
        this.skillRepo = skillRepo;
    }

    @Override
    public TaskAssignmentRecord assignTask(Long taskId) {

        TaskRecord task = taskRepo.findById(taskId)
                .orElseThrow(() ->
                        new BadRequestException("Task not found"));

        if (assignmentRepo.existsByTaskIdAndStatus(
                taskId, "ACTIVE")) {
            throw new BadRequestException(
                    "ACTIVE assignment already exists");
        }

        List<VolunteerProfile> volunteers =
                profileRepo.findByAvailabilityStatus("AVAILABLE");

        if (volunteers.isEmpty()) {
            throw new BadRequestException(
                    "No AVAILABLE volunteers");
        }

        for (VolunteerProfile v : volunteers) {

            List<VolunteerSkillRecord> skills =
                    skillRepo.findByVolunteerId(v.getId());

            for (VolunteerSkillRecord s : skills) {

                if (s.getSkillName().equals(
                        task.getRequiredSkill())) {

                    int vLevel =
                            SkillLevelUtil.levelRank(
                                    s.getSkillLevel());
                    int tLevel =
                            SkillLevelUtil.levelRank(
                                    task.getRequiredSkillLevel());

                    if (vLevel >= tLevel) {

                        TaskAssignmentRecord rec =
                                new TaskAssignmentRecord();
                        rec.setTaskId(taskId);
                        rec.setVolunteerId(v.getId());
                        rec.setStatus("ACTIVE");

                        task.setStatus("ASSIGNED");

                        assignmentRepo.save(rec);
                        taskRepo.save(task);

                        return rec;
                    }
                }
            }
        }
        throw new BadRequestException(
                "Volunteer does not meet required skill level");
    }

    @Override
    public List<TaskAssignmentRecord> getAllAssignments() {
        return assignmentRepo.findAll();
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByTask(
            Long taskId) {
        return assignmentRepo.findByTaskId(taskId);
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(
            Long volunteerId) {
        return assignmentRepo.findByVolunteerId(volunteerId);
    }
}
