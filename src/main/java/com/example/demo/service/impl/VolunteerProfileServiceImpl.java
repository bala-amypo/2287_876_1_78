package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
 @Service
public class VolunteerProfileServiceImpl implements VolunteerProfileService {

    @Override
    public VolunteerProfile registerVolunteer(RegisterRequest request) {
        VolunteerProfile profile = new VolunteerProfile();
        profile.setName(request.getName());
        profile.setAvailability(request.getAvailability());
        return profile;
    }

    @Override
    public VolunteerProfile updateAvailability(Long id, String availability) {
        VolunteerProfile profile = new VolunteerProfile();
        profile.setId(id);
        profile.setAvailability(availability);
        return profile;
    }
}
