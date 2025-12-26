package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
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
public VolunteerProfile updateVolunteer(Long id, VolunteerProfile profile) {

    VolunteerProfile existing = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Volunteer not found"));

    existing.setFullName(profile.getFullName());
    existing.setEmail(profile.getEmail());
    existing.setPhone(profile.getPhone());
    existing.setAvailabilityStatus(profile.getAvailabilityStatus());

    return repository.save(existing);
}

@Override
public List<VolunteerProfile> getAvailableVolunteers() {
    return repository.findByAvailabilityStatus("AVAILABLE");
}


   }