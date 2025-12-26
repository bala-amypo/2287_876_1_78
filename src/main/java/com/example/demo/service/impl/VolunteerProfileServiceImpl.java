package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
public Optional<VolunteerProfile> findByVolunteerId(String volunteerId) {
    return volunteerProfileRepository.findByVolunteerId(volunteerId);
}

}
