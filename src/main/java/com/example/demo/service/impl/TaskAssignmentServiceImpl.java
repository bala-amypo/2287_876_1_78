package com.example.demo.service.impl;

import com.example.demo.model.TaskAssignment;
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
    public TaskAssignment assignTask(TaskAssignment assignment) {
        return taskAssignmentRepository.save(assignment);
    }

    @Override
    public List<TaskAssignment> getAllAssignments() {
        return taskAssignmentRepository.findAll();
    }
}
