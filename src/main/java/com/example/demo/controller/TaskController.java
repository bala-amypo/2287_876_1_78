package com.example.demo.controller;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRecordService taskService;

    // ✅ Constructor Injection (REQUIRED)
    public TaskController(TaskRecordService taskService) {
        this.taskService = taskService;
    }

    // ✅ Assign task to volunteer
    @PostMapping("/{taskId}/assign")
    public ResponseEntity<TaskAssignmentRecord> assignTask(@PathVariable Long taskId) {
        TaskAssignmentRecord record = taskService.assignTask(taskId);
        return ResponseEntity.ok(record);
    }
}
