package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class AssignmentEvaluationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ✅ REQUIRED for findByAssignment_Id
    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    private Integer score;
    private String remarks;

    // ✅ JPA needs no-arg constructor
    public AssignmentEvaluationRecord() {
    }

    // constructor used in controller
    public AssignmentEvaluationRecord(Assignment assignment, Integer score, String remarks) {
        this.assignment = assignment;
        this.score = score;
        this.remarks = remarks;
    }

    public Long getId() { return id; }

    public Assignment getAssignment() { return assignment; }
    public void setAssignment(Assignment assignment) { this.assignment = assignment; }

    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
}
