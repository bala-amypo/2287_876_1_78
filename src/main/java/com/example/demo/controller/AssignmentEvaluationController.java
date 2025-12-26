package com.example.demo.controller;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluations")
public class AssignmentEvaluationController {

    private final AssignmentEvaluationService service;

    public AssignmentEvaluationController(AssignmentEvaluationService service) {
        this.service = service;
    }

    @PostMapping
    public AssignmentEvaluationRecord evaluateAssignment(
            @RequestBody AssignmentEvaluationRecord record) {
        return service.evaluateAssignment(record);
    }

    @GetMapping("/{assignmentId}")
    public List<AssignmentEvaluationRecord> getEvaluations(
            @PathVariable Long assignmentId) {
        return service.getEvaluationsByAssignment(assignmentId);
    }
}
