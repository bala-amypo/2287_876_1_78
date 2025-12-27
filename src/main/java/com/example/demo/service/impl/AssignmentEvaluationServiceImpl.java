package com.example.demo.service.impl;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.repository.AssignmentEvaluationRecordRepository;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentEvaluationServiceImpl implements AssignmentEvaluationService {

    private final AssignmentEvaluationRecordRepository assignmentEvaluationRecordRepository;
    private final TaskAssignmentRecordRepository taskAssignmentRecordRepository;

    public AssignmentEvaluationServiceImpl(
            AssignmentEvaluationRecordRepository assignmentEvaluationRecordRepository,
            TaskAssignmentRecordRepository taskAssignmentRecordRepository) {

        this.assignmentEvaluationRecordRepository = assignmentEvaluationRecordRepository;
        this.taskAssignmentRecordRepository = taskAssignmentRecordRepository;
    }

    @Override
    public AssignmentEvaluationRecord evaluateAssignment(
            AssignmentEvaluationRecord evaluation) {

        // Save evaluation
        AssignmentEvaluationRecord saved =
                assignmentEvaluationRecordRepository.save(evaluation);

        // Optional: update task assignment status if needed
        if (evaluation.getTaskAssignment() != null) {
            TaskAssignmentRecord taskAssignment =
                    evaluation.getTaskAssignment();

            taskAssignmentRecordRepository.save(taskAssignment);
        }

        return saved;
    }

    @Override
    public List<AssignmentEvaluationRecord> getEvaluationsByAssignment(
            Long assignmentId) {

        return assignmentEvaluationRecordRepository
                .findByTaskAssignmentId(assignmentId);
    }
}
