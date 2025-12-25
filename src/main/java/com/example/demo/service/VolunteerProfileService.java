package com.example.demo.service;

import com.example.demo.model.VolunteerProfile;

import java.util.List;
import java.util.Optional;

public interface VolunteerProfileService {

    VolunteerProfile createVolunteer(VolunteerProfile volunteer);

    VolunteerProfile updateVolunteer(Long id, VolunteerProfile volunteer);

    List<VolunteerProfile> getAllVolunteers();

    List<VolunteerProfile> getAvailableVolunteers();

    Optional<VolunteerProfile> getByVolunteerCode(String volunteerCode);
}
