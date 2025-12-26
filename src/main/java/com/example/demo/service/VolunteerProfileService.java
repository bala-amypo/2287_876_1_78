package com.example.demo.service;

import com.example.demo.model.VolunteerProfile;

public interface VolunteerProfileService {
    VolunteerProfile updateVolunteer(Long id, VolunteerProfile profile);
    VolunteerProfile getByVolunteerCode(String code);
}
