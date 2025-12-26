package com.example.demo.service.impl;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VolunteerProfileServiceImpl implements VolunteerProfileService {

    private final VolunteerProfileRepository repository;

    public VolunteerProfileServiceImpl(VolunteerProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public VolunteerProfile createVolunteer(VolunteerProfile profile) {
        return repository.save(profile);
    }

    @Override
    public VolunteerProfile updateVolunteer(Long id, VolunteerProfile profile) {
        profile.setId(id);
        return repository.save(profile);
    }

    @Override
    public VolunteerProfile getVolunteerById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<VolunteerProfile> getAllVolunteers() {
        return repository.findAll();
    }

    @Override
    public List<VolunteerProfile> getAvailableVolunteers() {
        return repository.findByAvailabilityStatus("AVAILABLE");
    }

    @Override
    public VolunteerProfile getByVolunteerCode(String volunteerId) {
        return repository.findByVolunteerId(volunteerId).orElse(null);
    }

    @Override
    public Optional<VolunteerProfile> findByVolunteerId(String volunteerId) {
        return repository.findByVolunteerId(volunteerId);
    }
}
