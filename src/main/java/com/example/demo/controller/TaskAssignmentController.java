package com.example.demo.controller;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-assignments")
public class TaskAssignmentController {

    @Autowired
    private TaskAssignmentService service;

    @GetMapping("/task/{taskId}")
    public List<TaskAssignmentRecord> getAssignmentsByTask(@PathVariable Long taskId) {
        return service.getAssignmentsByTask(taskId);
    }

    @DeleteMapping("/{id}")
    public void deleteAssignment(@PathVariable Long id) {
        service.deleteAssignment(id);
    }
}
