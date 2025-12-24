package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.service.TaskRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskRecordServiceImpl implements TaskRecordService {

    private TaskRecordRepository taskRecordRepository;

    public TaskRecordServiceImpl(TaskRecordRepository taskRecordRepository) {
        this.taskRecordRepository = taskRecordRepository;
    }

    @Override
    public TaskRecord createTask(TaskRecord task) {
        return taskRecordRepository.save(task);
    }

    @Override
    public TaskRecord getTaskById(Long id) {
        return taskRecordRepository.findById(id).orElseThrow(() -> new BadRequestException("Task not found"));
    }

    @Override
    public List<TaskRecord> getAllTasks() {
        return taskRecordRepository.findAll();
    }

    @Override
    public Optional<TaskRecord> findByTaskCode(String taskCode) {
        return taskRecordRepository.findByTaskCode(taskCode);
    }

    @Override
    public List<TaskRecord> getTasksByStatus(String status) {
        return taskRecordRepository.findByStatus(status);
    }
}
