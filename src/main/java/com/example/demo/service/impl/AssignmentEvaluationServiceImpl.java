package com.example.demo.service.impl;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.model.AssignmentStatus;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.repository.AssignmentEvaluationRepository;
import com.example.demo.repository.TaskAssignmentRepository;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentEvaluationServiceImpl
        implements AssignmentEvaluationService {

    private final AssignmentEvaluationRepository evaluationRepository;
    private final TaskAssignmentRepository taskAssignmentRepository;

    public AssignmentEvaluationServiceImpl(
            AssignmentEvaluationRepository evaluationRepository,
            TaskAssignmentRepository taskAssignmentRepository) {
        this.evaluationRepository = evaluationRepository;
        this.taskAssignmentRepository = taskAssignmentRepository;
    }

    @Override
    public AssignmentEvaluationRecord evaluateAssignment(
            AssignmentEvaluationRecord evaluation) {

        TaskAssignmentRecord assignment =
                taskAssignmentRepository.findById(
                        evaluation.getAssignmentId())
                        .orElseThrow(() ->
                                new RuntimeException("Assignment not found"));

        assignment.setStatus(AssignmentStatus.EVALUATED);
        taskAssignmentRepository.save(assignment);

        return evaluationRepository.save(evaluation);
    }

    @Override
    public List<AssignmentEvaluationRecord> getEvaluationsByAssignment(
            Long assignmentId) {
        return evaluationRepository.findByAssignmentId(assignmentId);
    }
}
