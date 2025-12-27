package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "assignment_evaluation_records")
public class AssignmentEvaluationRecord {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "assignment_id")
    private Long assignmentId;
    
    private Integer rating;
    
    private String comments;
    
    private String feedback;
    
    @Column(name = "evaluated_at")
    private LocalDateTime evaluatedAt;
    
    public AssignmentEvaluationRecord() {
        this.evaluatedAt = LocalDateTime.now();
    }
    
    public AssignmentEvaluationRecord(Long assignmentId, Integer rating, String comments) {
        this.assignmentId = assignmentId;
        this.rating = rating;
        this.comments = comments;
        this.evaluatedAt = LocalDateTime.now();
    }
    
    @PrePersist
    protected void onCreate() {
        evaluatedAt = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getAssignmentId() { return assignmentId; }
    public void setAssignmentId(Long assignmentId) { this.assignmentId = assignmentId; }
    
    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }
    
    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }
    
    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }
    
    public LocalDateTime getEvaluatedAt() { return evaluatedAt; }
    public void setEvaluatedAt(LocalDateTime evaluatedAt) { this.evaluatedAt = evaluatedAt; }
}