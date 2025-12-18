package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "volunteer_skill")
public class VolunteerSkillRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long volunteerId;

    @Column(nullable = false, length = 100)
    private String skillName;

    @Column(length = 50)
    private String skillLevel;   // BEGINNER, INTERMEDIATE, EXPERT

    // ✅ No-arg constructor (required by JPA)
    public VolunteerSkillRecord() {
    }

    // ---------------- GETTERS & SETTERS ----------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(Long volunteerId) {
        this.volunteerId = volunteerId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.setSkillLevel = setSkillLevel;
        }
}
