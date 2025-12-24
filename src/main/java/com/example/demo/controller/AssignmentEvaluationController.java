package com.example.demo.controller;

import com.example.demo.dto.EvaluationRequest;
import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evaluations")
public class AssignmentEvaluationController {

    private final AssignmentEvaluationService assignmentEvaluationService;

    public AssignmentEvaluationController(AssignmentEvaluationService assignmentEvaluationService) {
        this.assignmentEvaluationService = assignmentEvaluationService;
    }
    @PostMapping
public ResponseEntity<AssignmentEvaluationRecord> evaluate(
        @RequestBody EvaluationRequest request) {

    Assignment assignment = new Assignment();
    assignment.setId(request.getAssignmentId());

    AssignmentEvaluationRecord entity =
            new AssignmentEvaluationRecord(
                    assignment,
                    request.getRating(),
                    request.getComments()
            );

    return ResponseEntity.ok(
            assignmentEvaluationService.evaluateAssignment(entity)
    );
}



}
