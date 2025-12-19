package com.example.demo.controller;


import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evaluations")
public class AssignmentEvaluationController {

    private final AssignmentEvaluationService service;

    public AssignmentEvaluationController(AssignmentEvaluationService service) {
        this.service = service;
    }

    @PostMapping
    public AssignmentEvaluationRecord evaluate(@RequestBody EvaluationRequest request) {

        AssignmentEvaluationRecord record =
                new AssignmentEvaluationRecord(
                        request.getAssignmentId(),
                        request.getRating(),
                        request.getComments()
                );

        return service.evaluateAssignment(record);
    }
}
