package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.service.TaskRecordService;
import org.springframework.stereotype.Service;

@Service
public class TaskRecordServiceImpl implements TaskRecordService {

    private final TaskRecordRepository taskRecordRepository;

    public TaskRecordServiceImpl(TaskRecordRepository taskRecordRepository) {
        this.taskRecordRepository = taskRecordRepository;
    }

    @Override
    public TaskRecord createTask(TaskRecord task) {
        if (task.getRequiredSkill() == null || task.getRequiredSkillLevel() == null) {
            throw new BadRequestException("Required skill and level are mandatory");
        }
        task.setStatus("OPEN");
        return taskRecordRepository.save(task);
    }

    @Override
    public TaskRecord getTaskById(Long id) {
        return taskRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
    }
}
