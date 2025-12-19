package com.example.demo.controller;

import com.example.demo.model.AssignmentEvaluation;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evaluation")
public class AssignmentEvaluationController {

    private final AssignmentEvaluationService service;

    public AssignmentEvaluationController(AssignmentEvaluationService service) {
        this.service = service;
    }

    @PostMapping
    public AssignmentEvaluation evaluate(
            @RequestBody AssignmentEvaluation evaluation) {
        return service.save(evaluation);
    }
}
