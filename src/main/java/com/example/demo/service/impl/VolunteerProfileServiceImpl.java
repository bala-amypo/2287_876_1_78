package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VolunteerProfileServiceImpl implements VolunteerProfileService {

    private final VolunteerProfileRepository volunteerProfileRepository;

    public VolunteerProfileServiceImpl(VolunteerProfileRepository volunteerProfileRepository) {
        this.volunteerProfileRepository = volunteerProfileRepository;
    }

    @Override
    @Transactional
    public VolunteerProfile createVolunteerProfile(VolunteerProfile volunteer) {
        if (volunteerProfileRepository.existsByEmail(volunteer.getEmail())) {
            throw new BadRequestException("Email already exists");
        }
        return volunteerProfileRepository.save(volunteer);
    }

    @Override
    public List<VolunteerProfile> getAllVolunteers() {
        return volunteerProfileRepository.findAll();
    }

    @Override
    public VolunteerProfile getVolunteerById(Long id) {
        return volunteerProfileRepository.findById(id).orElse(null);
    }

    @Override
    public VolunteerProfile getByVolunteerCode(String volunteerCode) {
        return volunteerProfileRepository.findByVolunteerId(volunteerCode).orElse(null);
    }

    @Override
    public List<VolunteerProfile> findByVolunteerId(String volunteerId) {
        Optional<VolunteerProfile> volunteer = volunteerProfileRepository.findByVolunteerId(volunteerId);
        return volunteer.map(List::of).orElse(List.of());
    }
}
