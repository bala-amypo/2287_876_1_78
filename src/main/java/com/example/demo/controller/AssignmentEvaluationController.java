package com.example.demo.controller;

import com.example.demo.dto.EvaluationRequest;
import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluations")
@RequiredArgsConstructor
public class AssignmentEvaluationController {

    private final AssignmentEvaluationService assignmentEvaluationService;

    @PostMapping
    public ResponseEntity<AssignmentEvaluationRecord> evaluate(@RequestBody EvaluationRequest request) {
        AssignmentEvaluationRecord entity = new AssignmentEvaluationRecord();
        entity.setAssignmentId(request.getAssignmentId());
        entity.setScore(request.getRating());
        entity.setRemarks(request.getComments());

        return ResponseEntity.ok(assignmentEvaluationService.evaluateAssignment(entity));
    }

    @GetMapping("/{assignmentId}")
    public ResponseEntity<List<AssignmentEvaluationRecord>> getByAssignment(@PathVariable Long assignmentId) {
        return ResponseEntity.ok(assignmentEvaluationService.getEvaluationsByAssignment(assignmentId));
    }
}
