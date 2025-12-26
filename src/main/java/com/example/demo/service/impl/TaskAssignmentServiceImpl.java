package com.example.demo.service.impl;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.repository.TaskAssignmentRepository;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    @Autowired
    private TaskAssignmentRepository repository;

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId) {
        return repository.findByTaskId(taskId);
    }

    @Override
    public void deleteAssignment(Long id) {
        repository.deleteById(id);
    }
}
