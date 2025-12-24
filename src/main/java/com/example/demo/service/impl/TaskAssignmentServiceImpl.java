package com.example.demo.service.impl;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    private TaskAssignmentRecordRepository taskAssignmentRecordRepository;

    public TaskAssignmentServiceImpl(TaskAssignmentRecordRepository taskAssignmentRecordRepository) {
        this.taskAssignmentRecordRepository = taskAssignmentRecordRepository;
    }

    @Override
    public TaskAssignmentRecord assignTask(TaskAssignmentRecord assignment) {
        return taskAssignmentRecordRepository.save(assignment);
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId) {
        return taskAssignmentRecordRepository.findByTaskId(taskId);
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId) {
        return taskAssignmentRecordRepository.findByVolunteerId(volunteerId);
    }

    @Override
    public TaskAssignmentRecord completeAssignment(Long assignmentId) {
        TaskAssignmentRecord assignment = taskAssignmentRecordRepository.findById(assignmentId).orElseThrow(() -> new RuntimeException("Assignment not found"));
        assignment.setStatus("completed");
        return taskAssignmentRecordRepository.save(assignment);
    }
}
