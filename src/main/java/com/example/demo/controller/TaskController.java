package com.example.demo.controller;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRecordService taskService;

    public TaskController(TaskRecordService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/{taskId}/assign")
    public ResponseEntity<TaskAssignmentRecord> assignTask(@PathVariable Long taskId) {
        return ResponseEntity.ok(taskService.assignTask(taskId));
    }
}
