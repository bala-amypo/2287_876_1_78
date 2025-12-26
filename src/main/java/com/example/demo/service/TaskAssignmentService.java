package com.example.demo.service;

import com.example.demo.model.TaskAssignmentRecord;

import java.util.List;

public interface TaskAssignmentService {

    TaskAssignmentRecord assignTask(TaskAssignmentRecord assignment);

    List<TaskAssignmentRecord> getAllAssignments();

    List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId);

    List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId);
}
