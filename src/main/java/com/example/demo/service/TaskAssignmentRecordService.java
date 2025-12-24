package com.example.demo.service;

import com.example.demo.model.TaskAssignmentRecord;
import java.util.List;

public interface TaskAssignmentRecordService {

    TaskAssignmentRecord assignTask(TaskAssignmentRecord record);

    List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId);

    List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId);
}
