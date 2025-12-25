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

    private final TaskAssignmentRecordRepository assignmentRepository;
    private final TaskRecordRepository taskRepository;
    private final VolunteerProfileRepository volunteerRepository;
    private final VolunteerSkillRecordRepository skillRepository;

    public TaskAssignmentServiceImpl(
            TaskAssignmentRecordRepository assignmentRepository,
            TaskRecordRepository taskRepository,
            VolunteerProfileRepository volunteerRepository,
            VolunteerSkillRecordRepository skillRepository) {
        this.assignmentRepository = assignmentRepository;
        this.taskRepository = taskRepository;
        this.volunteerRepository = volunteerRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    public TaskAssignmentRecord assignTask(Long taskId) {
        TaskRecord task = taskRepository.findById(taskId)
                .orElseThrow(() -> new BadRequestException("Task not found"));

        if (!"OPEN".equals(task.getStatus())) {
            throw new BadRequestException("Task is not OPEN");
        }

        if (assignmentRepository.existsByTaskIdAndStatus(taskId, "ACTIVE")) {
            throw new BadRequestException("Task already has ACTIVE assignment");
        }

        // AVAILABLE volunteers fetch pannitu
        List<VolunteerProfile> volunteers = volunteerRepository.findByAvailabilityStatus("AVAILABLE");
        if (volunteers.isEmpty()) {
            throw new BadRequestException("No AVAILABLE volunteers");
        }

        // Best volunteer pick panna logic
        VolunteerProfile selectedVolunteer = volunteers.stream()
                .filter(v -> skillRepository.findByVolunteerId(v.getId()).stream()
                        .anyMatch(skill -> skill.getSkillName().equals(task.getRequiredSkill())
                                && SkillLevelUtil.levelRank(skill.getSkillLevel())
                                   >= SkillLevelUtil.levelRank(task.getRequiredSkillLevel())))
                .max(Comparator.comparingInt(v -> skillRepository.findByVolunteerId(v.getId()).stream()
                        .filter(skill -> skill.getSkillName().equals(task.getRequiredSkill()))
                        .mapToInt(skill -> SkillLevelUtil.levelRank(skill.getSkillLevel()))
                        .max().orElse(0)))
                .orElseThrow(() -> new BadRequestException("No volunteer meets required skill level"));

        TaskAssignmentRecord assignment = new TaskAssignmentRecord();
        assignment.setTaskId(taskId);
        assignment.setVolunteerId(selectedVolunteer.getId());

        return assignmentRepository.save(assignment);
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId) {
        return assignmentRepository.findByTaskId(taskId);
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId) {
        return assignmentRepository.findByVolunteerId(volunteerId);
    }

    @Override
    public List<TaskAssignmentRecord> getAllAssignments() {
        return assignmentRepository.findAll();
    }
}
