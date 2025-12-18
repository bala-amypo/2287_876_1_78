package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_assignment")
public class TaskAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long taskId;

    @Column(nullable = false)
    private Long volunteerId;

    private LocalDateTime assignedAt;

    @Enumerated(EnumType.STRING)
    private AssignmentStatus status;

    private String notes;

    // ✅ Required by JPA
    public TaskAssignmentRecord() {
    }

    @PrePersist
    public void onAssign() {
        if (this.status == null) {
            this.status = AssignmentStatus.ACTIVE;
        }
        if (this.assignedAt == null) {
            this.assignedAt = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(Long volunteerId) {
        this.volunteerId = volunteerId;
    }

    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }

    public AssignmentStatus getStatus() {
        return status;
    }

    public void setStatus(AssignmentStatus status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
