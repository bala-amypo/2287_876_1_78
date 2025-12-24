package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class AssignmentEvaluationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer score;
    private String remarks;

    @Entity
public class AssignmentEvaluationRecord {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Assignment assignment;   // 👈 idhu dhaan irukku
}


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
    // ✅ MUST EXIST
    public AssignmentEvaluationRecord(Long id, Integer score, String remarks) {
        this.id = id;
        this.score = score;
        this.remarks = remarks;
    }
}
