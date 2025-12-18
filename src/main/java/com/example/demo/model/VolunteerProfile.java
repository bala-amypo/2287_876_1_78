package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "volunteer_profile")
public class VolunteerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(length = 100)
    private String phone;

    @Column(length = 255)
    private String address;

    @Column(length = 200)
    private String skills;

    @Column(length = 100)
    private String availability;

    @Column(length = 500)
    private String bio;

    // ✅ Required by JPA
    public VolunteerProfile() {
    }

    // ---------------- GETTERS & SETTERS ----------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;   // ✅ return present
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;   // ✅ return present
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address; // ✅ return present
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSkills() {
        return skills;  // ✅ return present
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getAvailability() {
        return availability; // ✅ return present
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getBio() {
        return bio; // ✅ return present
    }

    public void setBio(String bio) {
        this.bio = bio;
