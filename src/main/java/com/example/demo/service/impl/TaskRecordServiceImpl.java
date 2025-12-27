package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.service.TaskRecordService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskRecordServiceImpl implements TaskRecordService {
    
    private final TaskRecordRepository taskRecordRepository;
    
    public TaskRecordServiceImpl(TaskRecordRepository taskRecordRepository) {
        this.taskRecordRepository = taskRecordRepository;
    }
    
    @Override
    public TaskRecord createTask(TaskRecord task) {
        if (task.getStatus() == null) {
            task.setStatus("OPEN");
        }
        return taskRecordRepository.save(task);
    }
    
    @Override
    public TaskRecord getTaskById(Long id) {
        return taskRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
    }
    
    @Override
    public List<TaskRecord> getAllTasks() {
        return taskRecordRepository.findAll();
    }
    
    @Override
    public List<TaskRecord> getOpenTasks() {
        return taskRecordRepository.findByStatus("OPEN");
    }
    
    @Override
    public Optional<TaskRecord> getTaskByCode(String taskCode) {
        return taskRecordRepository.findByTaskCode(taskCode);
    }
    
    @Override
    public TaskRecord updateTask(Long id, TaskRecord updatedTask) {
        TaskRecord existing = getTaskById(id);
        
        if (updatedTask.getTaskName() != null) {
            existing.setTaskName(updatedTask.getTaskName());
        }
        if (updatedTask.getTitle() != null) {
            existing.setTitle(updatedTask.getTitle());
        }
        if (updatedTask.getDescription() != null) {
            existing.setDescription(updatedTask.getDescription());
        }
        if (updatedTask.getRequiredSkill() != null) {
            existing.setRequiredSkill(updatedTask.getRequiredSkill());
        }
        if (updatedTask.getRequiredSkillLevel() != null) {
            existing.setRequiredSkillLevel(updatedTask.getRequiredSkillLevel());
        }
        if (updatedTask.getPriority() != null) {
            existing.setPriority(updatedTask.getPriority());
        }
        if (updatedTask.getStatus() != null) {
            existing.setStatus(updatedTask.getStatus());
        }
        
        return taskRecordRepository.save(existing);
    }
}