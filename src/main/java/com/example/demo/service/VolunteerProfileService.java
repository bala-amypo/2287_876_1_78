package com.example.demo.service;

import com.example.demo.model.VolunteerProfile;

import java.util.List;
import java.util.Optional;

public interface VolunteerProfileService {
     void registerVolunteer(RegisterRequest request);

    void updateAvailability(Long volunteerId, String availability);
    VolunteerProfile createVolunteer(VolunteerProfile profile);
    VolunteerProfile getVolunteerById(Long id);
    List<VolunteerProfile> getAllVolunteers();
    Optional<VolunteerProfile> findByVolunteerId(String volunteerId);
}
