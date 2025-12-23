package com.example.demo.service.impl;

import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.service.TaskRecordService;

import java.util.List;
import java.util.Optional;

public class TaskRecordServiceImpl implements TaskRecordService {
    private final TaskRecordRepository repository;

    public TaskRecordServiceImpl(TaskRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public TaskRecord createTask(TaskRecord record) {
        if (record.getStatus() == null) {
            record.setStatus("OPEN");
        }
        return repository.save(record);
    }

    @Override
    public TaskRecord updateTask(Long id, TaskRecord updates) {
        TaskRecord existing = repository.findById(id).orElse(null);
        if (existing == null) return null;
        existing.setTaskName(updates.getTaskName());
        existing.setRequiredSkill(updates.getRequiredSkill());
        existing.setRequiredSkillLevel(updates.getRequiredSkillLevel());
        existing.setPriority(updates.getPriority());
        existing.setStatus(updates.getStatus());
        return repository.save(existing);
    }

    @Override
    public List<TaskRecord> getAllTasks() {
        return repository.findAll();
    }

    @Override
    public List<TaskRecord> getOpenTasks() {
        return repository.findByStatus("OPEN");
    }

    @Override
    public Optional<TaskRecord> getTaskByCode(String code) {
        return repository.findByTaskCode(code);
    }
}
