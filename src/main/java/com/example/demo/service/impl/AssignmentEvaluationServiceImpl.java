package com.example.demo.service.impl;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.model.AssignmentStatus;

import com.example.demo.repository.AssignmentEvaluationRecordRepository;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AssignmentEvaluationServiceImpl
        implements AssignmentEvaluationService {

    private final AssignmentEvaluationRecordRepository repo;
    private final TaskAssignmentRecordRepository assignmentRepo;

    public AssignmentEvaluationServiceImpl(
            AssignmentEvaluationRecordRepository repo,
            TaskAssignmentRecordRepository assignmentRepo) {
        this.repo = repo;
        this.assignmentRepo = assignmentRepo;
    }

    @Override
    public AssignmentEvaluationRecord evaluateAssignment(
            AssignmentEvaluationRecord evaluation) {

        TaskAssignmentRecord assignment =
                assignmentRepo.findById(
                        evaluation.getAssignmentId()).orElse(null);

        if (assignment != null) {
            assignment.setStatus(AssignmentStatus.EVALUATED);
            assignmentRepo.save(assignment);
        }

        evaluation.setEvaluatedAt(LocalDateTime.now());
        return repo.save(evaluation);
    }

    @Override
    public List<AssignmentEvaluationRecord>
    getEvaluationsByAssignment(Long assignmentId) {
        return repo.findByAssignmentId(assignmentId);
    }
}
