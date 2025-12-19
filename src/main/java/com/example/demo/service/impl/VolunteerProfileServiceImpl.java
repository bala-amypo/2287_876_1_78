package com.example.demo.service.impl;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerProfileServiceImpl implements VolunteerProfileService {

    private final VolunteerProfileRepository volunteerProfileRepository;

    public VolunteerProfileServiceImpl(VolunteerProfileRepository volunteerProfileRepository) {
        this.volunteerProfileRepository = volunteerProfileRepository;
    }

    @Override
    public VolunteerProfile registerVolunteer(RegisterRequest request) {
        if (request.getEmail() == null || request.getEmail().isBlank()) {
            throw new BadRequestException("Email is required");
        }
        if (volunteerProfileRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new BadRequestException("Email already registered");
        }
        String availability = request.getAvailability() == null ? "AVAILABLE" : request.getAvailability().toUpperCase();
        if (!availability.equals("AVAILABLE") && !availability.equals("UNAVAILABLE")) {
            throw new BadRequestException("Invalid availability status");
        }
        VolunteerProfile vp = new VolunteerProfile(request.getName(), request.getEmail(), availability);
        return volunteerProfileRepository.save(vp);
    }

    @Override
    public VolunteerProfile updateAvailability(Long volunteerId, String availabilityStatus) {
        VolunteerProfile vp = volunteerProfileRepository.findById(volunteerId)
                .orElseThrow(() -> new ResourceNotFoundException("Volunteer not found"));
        String status = availabilityStatus == null ? null : availabilityStatus.toUpperCase();
        if (!"AVAILABLE".equals(status) && !"UNAVAILABLE".equals(status)) {
            throw new BadRequestException("Availability must be AVAILABLE or UNAVAILABLE");
        }
        vp.setAvailabilityStatus(status);
        return volunteerProfileRepository.save(vp);
    }

    @Override
    public List<VolunteerProfile> getAvailableVolunteers() {
        return volunteerProfileRepository.findByAvailabilityStatus("AVAILABLE");
    }
}
