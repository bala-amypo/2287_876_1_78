package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.model.TaskRecord;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.repository.VolunteerSkillRecordRepository;
import com.example.demo.service.TaskAssignmentService;
import com.example.demo.util.SkillLevelUtil;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskAssignmentServiceImpl implements TaskAssignmentService {
    private final TaskAssignmentRecordRepository assignmentRepo;
    private final TaskRecordRepository taskRepo;
    private final VolunteerProfileRepository profileRepo;
    private final VolunteerSkillRecordRepository skillRepo;

    public TaskAssignmentServiceImpl(TaskAssignmentRecordRepository assignmentRepo,
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
        TaskRecord task = taskRepo.findById(taskId).orElseThrow(() -> new BadRequestException("Task not found"));
        if (!"OPEN".equals(task.getStatus())) {
            throw new BadRequestException("Task not OPEN");
        }
        if (assignmentRepo.existsByTaskIdAndStatus(taskId, "ACTIVE")) {
            throw new BadRequestException("Task already has ACTIVE assignment");
        }
        List<VolunteerProfile> available = profileRepo.findByAvailabilityStatus("AVAILABLE");
        if (available == null || available.isEmpty()) {
            throw new BadRequestException("No AVAILABLE volunteers");
        }
        // Filter volunteers with required skill and sufficient level
        List<VolunteerProfile> qualified = available.stream().filter(v -> {
            List<VolunteerSkillRecord> skills = skillRepo.findByVolunteerId(v.getId());
            return skills.stream().anyMatch(s -> s.getSkillName().equals(task.getRequiredSkill()) &&
                    SkillLevelUtil.levelRank(s.getSkillLevel()) >= SkillLevelUtil.levelRank(task.getRequiredSkillLevel()));
        }).collect(Collectors.toList());

        if (qualified.isEmpty()) {
            throw new BadRequestException("No volunteer meets required skill level");
        }

        // Choose highest skill level
        VolunteerProfile chosen = qualified.stream().max(Comparator.comparingInt(v -> {
            List<VolunteerSkillRecord> skills = skillRepo.findByVolunteerId(v.getId());
            return skills.stream()
                    .filter(s -> s.getSkillName().equals(task.getRequiredSkill()))
                    .mapToInt(s -> SkillLevelUtil.levelRank(s.getSkillLevel()))
                    .max().orElse(0);
        })).orElseThrow(() -> new BadRequestException("No suitable volunteer"));

        TaskAssignmentRecord record = new TaskAssignmentRecord();
        record.setTaskId(taskId);
        record.setVolunteerId(chosen.getId());
        record.setStatus("ACTIVE");
        assignmentRepo.save(record);

        task.setStatus("IN_PROGRESS");
        taskRepo.save(task);
        return record;
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
