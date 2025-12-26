package com.example.demo.service.impl;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.repository.AssignmentEvaluationRecordRepository;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentEvaluationServiceImpl implements AssignmentEvaluationService {

    @Autowired
    private AssignmentEvaluationRecordRepository repository;

    @Override
    public AssignmentEvaluationRecord evaluateAssignment(AssignmentEvaluationRecord evaluation) {
        return repository.save(evaluation);
    }

    @Override
    public List<AssignmentEvaluationRecord> getEvaluationsByAssignment(Long assignmentId) {
        return repository.findByAssignmentId(assignmentId);
    }
}
