package com.example.demo.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class SkillRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skillName;
    private int level;

    private Instant updatedAt;

    @PrePersist
    @PreUpdate
    public void updateTimestamp() {
        this.updatedAt = Instant.now();
    }

    // getters and setters
}
