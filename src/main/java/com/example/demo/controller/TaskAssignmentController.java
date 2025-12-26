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

    @GetMapping
    public List<TaskAssignmentRecord> getAll() {
        return service.getAll();
    }

    @PostMapping
    public TaskAssignmentRecord create(@RequestBody TaskAssignmentRecord record) {
        return service.assignTask(record);
    }
}
