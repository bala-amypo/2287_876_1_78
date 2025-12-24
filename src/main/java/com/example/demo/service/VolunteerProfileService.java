package com.example.demo.service;

import com.example.demo.model.VolunteerProfile;
import java.util.List;

public interface VolunteerProfileService {

    VolunteerProfile createVolunteer(VolunteerProfile volunteer);

    VolunteerProfile getVolunteerById(Long id);

    List<VolunteerProfile> getAllVolunteers();

    VolunteerProfile updateVolunteer(Long id, VolunteerProfile volunteer);

    void deleteVolunteer(Long id);
}
