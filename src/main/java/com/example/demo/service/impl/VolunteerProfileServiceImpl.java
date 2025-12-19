package com.example.demo.service.impl;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.stereotype.Service;

@Service
public class VolunteerProfileServiceImpl implements VolunteerProfileService {

    private final VolunteerProfileRepository repository;

    public VolunteerProfileServiceImpl(VolunteerProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public VolunteerProfile save(VolunteerProfile profile) {
        return repository.save(profile);
    }

    @Override
    public VolunteerProfile updateAvailability(Long id, boolean available) {
        VolunteerProfile profile = repository.findById(id).orElse(null);
        profile.setAvailable(available);
        return repository.save(profile);
    }
}
