package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class VolunteerSkillRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skillName;
    private int skillLevel;
    private boolean certified;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSkillName() { return skillName; }
    public void setSkillName(String skillName) { this.skillName = skillName; }

    public int getSkillLevel() { return skillLevel; }
    public void setSkillLevel(int skillLevel) { this.skillLevel = skillLevel; }

    public boolean isCertified() { return certified; }
    public void setCertified(boolean certified) { this.certified = certified; }
}
