package com.example.demo.service;

import com.example.demo.model.TaskAssignmentRecord;
import java.util.List;

public interface TaskAssignmentService {

    TaskAssignmentRecord assignTask(TaskAssignmentRecord record);

    List<TaskAssignmentRecord> getAllAssignments();
}
