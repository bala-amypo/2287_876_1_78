package com.example.demo.service.impl;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.stereotype.Service;

@Service
public class VolunteerProfileServiceImpl implements VolunteerProfileService {

    private final VolunteerProfileRepository repo;

    public VolunteerProfileServiceImpl(VolunteerProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public VolunteerProfile registerVolunteer(RegisterRequest request) {
        VolunteerProfile profile = new VolunteerProfile();
        profile.setName(request.getName());
        profile.setEmail(request.getEmail());
        profile.setAvailability(request.getAvailability());
        return repo.save(profile);
    }

    @Override
    public VolunteerProfile updateAvailability(Long id, String availability) {
        VolunteerProfile profile = repo.findById(id).orElseThrow();
        profile.setAvailability(availability);
        return repo.save(profile);
    }
}
