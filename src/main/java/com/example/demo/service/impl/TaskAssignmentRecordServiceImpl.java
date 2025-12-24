package com.example.demo.service.impl;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentRecordService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskAssignmentRecordServiceImpl
        implements TaskAssignmentRecordService {

    @Override
    public TaskAssignmentRecord assignTask(TaskAssignmentRecord record) {
        return record;
    }

    @Override
    public List<TaskAssignmentRecord> getAllAssignments() {
        return new ArrayList<>();
    }
}
