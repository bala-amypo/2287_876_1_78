package com.example.demo.controller;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskAssignmentService;
import com.example.demo.service.TaskRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRecordService taskRecordService;
    private final TaskAssignmentService taskAssignmentService;

    public TaskController(TaskRecordService taskRecordService, TaskAssignmentService taskAssignmentService) {
        this.taskRecordService = taskRecordService;
        this.taskAssignmentService = taskAssignmentService;
    }

    @PostMapping
    public ResponseEntity<TaskRecord> create(@RequestBody TaskRecord task) {
        return ResponseEntity.ok(taskRecordService.createTask(task));
    }
    @PostMapping("/{taskId}/assign")
    public ResponseEntity<TaskAssignmentRecord> assignVolunteer(
        @PathVariable Long taskId) {

    TaskAssignmentRecord record =
            taskService.assignVolunteer(taskId);

    return ResponseEntity.ok(record);
}


    @PostMapping("/{taskId}/assign")
    public ResponseEntity<TaskAssignmentRecord> assign(@PathVariable Long taskId) {
        return ResponseEntity.ok(taskAssignmentService.assignTask(taskId));
    }
}
