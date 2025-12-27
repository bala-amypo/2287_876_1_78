package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VolunteerProfileServiceImpl implements VolunteerProfileService {
    
    private final VolunteerProfileRepository volunteerProfileRepository;
    
    public VolunteerProfileServiceImpl(VolunteerProfileRepository volunteerProfileRepository) {
        this.volunteerProfileRepository = volunteerProfileRepository;
    }
    
    @Override
    public VolunteerProfile createVolunteer(VolunteerProfile profile) {
        if (profile.getEmail() != null && volunteerProfileRepository.existsByEmail(profile.getEmail())) {
            throw new BadRequestException("Email already exists");
        }
        
        if (profile.getVolunteerId() != null && volunteerProfileRepository.existsByVolunteerId(profile.getVolunteerId())) {
            throw new BadRequestException("Volunteer ID already exists");
        }
        
        if (profile.getPhone() != null && volunteerProfileRepository.existsByPhone(profile.getPhone())) {
            throw new BadRequestException("Phone number already exists");
        }
        
        return volunteerProfileRepository.save(profile);
    }
    
    @Override
    public VolunteerProfile getVolunteerById(Long id) {
        return volunteerProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Volunteer not found"));
    }
    
    @Override
    public List<VolunteerProfile> getAllVolunteers() {
        return volunteerProfileRepository.findAll();
    }
    
    @Override
    public List<VolunteerProfile> getAvailableVolunteers() {
        return volunteerProfileRepository.findByAvailabilityStatus("AVAILABLE");
    }
    
    @Override
    public Optional<VolunteerProfile> findByVolunteerId(String volunteerId) {
        return volunteerProfileRepository.findByVolunteerId(volunteerId);
    }
    
    @Override
    public VolunteerProfile updateAvailability(Long volunteerId, String availabilityStatus) {
        VolunteerProfile volunteer = getVolunteerById(volunteerId);
        volunteer.setAvailabilityStatus(availabilityStatus);
        return volunteerProfileRepository.save(volunteer);
    }
}