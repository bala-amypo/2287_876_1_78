package com.example.demo.controller;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskRecordService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRecordService taskRecordService;

    public TaskController(TaskRecordService taskRecordService) {
        this.taskRecordService = taskRecordService;
    }

    @PostMapping("/{id}/assign")
    public TaskAssignmentRecord assign(@PathVariable Long id) {
        return taskRecordService.assignTask(id);
    }
}
