package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.model.TaskRecord;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.repository.VolunteerSkillRecordRepository;
import com.example.demo.service.TaskAssignmentService;
import com.example.demo.util.SkillLevelUtil;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    private final TaskAssignmentRecordRepository assignmentRepo;
    private final TaskRecordRepository taskRepo;
    private final VolunteerProfileRepository volunteerRepo;
    private final VolunteerSkillRecordRepository skillRepo;

    public TaskAssignmentServiceImpl(
            TaskAssignmentRecordRepository assignmentRepo,
            TaskRecordRepository taskRepo,
            VolunteerProfileRepository volunteerRepo,
            VolunteerSkillRecordRepository skillRepo) {

        this.assignmentRepo = assignmentRepo;
        this.taskRepo = taskRepo;
        this.volunteerRepo = volunteerRepo;
        this.skillRepo = skillRepo;
    }

    @Override
    public TaskAssignmentRecord assignTask(Long taskId) {

        TaskRecord task = taskRepo.findById(taskId)
                .orElseThrow(() -> new BadRequestException("Task not found"));

        if (!"OPEN".equals(task.getStatus())) {
            throw new BadRequestException("Task not OPEN");
        }

        if (assignmentRepo.existsByTaskIdAndStatus(taskId, "ACTIVE")) {
            throw new BadRequestException("Task already assigned");
        }

        List<VolunteerProfile> volunteers =
                volunteerRepo.findByAvailabilityStatus("AVAILABLE");

        if (volunteers.isEmpty()) {
            throw new BadRequestException("No AVAILABLE volunteers");
        }

        VolunteerProfile bestVolunteer = volunteers.stream()
                .filter(v ->
                        skillRepo.findByVolunteerId(v.getId()).stream()
                                .anyMatch(s ->
                                        s.getSkillName().equals(task.getRequiredSkill()) &&
                                        SkillLevelUtil.levelRank(s.getSkillLevel())
                                                >= SkillLevelUtil.levelRank(
                                                    task.getRequiredSkillLevel()
                                                )
                                )
                )
                .max(Comparator.comparingInt(v ->
                        skillRepo.findByVolunteerId(v.getId()).stream()
                                .filter(s ->
                                        s.getSkillName().equals(
                                                task.getRequiredSkill()
                                        )
                                )
                                .mapToInt(s ->
                                        SkillLevelUtil.levelRank(s.getSkillLevel())
                                )
                                .max()
                                .orElse(0)
                ))
                .orElseThrow(() ->
                        new BadRequestException("No suitable volunteer")
                );

        TaskAssignmentRecord assignment = new TaskAssignmentRecord();
        assignment.setTaskId(taskId);
        assignment.setVolunteerId(bestVolunteer.getId());
        assignment.setStatus("ACTIVE");

        return assignmentRepo.save(assignment);
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId) {
        return assignmentRepo.findByTaskId(taskId);
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId) {
        return assignmentRepo.findByVolunteerId(volunteerId);
    }

    @Override
    public List<TaskAssignmentRecord> getAllAssignments() {
        return assignmentRepo.findAll();
    }
}
