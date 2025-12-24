package com.example.demo.service.impl;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.service.TaskAssignmentRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskAssignmentRecordServiceImpl
        implements TaskAssignmentRecordService {

    private final TaskAssignmentRecordRepository repository;

    public TaskAssignmentRecordServiceImpl(
            TaskAssignmentRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public TaskAssignmentRecord assignTask(TaskAssignmentRecord record) {
        return repository.save(record);
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId) {
        return repository.findByTaskId(taskId);
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(
            Long volunteerId) {
        return repository.findByVolunteerId(volunteerId);
    }
}
