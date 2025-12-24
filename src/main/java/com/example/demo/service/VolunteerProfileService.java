package com.example.demo.service;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.VolunteerProfile;
@Service



public interface VolunteerProfileService {

    VolunteerProfile registerVolunteer(RegisterRequest request);

    VolunteerProfile updateAvailability(Long id, String availability);
}
