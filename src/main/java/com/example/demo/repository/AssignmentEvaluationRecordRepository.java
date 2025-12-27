package com.example.demo.repository;

import com.example.demo.model.AssignmentEvaluationRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentEvaluationRepository
        extends JpaRepository<AssignmentEvaluationRecord, Long> {

    List<AssignmentEvaluationRecord> findByAssignmentId(Long assignmentId);
}
