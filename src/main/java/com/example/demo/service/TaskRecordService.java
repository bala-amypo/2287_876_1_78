package com.example.demo.service;

import com.example.demo.model.TaskRecord;
import java.util.List;

public interface TaskRecordService {

    TaskRecord save(TaskRecord task);

    List<TaskRecord> getAll();

    TaskRecord getTaskByCode(String taskCode);
}
