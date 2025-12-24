package com.example.demo.model;

import java.time.LocalDateTime;

public class TaskAssignmentRecord {

    private Long volunteerId;
    private Long taskId;

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
