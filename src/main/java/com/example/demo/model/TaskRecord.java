package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class TaskRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String requiredSkill;
    private String requiredSkillLevel;
    private Status status;
    private String priority;

    public enum Status {
        OPEN, ASSIGNED, CLOSED
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRequiredSkill() { return requiredSkill; }
    public void setRequiredSkill(String requiredSkill) { this.requiredSkill = requiredSkill; }

    public String getRequiredSkillLevel() { return requiredSkillLevel; }
    public void setRequiredSkillLevel(String requiredSkillLevel) { this.requiredSkillLevel = requiredSkillLevel; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }
}
