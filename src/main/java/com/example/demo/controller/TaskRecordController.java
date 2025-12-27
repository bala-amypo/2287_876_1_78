package com.example.demo.controller;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskRecordController {

    @Autowired
    private TaskRecordService taskRecordService;

    @PostMapping
    public ResponseEntity<TaskRecord> createTask(@RequestBody TaskRecord task) {
        if (task.getTaskName() == null || task.getTaskName().isEmpty()) {
            throw new BadRequestException("Task name is required");
        }
        TaskRecord created = taskRecordService.createTask(task);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskRecord> getTaskById(@PathVariable Long id) {
        TaskRecord task = taskRecordService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @GetMapping
    public ResponseEntity<List<TaskRecord>> getAllTasks() {
        List<TaskRecord> tasks = taskRecordService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }
}
