package com.example.demo.controller;

import com.example.demo.service.*;
import com.example.demo.model.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRecordService taskService;
    private final TaskAssignmentService assignmentService;

    public TaskController(TaskRecordService t, TaskAssignmentService a) {
        this.taskService = t;
        this.assignmentService = a;
    }

    @PostMapping
    public TaskRecord create(@RequestBody TaskRecord task) {
        return taskService.createTask(task);
    }

    @PostMapping("/{id}/assign")
    public TaskAssignmentRecord assign(@PathVariable Long id) {
        return assignmentService.assignTask(id);
    }
}
