package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "task_assignment")
public class TaskAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long taskId;
    private Long volunteerId;

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
    public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}


    public void setVolunteerId(Long volunteerId) {
        this.volunteerId = volunteerId;
    }
}
