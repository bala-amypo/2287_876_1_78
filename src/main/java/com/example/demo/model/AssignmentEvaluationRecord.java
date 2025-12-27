package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AssignmentEvaluationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String feedback;
    private int marks;

    private LocalDateTime evaluatedAt;

    @ManyToOne
    @JoinColumn(name = "task_assignment_id")  // foreign key column
    private TaskAssignmentRecord taskAssignment;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }

    public int getMarks() { return marks; }
    public void setMarks(int marks) { this.marks = marks; }

    public LocalDateTime getEvaluatedAt() { return evaluatedAt; }
    public void setEvaluatedAt(LocalDateTime evaluatedAt) { this.evaluatedAt = evaluatedAt; }

    public TaskAssignmentRecord getTaskAssignment() { return taskAssignment; }
    public void setTaskAssignment(TaskAssignmentRecord taskAssignment) { this.taskAssignment = taskAssignment; }
}
