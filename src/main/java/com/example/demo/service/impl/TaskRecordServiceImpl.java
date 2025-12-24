package com.example.demo.service.impl;

import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.service.TaskRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskRecordServiceImpl implements TaskRecordService {

    private final TaskRecordRepository taskRecordRepository;

    public TaskRecordServiceImpl(TaskRecordRepository taskRecordRepository) {
        this.taskRecordRepository = taskRecordRepository;
    }

    @Override
    public TaskRecord createTask(TaskRecord record) {
        return taskRecordRepository.save(record);
    }

    @Override
    public List<TaskRecord> getAllTasks() {
        return taskRecordRepository.findAll();
    }
}
