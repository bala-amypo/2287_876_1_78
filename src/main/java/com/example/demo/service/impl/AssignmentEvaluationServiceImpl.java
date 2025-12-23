package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.AssignmentEvaluationService;
import java.util.*;

public class AssignmentEvaluationServiceImpl
        implements AssignmentEvaluationService {

    private final AssignmentEvaluationRecordRepository evalRepo;
    private final TaskAssignmentRecordRepository assignRepo;

    public AssignmentEvaluationServiceImpl(
            AssignmentEvaluationRecordRepository e,
            TaskAssignmentRecordRepository a) {
        evalRepo = e; assignRepo = a;
    }

    public AssignmentEvaluationRecord evaluateAssignment(
            AssignmentEvaluationRecord e) {

        TaskAssignmentRecord a =
                assignRepo.findById(e.getAssignmentId()).orElseThrow();

        if (!"COMPLETED".equals(a.getStatus()))
            throw new BadRequestException("Assignment not completed");

        return evalRepo.save(e);
    }

    public List<AssignmentEvaluationRecord> getEvaluationsByAssignment(Long id) {
        return evalRepo.findByAssignmentId(id);
    }
}
