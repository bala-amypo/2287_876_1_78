package com.example.demo.service.impl;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskRecordService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TaskRecordServiceImpl implements TaskRecordService {

    @Override
    public TaskAssignmentRecord assignTask(Long taskId) {
        TaskAssignmentRecord record = new TaskAssignmentRecord();
        record.setTaskId(taskId);
        record.setAssignedAt(LocalDateTime.now());
        record.setStatus("ASSIGNED");
        return record;
    }
}
