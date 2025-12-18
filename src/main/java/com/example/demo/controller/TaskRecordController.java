package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.TaskAssignment;
import com.example.demo.service.TaskAssignmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/assignments")
@Tag(name = "Task Assignments", description = "Task assignment APIs")
public class TaskAssignmentController {

    @Autowired
    private TaskAssignmentService assignmentService;

    @Operation(summary = "Auto assign task")
    @PostMapping("/assign/{taskId}")
    public TaskAssignment autoAssign(@PathVariable Long taskId) {
        return assignmentService.autoAssign(taskId);
    }

    @Operation(summary = "Update assignment status")
    @PutMapping("/{id}/status")
    public TaskAssignment updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return assignmentService.updateStatus(id, status);
    }

    @Operation(summary = "Get assignments by volunteer")
    @GetMapping("/volunteer/{volunteerId}")
    public List<TaskAssignment> getByVolunteer(@PathVariable Long volunteerId) {
        return assignmentService.getByVolunteer(volunteerId);
    }

    @Operation(summary = "Get assignments by task")
    @GetMapping("/task/{taskId}")
    public List<TaskAssignment> getByTask(@PathVariable Long taskId) {
        return assignmentService.getByTask(taskId);
    }

    @Operation(summary = "List all assignments")
    @GetMapping
    public List<TaskAssignment> getAllAssignments() {
        return assignmentService.getAll();
    }
}
