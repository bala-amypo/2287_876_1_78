package com.example.demo.service.impl;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.repository.TaskAssignmentRepository;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    private final TaskAssignmentRepository taskAssignmentRepository;

    public TaskAssignmentServiceImpl(TaskAssignmentRepository taskAssignmentRepository) {
        this.taskAssignmentRepository = taskAssignmentRepository;
    }

    @Override
    @Transactional
    public TaskAssignmentRecord assignTask(TaskAssignmentRecord assignment) {
        return taskAssignmentRepository.save(assignment);
    }

    @Override
    public List<TaskAssignmentRecord> getAllAssignments() {
        return taskAssignmentRepository.findAll();
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId) {
        return taskAssignmentRepository.findByVolunteerId(volunteerId);
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId) {
        // Add repository method if needed: findByTaskId
        return taskAssignmentRepository.findAll(); // placeholder, implement properly
    }
}
