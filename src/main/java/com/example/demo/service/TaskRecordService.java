package com.example.demo.service;

import com.example.demo.model.TaskRecord;
import java.util.List;
import java.util.Optional;

public interface TaskRecordService {
    
    TaskRecord createTask(TaskRecord task);
    
    TaskRecord getTaskById(Long id);
    
    List<TaskRecord> getAllTasks();
    
    List<TaskRecord> getOpenTasks();
    
    Optional<TaskRecord> getTaskByCode(String taskCode);
    
    TaskRecord updateTask(Long id, TaskRecord updatedTask);
}