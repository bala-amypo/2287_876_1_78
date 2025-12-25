package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class VolunteerSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skillName;
    private int skillLevel;

    @ManyToOne
    @JoinColumn(name = "volunteer_id")
    private VolunteerProfile volunteerProfile;

    public VolunteerSkill() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }
    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public int getSkillLevel() {
        return skillLevel;
    }
    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public VolunteerProfile getVolunteerProfile() {
        return volunteerProfile;
    }
    public void setVolunteerProfile(VolunteerProfile volunteerProfile) {
        this.volunteerProfile = volunteerProfile;
    }
}
