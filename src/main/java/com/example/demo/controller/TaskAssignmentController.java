package com.example.demo.controller;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-assignments")
public class TaskAssignmentController {

    private final TaskAssignmentService service;

    public TaskAssignmentController(TaskAssignmentService service) {
        this.service = service;
    }

    @PostMapping
    public TaskAssignmentRecord assignTask(@RequestBody TaskAssignmentRecord record) {
        return service.assignTask(record);
    }

    @GetMapping
    public List<TaskAssignmentRecord> getAllAssignments() {
        return service.getAllAssignments();
    }

    @GetMapping("/task/{taskId}")
    public List<TaskAssignmentRecord> getAssignmentsByTask(@PathVariable Long taskId) {
        return service.getAssignmentsByTask(taskId);
    }
}
