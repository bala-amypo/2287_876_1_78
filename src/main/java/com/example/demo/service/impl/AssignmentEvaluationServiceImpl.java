package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.repository.AssignmentEvaluationRecordRepository;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.stereotype.Service;

@Service
public class AssignmentEvaluationServiceImpl implements AssignmentEvaluationService {

    private final AssignmentEvaluationRecordRepository evaluationRepository;
    private final TaskAssignmentRecordRepository assignmentRepository;

    public AssignmentEvaluationServiceImpl(AssignmentEvaluationRecordRepository evaluationRepository,
                                           TaskAssignmentRecordRepository assignmentRepository) {
        this.evaluationRepository = evaluationRepository;
        this.assignmentRepository = assignmentRepository;
    }

    @Override
    public AssignmentEvaluationRecord evaluateAssignment(AssignmentEvaluationRecord evaluation) {
        TaskAssignmentRecord assignment = assignmentRepository.findById(evaluation.getAssignmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Assignment not found"));
        if (!"COMPLETED".equalsIgnoreCase(assignment.getStatus())) {
            throw new BadRequestException("Evaluation allowed only for COMPLETED assignments");
        }
        return evaluationRepository.save(evaluation);
    }
}
