package com.example.demo.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class AssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        ACTIVE, INACTIVE
    }

    @PrePersist
    public void setDefaultStatus() {
        if (status == null) {
            status = Status.ACTIVE;
        }
    }

    // getters and setters
}
