package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class VolunteerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String volunteerCode;
    private String volunteerName;
    private String availabilityStatus = "AVAILABLE"; // default

    public VolunteerProfile() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getVolunteerCode() {
        return volunteerCode;
    }
    public void setVolunteerCode(String volunteerCode) {
        this.volunteerCode = volunteerCode;
    }

    public String getVolunteerName() {
        return volunteerName;
    }
    public void setVolunteerName(String volunteerName) {
        this.volunteerName = volunteerName;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }
    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
}
