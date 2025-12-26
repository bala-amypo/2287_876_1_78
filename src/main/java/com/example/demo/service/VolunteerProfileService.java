package com.example.demo.service;

import com.example.demo.model.VolunteerProfile;

import java.util.List;

public interface VolunteerProfileService {

    VolunteerProfile createVolunteer(VolunteerProfile profile);

    VolunteerProfile updateVolunteer(Long id, VolunteerProfile profile);

    VolunteerProfile getVolunteerById(long id);

    List<VolunteerProfile> getAllVolunteers();

    List<VolunteerProfile> getAvailableVolunteers();

    VolunteerProfile getByVolunteerCode(String volunteerId);

    VolunteerProfile findByVolunteerId(String volunteerId);
}
