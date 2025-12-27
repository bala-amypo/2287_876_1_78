package com.example.demo.service.impl;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.repository.AssignmentEvaluationRepository;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AssignmentEvaluationServiceImpl implements AssignmentEvaluationService {

    private final AssignmentEvaluationRepository assignmentEvaluationRepository;

    @Autowired
    public AssignmentEvaluationServiceImpl(AssignmentEvaluationRepository assignmentEvaluationRepository) {
        this.assignmentEvaluationRepository = assignmentEvaluationRepository;
    }

    @Override
    public AssignmentEvaluationRecord evaluateAssignment(AssignmentEvaluationRecord evaluation) {
        evaluation.setEvaluationTime(LocalDateTime.now());
        return assignmentEvaluationRepository.save(evaluation);
    }

    @Override
    public List<AssignmentEvaluationRecord> getEvaluationsByTaskAssignment(Long taskAssignmentId) {
        return assignmentEvaluationRepository.findByTaskAssignmentId(taskAssignmentId);
    }
}
