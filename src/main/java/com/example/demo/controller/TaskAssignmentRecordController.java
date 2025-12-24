package com.example.demo.controller;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class TaskAssignmentRecordController {

    private final TaskAssignmentRecordService taskAssignmentRecordService;

    public TaskAssignmentRecordController(TaskAssignmentRecordService taskAssignmentRecordService) {
        this.taskAssignmentRecordService = taskAssignmentRecordService;
    }

    @PostMapping("/{taskId}")
    public TaskAssignmentRecord assignTask(@PathVariable Long taskId) {
        return taskAssignmentRecordService.assignTask(taskId);
    }

    @GetMapping
    public List<TaskAssignmentRecord> getAllAssignments() {
        return taskAssignmentRecordService.getAllAssignments();
    }

    @GetMapping("/task/{taskId}")
    public List<TaskAssignmentRecord> getByTask(@PathVariable Long taskId) {
        return taskAssignmentRecordService.getAssignmentsByTask(taskId);
    }

    @GetMapping("/volunteer/{volunteerId}")
    public List<TaskAssignmentRecord> getByVolunteer(@PathVariable Long volunteerId) {
        return taskAssignmentRecordService.getAssignmentsByVolunteer(volunteerId);
    }
}
