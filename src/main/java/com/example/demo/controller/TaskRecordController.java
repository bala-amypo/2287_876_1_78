package com.example.demo.controller;

import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskRecordController {

    private final TaskRecordService service;

    public TaskRecordController(TaskRecordService service) {
        this.service = service;
    }

    @PostMapping
    public TaskRecord create(@RequestBody TaskRecord task) {
        return service.save(task);
    }

    @GetMapping
    public List<TaskRecord> getAll() {
        return service.getAll();
    }

    @GetMapping("/{taskCode}")
    public TaskRecord getByCode(@PathVariable String taskCode) {
        return service.getTaskByCode(taskCode);
    }
}
