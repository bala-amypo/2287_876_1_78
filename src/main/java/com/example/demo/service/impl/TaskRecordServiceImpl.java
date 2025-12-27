package com.example.demo.service.impl;

import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.service.TaskRecordService;
import java.util.List;
import java.util.Optional;

public class TaskRecordServiceImpl implements TaskRecordService {

    private final TaskRecordRepository repo;

    public TaskRecordServiceImpl(TaskRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public TaskRecord createTask(TaskRecord task) {
        if (task.getStatus() == null) task.setStatus("OPEN");
        return repo.save(task);
    }

    @Override
    public TaskRecord updateTask(Long id, TaskRecord task) {
        TaskRecord existing = repo.findById(id).orElseThrow();
        existing.setTaskName(task.getTaskName());
        existing.setRequiredSkill(task.getRequiredSkill());
        existing.setRequiredSkillLevel(task.getRequiredSkillLevel());
        existing.setPriority(task.getPriority());
        existing.setStatus(task.getStatus());
        return repo.save(existing);
    }

    @Override
    public List<TaskRecord> getOpenTasks() {
        return repo.findByStatus("OPEN");
    }

    @Override
    public List<TaskRecord> getAllTasks() {
        return repo.findAll();
    }

    @Override
    public Optional<TaskRecord> getTaskByCode(String code) {
        return repo.findByTaskCode(code);
    }
}
