package com.example.demo.service.impl;

import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.service.TaskRecordService;
import java.util.*;

public class TaskRecordServiceImpl implements TaskRecordService {

    private final TaskRecordRepository repo;

    public TaskRecordServiceImpl(TaskRecordRepository r) {
        this.repo = r;
    }

    public TaskRecord createTask(TaskRecord t) {
        t.setStatus("OPEN");
        return repo.save(t);
    }

    public TaskRecord updateTask(Long id, TaskRecord t) {
        TaskRecord ex = repo.findById(id).orElseThrow();
        ex.setTaskName(t.getTaskName());
        ex.setRequiredSkill(t.getRequiredSkill());
        ex.setRequiredSkillLevel(t.getRequiredSkillLevel());
        ex.setPriority(t.getPriority());
        ex.setStatus(t.getStatus());
        return repo.save(ex);
    }

    public List<TaskRecord> getOpenTasks() {
        return repo.findByStatus("OPEN");
    }

    public Optional<TaskRecord> getTaskByCode(String code) {
        return repo.findByTaskCode(code);
    }

    public List<TaskRecord> getAllTasks() {
        return repo.findAll();
    }
}
