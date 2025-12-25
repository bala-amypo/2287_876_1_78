package com.example.demo.model;

import java.util.Objects;
@Entity
public class VolunteerProfile {
    @Id
    private Long id; // for DB auto-generated ID
    private String volunteerId; // String, as tests expect
    private String fullName;
    private String email;
    private String phone;
    private String availabilityStatus;

    public VolunteerProfile() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getVolunteerId() { return volunteerId; }
    public void setVolunteerId(String volunteerId) { this.volunteerId = volunteerId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAvailabilityStatus() { return availabilityStatus; }
    public void setAvailabilityStatus(String availabilityStatus) { this.availabilityStatus = availabilityStatus; }
}
