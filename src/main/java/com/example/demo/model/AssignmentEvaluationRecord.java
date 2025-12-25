package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "assignment_evaluations")
public class AssignmentEvaluationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long assignmentId; // foreign key

    private Integer score;

    private String remarks;

    // Default constructor
    public AssignmentEvaluationRecord() {
    }

    // Constructor with all fields
    public AssignmentEvaluationRecord(Long id, Long assignmentId, Integer score, String remarks) {
        this.id = id;
        this.assignmentId = assignmentId;
        this.score = score;
        this.remarks = remarks;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Long assignmentId) {
        this.assignmentId = assignmentId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
