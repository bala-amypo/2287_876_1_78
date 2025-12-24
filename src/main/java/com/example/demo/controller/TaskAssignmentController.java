package com.example.demo.controller;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class TaskAssignmentController {

    private final TaskAssignmentService taskAssignmentService;

    public TaskAssignmentController(TaskAssignmentService taskAssignmentService) {
        this.taskAssignmentService = taskAssignmentService;
    }

    @PostMapping("/{taskId}")
    public TaskAssignmentRecord assignTask(@PathVariable Long taskId) {
        return taskAssignmentService.assignTask(taskId);
    }

    @GetMapping
    public List<TaskAssignmentRecord> getAllAssignments() {
        return taskAssignmentService.getAllAssignments();
    }

    @GetMapping("/task/{taskId}")
    public List<TaskAssignmentRecord> getByTask(@PathVariable Long taskId) {
        return taskAssignmentService.getAssignmentsByTask(taskId);
    }

    @GetMapping("/volunteer/{volunteerId}")
    public List<TaskAssignmentRecord> getByVolunteer(@PathVariable Long volunteerId) {
        return taskAssignmentService.getAssignmentsByVolunteer(volunteerId);
    }
}
