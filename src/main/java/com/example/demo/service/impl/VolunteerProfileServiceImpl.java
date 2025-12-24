package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VolunteerProfileServiceImpl {

    private VolunteerProfileRepository volunteerProfileRepository;

    public VolunteerProfileServiceImpl(VolunteerProfileRepository volunteerProfileRepository) {
        this.volunteerProfileRepository = volunteerProfileRepository;
    }

    public VolunteerProfile createVolunteer(VolunteerProfile profile) {
        if (volunteerProfileRepository.existsByVolunteerId(profile.getVolunteerId())) {
            throw new BadRequestException("Volunteer ID already exists");
        }
        if (volunteerProfileRepository.existsByEmail(profile.getEmail())) {
            throw new BadRequestException("Email already exists");
        }
        if (volunteerProfileRepository.existsByPhone(profile.getPhone())) {
            throw new BadRequestException("Phone already exists");
        }
        return volunteerProfileRepository.save(profile);
    }

    public VolunteerProfile getVolunteerById(Long id) {
        return volunteerProfileRepository.findById(id).orElseThrow(() -> new BadRequestException("Volunteer not found"));
    }

    public List<VolunteerProfile> getAllVolunteers() {
        return volunteerProfileRepository.findAll();
    }

    public Optional<VolunteerProfile> findByVolunteerId(String volunteerId) {
        return volunteerProfileRepository.findByVolunteerId(volunteerId);
    }
}
