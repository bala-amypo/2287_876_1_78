package com.example.demo.controller;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluations")
public class AssignmentEvaluationController {

    private final AssignmentEvaluationService assignmentEvaluationService;

    public AssignmentEvaluationController(AssignmentEvaluationService assignmentEvaluationService) {
        this.assignmentEvaluationService = assignmentEvaluationService;
    }

    @PostMapping
    public AssignmentEvaluationRecord evaluate(@RequestBody AssignmentEvaluationRecord record) {
        return assignmentEvaluationService.evaluateAssignment(record);
    }

    @GetMapping("/{assignmentId}")
    public List<AssignmentEvaluationRecord> getByAssignment(
            @PathVariable Long assignmentId) {
        return assignmentEvaluationService.getEvaluationsByAssignment(assignmentId);
    }
}
