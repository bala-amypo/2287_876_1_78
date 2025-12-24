package com.example.demo.model;

import java.time.LocalDateTime;

public class TaskAssignmentRecord {

    private Long volunteerId;
    private Long taskId;
    private String status;
    private LocalDateTime assignedAt;

public LocalDateTime getAssignedAt() {
    return assignedAt;
}

public void setAssignedAt(LocalDateTime assignedAt) {
    this.assignedAt = assignedAt;
}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Long getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(Long volunteerId) {
        this.volunteerId = volunteerId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
}
