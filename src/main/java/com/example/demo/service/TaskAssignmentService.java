package com.example.demo.service;

import com.example.demo.model.TaskAssignmentRecord;
import java.util.List;

public interface TaskAssignmentService {

    TaskAssignmentRecord assignTask(TaskAssignmentRecord assignment);

    List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId);

    List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId);

    TaskAssignmentRecord completeAssignment(Long assignmentId);
}
