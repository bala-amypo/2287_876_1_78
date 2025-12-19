package com.example.demo.controller;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class TaskAssignmentController {

    private final TaskAssignmentService taskAssignmentService;

    public TaskAssignmentController(TaskAssignmentService taskAssignmentService) {
        this.taskAssignmentService = taskAssignmentService;
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<TaskAssignmentRecord>> byTask(@PathVariable Long taskId) {
        return ResponseEntity.ok(taskAssignmentService.getAssignmentsByTask(taskId));
    }

    @GetMapping("/volunteer/{volunteerId}")
    public ResponseEntity<List<TaskAssignmentRecord>> byVolunteer(@PathVariable Long volunteerId) {
        return ResponseEntity.ok(taskAssignmentService.getAssignmentsByVolunteer(volunteerId));
    }
}
