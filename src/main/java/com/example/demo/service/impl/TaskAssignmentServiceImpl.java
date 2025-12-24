package com.example.demo.service.impl;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskAssignmentServiceImpl
        implements TaskAssignmentService {

    @Override
    public TaskAssignmentRecord assignTask(TaskAssignmentRecord record) {
        return record;
    }

    @Override
    public List<TaskAssignmentRecord> getAllAssignments() {
        return new ArrayList<>();
    }
}
