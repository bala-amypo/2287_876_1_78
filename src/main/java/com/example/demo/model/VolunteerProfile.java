package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class VolunteerProfile {

    @Id
    private Long id;
    private String email;

    private String volunteerCode;
    private String fullName;
    private String phone;
    private String availabilityStatus;
    public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}


    public VolunteerProfile() {
    }

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
}
