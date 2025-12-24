package com.example.demo.service;

import com.example.demo.model.TaskRecord;
import java.util.List;

public interface TaskRecordService {
    TaskRecord createTask(TaskRecord record);
    List<TaskRecord> getAllTasks();
}
