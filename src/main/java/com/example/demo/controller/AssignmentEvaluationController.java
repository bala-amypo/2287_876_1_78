package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AssignmentEvaluation;
import com.example.demo.service.AssignmentEvaluationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/evaluations")
@Tag(name = "Assignment Evaluation", description = "Task evaluation APIs")
public class AssignmentEvaluationController {

    @Autowired
    private AssignmentEvaluationService evaluationService;

    @Operation(summary = "Submit evaluation")
    @PostMapping
    public AssignmentEvaluation submitEvaluation(
            @RequestBody AssignmentEvaluation evaluation) {
        return evaluationService.submitEvaluation(evaluation);
    }

    @Operation(summary = "Get evaluation by assignment")
    @GetMapping("/assignment/{assignmentId}")
    public AssignmentEvaluation getByAssignment(
            @PathVariable Long assignmentId) {
        return evaluationService.getByAssignmentId(assignmentId);
    }

    @Operation(summary = "List all evaluations")
    @GetMapping
    public List<AssignmentEvaluation> getAllEvaluations() {
        return evaluationService.getAllEvaluations();
    }
}
