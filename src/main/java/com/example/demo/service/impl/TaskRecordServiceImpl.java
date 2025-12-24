package com.example.demo.service.impl;

import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskRecordService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskRecordServiceImpl implements TaskRecordService {

    @Override
    public TaskRecord updateTask(Long id, TaskRecord record) {
        return record;
    }

    @Override
    public List<TaskRecord> getOpenTasks() {
        return new ArrayList<>();
    }
}
