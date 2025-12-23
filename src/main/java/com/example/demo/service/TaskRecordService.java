package com.example.demo.service;

import com.example.demo.model.TaskRecord;

import java.util.List;
import java.util.Optional;

public interface TaskRecordService {
    TaskRecord createTask(TaskRecord record);
    TaskRecord updateTask(Long id, TaskRecord updates);
    List<TaskRecord> getAllTasks();
    List<TaskRecord> getOpenTasks();
    Optional<TaskRecord> getTaskByCode(String code);
}
