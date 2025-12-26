package com.example.demo.service;

import com.example.demo.model.VolunteerProfile;

import java.util.List;

public interface VolunteerProfileService {

    VolunteerProfile updateVolunteer(Long id, VolunteerProfile profile);

    List<VolunteerProfile> getAvailableVolunteers();

    VolunteerProfile getByVolunteerCode(String volunteerCode);
}
