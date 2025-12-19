package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
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
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    private final TaskAssignmentRecordRepository assignmentRepository;
    private final TaskRecordRepository taskRepository;
    private final VolunteerProfileRepository profileRepository;
    private final VolunteerSkillRecordRepository skillRepository;

    public TaskAssignmentServiceImpl(TaskAssignmentRecordRepository assignmentRepository,
                                     TaskRecordRepository taskRepository,
                                     VolunteerProfileRepository profileRepository,
                                     VolunteerSkillRecordRepository skillRepository) {
        this.assignmentRepository = assignmentRepository;
        this.taskRepository = taskRepository;
        this.profileRepository = profileRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    public TaskAssignmentRecord assignTask(Long taskId) {
        if (assignmentRepository.existsByTaskIdAndStatus(taskId, "ACTIVE")) {
            throw new BadRequestException("Task already has an ACTIVE assignment");
        }
        TaskRecord task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
        List<VolunteerProfile> candidates = profileRepository.findByAvailabilityStatus("AVAILABLE");
        for (VolunteerProfile vp : candidates) {
            List<VolunteerSkillRecord> skills = skillRepository.findByVolunteerId(vp.getId());
            boolean matches = skills.stream().anyMatch(s ->
                    s.getSkillName() != null && s.getSkillName().equalsIgnoreCase(task.getRequiredSkill()) &&
                            SkillLevelUtil.meetsOrExceeds(s.getSkillLevel(), task.getRequiredSkillLevel())
            );
            if (matches) {
                TaskAssignmentRecord rec = new TaskAssignmentRecord(task.getId(), vp.getId(), "ACTIVE");
                TaskAssignmentRecord saved = assignmentRepository.save(rec);
                task.setStatus("ACTIVE");
                taskRepository.save(task);
                return saved;
            }
        }
        throw new BadRequestException("No volunteer meets the required skill level");
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId) {
        return assignmentRepository.findByTaskId(taskId);
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId) {
        return assignmentRepository.findByVolunteerId(volunteerId);
    }
}
