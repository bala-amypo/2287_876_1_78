package com.example.demo.repository;

import com.example.demo.model.AssignmentEvaluationRecord;

import java.util.List;
import java.util.Optional;

public interface AssignmentEvaluationRecordRepository {
    AssignmentEvaluationRecord save(AssignmentEvaluationRecord record);
    Optional<AssignmentEvaluationRecord> findById(Long id);
    List<AssignmentEvaluationRecord> findByAssignmentId(Long assignmentId);
}
