package com.example.demo.service.impl;

import com.example.demo.model.AssignmentStatus;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.repository.TaskAssignmentRepository;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    private final TaskAssignmentRepository repository;

    public TaskAssignmentServiceImpl(TaskAssignmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TaskAssignmentRecord> getAllAssignments() {
        return repository.findAll();
    }

    @Override
    public TaskAssignmentRecord assignTask(TaskAssignmentRecord record) {
        record.setStatus(AssignmentStatus.ASSIGNED);
        return repository.save(record);
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId) {
        return repository.findByVolunteerId(volunteerId);
    }
}
