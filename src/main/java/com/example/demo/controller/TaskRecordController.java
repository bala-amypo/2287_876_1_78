package com.example.demo.controller;

import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskRecordController {

    private final TaskRecordService service;

    public TaskRecordController(TaskRecordService service) {
        this.service = service;
    }

    @PostMapping
    public TaskRecord createTask(@RequestBody TaskRecord task) {
        return service.createTask(task);
    }

    @PutMapping("/{id}")
    public TaskRecord updateTask(
            @PathVariable Long id,
            @RequestBody TaskRecord task) {
        return service.updateTask(id, task);
    }

    @GetMapping
    public List<TaskRecord> getAllTasks() {
        return service.getAllTasks();
    }

    @GetMapping("/open")
    public List<TaskRecord> getOpenTasks() {
        return service.getOpenTasks();
    }

    @GetMapping("/code/{taskCode}")
    public Optional<TaskRecord> getByCode(
            @PathVariable String taskCode) {
        return service.getTaskByCode(taskCode);
    }
}
