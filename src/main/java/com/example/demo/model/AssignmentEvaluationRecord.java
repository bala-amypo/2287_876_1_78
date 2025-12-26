package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AssignmentEvaluationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long assignmentId;
    private String remarks;
    private Integer score;

    private LocalDateTime evaluatedAt; // ✅ ADD THIS

    @PrePersist
    public void prePersist() {
        evaluatedAt = LocalDateTime.now();
    }

    // getters & setters
    public LocalDateTime getEvaluatedAt() {
        return evaluatedAt;
    }

    public void setEvaluatedAt(LocalDateTime evaluatedAt) {
        this.evaluatedAt = evaluatedAt;
    }
}
