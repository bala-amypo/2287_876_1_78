package com.example.demo.service.impl;

import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.service.TaskRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskRecordServiceImpl
        implements TaskRecordService {

    private final TaskRecordRepository repo;

    public TaskRecordServiceImpl(TaskRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public TaskRecord save(TaskRecord task) {
        task.setStatus(TaskRecord.Status.OPEN);
        return repo.save(task);
    }

    @Override
    public List<TaskRecord> getAll() {
        return repo.findAll();
    }

    @Override
    public TaskRecord getTaskByCode(String taskCode) {
        return repo.findByTaskCode(taskCode);
    }
}
