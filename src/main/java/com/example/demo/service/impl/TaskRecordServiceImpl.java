package com.example.demo.service.impl;

import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.service.TaskRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskRecordServiceImpl implements TaskRecordService {

    private final TaskRecordRepository repository;

    public TaskRecordServiceImpl(TaskRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public TaskRecord createTask(TaskRecord task) {
        return repository.save(task);
    }

    @Override
    public TaskRecord getTaskById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<TaskRecord> getAllTasks() {
        return repository.findAll();
    }

    @Override
    public List<TaskRecord> getTasksByStatus(String status) {
        return repository.findByStatus(status);
    }
}
