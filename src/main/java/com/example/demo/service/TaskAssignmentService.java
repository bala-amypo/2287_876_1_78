package com.example.demo.service;

import com.example.demo.model.TaskAssignmentRecord;
import java.util.List;

public interface TaskAssignmentService {

    List<TaskAssignmentRecord> getAllAssignments();

    TaskAssignmentRecord assignTask(TaskAssignmentRecord record);

    List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId);
}
