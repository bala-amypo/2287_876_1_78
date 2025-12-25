package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VolunteerProfileServiceImpl
        implements VolunteerProfileService {

    private final VolunteerProfileRepository repository;

    public VolunteerProfileServiceImpl(
            VolunteerProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public VolunteerProfile createVolunteer(
            VolunteerProfile volunteer) {

        if (volunteer.getAvailabilityStatus() == null) {
            volunteer.setAvailabilityStatus("AVAILABLE");
        }
        return repository.save(volunteer);
    }

    @Override
    public VolunteerProfile updateVolunteer(
            Long id, VolunteerProfile updated) {

        VolunteerProfile existing = repository.findById(id)
                .orElseThrow(() ->
                        new BadRequestException("Volunteer not found"));

        existing.setVolunteerName(updated.getVolunteerName());
        existing.setAvailabilityStatus(
                updated.getAvailabilityStatus());

        return repository.save(existing);
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
    public Optional<VolunteerProfile> getByVolunteerCode(
            String volunteerCode) {
        return repository.findByVolunteerCode(volunteerCode);
    }
}
