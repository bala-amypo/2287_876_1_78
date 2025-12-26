package com.example.demo.service;

import com.example.demo.model.VolunteerProfile;

import java.util.List;
import java.util.Optional;

public interface VolunteerProfileService {

    VolunteerProfile createVolunteer(VolunteerProfile profile);

    VolunteerProfile getVolunteerById(Long id);

    List<VolunteerProfile> getAllVolunteers();

    Optional<VolunteerProfile> getByVolunteerCode(String volunteerCode);

    // 🔥 ADD THESE (Controller expects)
    VolunteerProfile updateVolunteer(Long id, VolunteerProfile profile);

    List<VolunteerProfile> getAvailableVolunteers();
}
