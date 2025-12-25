package com.example.demo.controller;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/task-assignments")
public class TaskAssignmentController {

    private final TaskAssignmentService assignmentService;

    public TaskAssignmentController(TaskAssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping("/{taskId}")
    public TaskAssignmentRecord assignTask(@PathVariable Long taskId) {
        return assignmentService.assignTask(taskId);
    }

    @GetMapping
    public List<TaskAssignmentRecord> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }

    @GetMapping("/task/{taskId}")
    public List<TaskAssignmentRecord> getAssignmentsByTask(@PathVariable Long taskId) {
        return assignmentService.getAssignmentsByTask(taskId);
    }

    @GetMapping("/volunteer/{volunteerId}")
    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(@PathVariable Long volunteerId) {
        return assignmentService.getAssignmentsByVolunteer(volunteerId);
    }
}
