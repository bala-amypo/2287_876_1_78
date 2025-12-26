package com.example.demo.service;

import com.example.demo.model.TaskAssignmentRecord;
import java.util.List;

public interface TaskAssignmentService {
    List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId);
    void deleteAssignment(Long id);
}
