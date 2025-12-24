package com.example.demo.service.impl;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.repository.AssignmentEvaluationRecordRepository;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentEvaluationServiceImpl
        implements AssignmentEvaluationService {

    private final AssignmentEvaluationRecordRepository assignmentEvaluationRecordRepository;

    public AssignmentEvaluationServiceImpl(
            AssignmentEvaluationRecordRepository assignmentEvaluationRecordRepository) {
        this.assignmentEvaluationRecordRepository = assignmentEvaluationRecordRepository;
    }

    @Override
    public AssignmentEvaluationRecord evaluateAssignment(AssignmentEvaluationRecord evaluation) {
        return assignmentEvaluationRecordRepository.save(evaluation);
    }

    @Override
    public List<AssignmentEvaluationRecord> getEvaluationsByAssignment(Long assignmentId) {
        // ✅ CORRECT METHOD CALL
        return assignmentEvaluationRecordRepository.findByAssignment_Id(assignmentId);
    }
}
