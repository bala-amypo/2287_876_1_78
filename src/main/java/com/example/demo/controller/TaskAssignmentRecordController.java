package com.example.demo.controller;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-assignments")
public class TaskAssignmentRecordController {

    private final TaskAssignmentRecordService taskAssignmentRecordService;

    public TaskAssignmentRecordController(
            TaskAssignmentRecordService taskAssignmentRecordService) {
        this.taskAssignmentRecordService = taskAssignmentRecordService;
    }

    @PostMapping
    public TaskAssignmentRecord assignTask(
            @RequestBody TaskAssignmentRecord record) {
        return taskAssignmentRecordService.assignTask(record);
    }

    @GetMapping
    public List<TaskAssignmentRecord> getAllAssignments() {
        return taskAssignmentRecordService.getAllAssignments();
    }
}
