package com.example.demo.service.impl;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskAssignmentServiceImpl
        implements TaskAssignmentService {

    private final TaskAssignmentRecordRepository
            taskAssignmentRecordRepository;

    public TaskAssignmentServiceImpl(
            TaskAssignmentRecordRepository taskAssignmentRecordRepository) {

        this.taskAssignmentRecordRepository =
                taskAssignmentRecordRepository;
    }

    @Override
    public TaskAssignmentRecord createTaskAssignment(
            TaskAssignmentRecord taskAssignment) {

        return taskAssignmentRecordRepository.save(taskAssignment);
    }

    @Override
    public List<TaskAssignmentRecord> getAllTaskAssignments() {
        return taskAssignmentRecordRepository.findAll();
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(
            Long volunteerId) {

        return taskAssignmentRecordRepository
                .findByVolunteerId(volunteerId);
    }
}
