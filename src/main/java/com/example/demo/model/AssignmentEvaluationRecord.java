package com.example.demo.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class AssignmentEvaluationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant evaluatedAt;

    @PrePersist
    public void setTimestamp() {
        this.evaluatedAt = Instant.now();
    }

    // getters and setters
}
