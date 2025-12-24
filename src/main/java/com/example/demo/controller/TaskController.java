package com.example.demo.controller;

import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRecordService taskRecordService;

    public TaskController(TaskRecordService taskRecordService) {
        this.taskRecordService = taskRecordService;
    }

    @PostMapping
    public TaskRecord createTask(@RequestBody TaskRecord task) {
        return taskRecordService.createTask(task);
    }

    @PutMapping("/{id}")
    public TaskRecord updateTask(@PathVariable Long id,
                                 @RequestBody TaskRecord task) {
        return taskRecordService.updateTask(id, task);
    }

    @GetMapping("/open")
    public List<TaskRecord> getOpenTasks() {
        return taskRecordService.getOpenTasks();
    }

    @GetMapping
    public List<TaskRecord> getAllTasks() {
        return taskRecordService.getAllTasks();
    }
}
