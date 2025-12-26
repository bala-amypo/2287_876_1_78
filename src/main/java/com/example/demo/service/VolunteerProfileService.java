package com.example.demo.service;

import com.example.demo.model.VolunteerProfile;

public interface VolunteerProfileService {

    VolunteerProfile save(VolunteerProfile profile);

    VolunteerProfile findByVolunteerId(String volunteerId);

    VolunteerProfile updateVolunteer(Long id, VolunteerProfile profile);
}
