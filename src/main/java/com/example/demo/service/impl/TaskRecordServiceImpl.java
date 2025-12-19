package com.example.demo.service.impl;


import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.service.TaskRecordService;
import org.springframework.stereotype.Service;

@Service
public class TaskRecordServiceImpl implements TaskRecordService {

    private final TaskRecordRepository repository;

    public TaskRecordServiceImpl(TaskRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public TaskRecord createTask(TaskRecord task) {

        if (task.getRequiredSkill() == null
                || task.getRequiredSkillLevel() == null) {
            throw new BadRequestException("Required skill and level are mandatory");
        }

        task.setStatus("OPEN");
        return repository.save(task);
    }

    @Override
    public TaskRecord getTaskById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
    }
}
