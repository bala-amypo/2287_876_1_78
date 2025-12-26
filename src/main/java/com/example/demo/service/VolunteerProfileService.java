package com.example.demo.service;

import com.example.demo.model.VolunteerProfile;

import java.util.List;
import java.util.Optional;

public interface VolunteerProfileService {

    VolunteerProfile createVolunteerProfile(VolunteerProfile volunteer);

    List<VolunteerProfile> getAllVolunteers();

    Optional<VolunteerProfile> findByVolunteerId(String volunteerId);

    List<VolunteerProfile> getAvailableVolunteers();
}
