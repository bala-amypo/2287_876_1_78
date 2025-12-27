package com.example.demo.service.impl;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.repository.AssignmentEvaluationRepository;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.service.AssignmentEvaluationService;
import java.time.Instant;
import java.util.List;

public class AssignmentEvaluationServiceImpl implements AssignmentEvaluationService {

    private final AssignmentEvaluationRepository repo;
    private final TaskAssignmentRecordRepository assignmentRepo;

    public AssignmentEvaluationServiceImpl(AssignmentEvaluationRepository repo,
                                           TaskAssignmentRecordRepository assignmentRepo) {
        this.repo = repo;
        this.assignmentRepo = assignmentRepo;
    }

    @Override
    public AssignmentEvaluationRecord evaluateAssignment(AssignmentEvaluationRecord evaluation) {
        TaskAssignmentRecord assignment = assignmentRepo.findById(evaluation.getAssignmentId()).orElseThrow();
        evaluation.setEvaluatedAt(Instant.now());
        return repo.save(evaluation);
    }

    @Override
    public List<AssignmentEvaluationRecord> getEvaluationsByAssignment(Long assignmentId) {
        return repo.findByAssignmentId(assignmentId);
    }
}
