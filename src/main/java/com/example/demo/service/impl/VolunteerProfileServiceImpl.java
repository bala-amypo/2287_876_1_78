package com.example.demo.service.impl;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerProfileServiceImpl implements VolunteerProfileService {

    private final VolunteerProfileRepository repository;

    public VolunteerProfileServiceImpl(VolunteerProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public VolunteerProfile updateVolunteer(Long id, VolunteerProfile profile) {
        profile.setId(id);
        return repository.save(profile);
    }

    @Override
    public List<VolunteerProfile> getAvailableVolunteers() {
        return repository.findByAvailabilityStatus("AVAILABLE");
    }

    @Override
    public VolunteerProfile getByVolunteerCode(String volunteerCode) {
        return repository.findByVolunteerCode(volunteerCode);
    }
}
