package com.example.demo.service;

import com.example.demo.model.TaskRecord;
import java.util.List;
import java.util.Optional;

public interface TaskRecordService {

    TaskRecord createTask(TaskRecord task);

    TaskRecord getTaskById(Long id);

    List<TaskRecord> getAllTasks();

    Optional<TaskRecord> findByTaskCode(String taskCode);

    List<TaskRecord> getTasksByStatus(String status);
}
