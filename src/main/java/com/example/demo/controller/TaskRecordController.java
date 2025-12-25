package com.example.demo.controller;

import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskRecordService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskRecordController {

    private final TaskRecordService taskService;

    public TaskRecordController(TaskRecordService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public TaskRecord createTask(@RequestBody TaskRecord task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{taskId}")
    public TaskRecord updateTask(@PathVariable Long taskId, @RequestBody TaskRecord task) {
        return taskService.updateTask(taskId, task);
    }

    @GetMapping("/code/{taskCode}")
    public Optional<TaskRecord> getTaskByCode(@PathVariable String taskCode) {
        return taskService.getTaskByCode(taskCode);
    }

    @GetMapping("/open")
    public List<TaskRecord> getOpenTasks() {
        return taskService.getOpenTasks();
    }

    @GetMapping
    public List<TaskRecord> getAllTasks() {
        return taskService.getAllTasks();
    }
}
