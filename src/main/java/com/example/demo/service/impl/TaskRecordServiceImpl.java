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

    private final TaskRecordRepository taskRepository;

    public TaskRecordServiceImpl(TaskRecordRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskRecord createTask(TaskRecord task) {
        if (task.getStatus() == null) {
            task.setStatus("OPEN");
        }
        return taskRepository.save(task);
    }

    @Override
    public TaskRecord updateTask(Long taskId, TaskRecord updatedTask) {
        TaskRecord existing = taskRepository.findById(taskId)
                .orElseThrow(() -> new BadRequestException("Task not found"));

        existing.setTaskName(updatedTask.getTaskName());
        existing.setRequiredSkill(updatedTask.getRequiredSkill());
        existing.setRequiredSkillLevel(updatedTask.getRequiredSkillLevel());
        existing.setPriority(updatedTask.getPriority());
        existing.setStatus(updatedTask.getStatus());

        return taskRepository.save(existing);
    }

    @Override
    public Optional<TaskRecord> getTaskByCode(String taskCode) {
        return taskRepository.findByTaskCode(taskCode);
    }

    @Override
    public List<TaskRecord> getOpenTasks() {
        return taskRepository.findByStatus("OPEN");
    }

    @Override
    public List<TaskRecord> getAllTasks() {
        return taskRepository.findAll();
    }
}
