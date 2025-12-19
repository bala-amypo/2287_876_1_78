package com.example.demo.service.impl;

import com.example.demo.service.VolunteerProfileService;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.VolunteerProfile;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VolunteerProfileServiceImpl implements VolunteerProfileService {

    private final VolunteerProfileRepository repo;

    public VolunteerProfileServiceImpl(VolunteerProfileRepository repo) {
        this.repo = repo;
    }

    public VolunteerProfile registerVolunteer(RegisterRequest req) {
        if (repo.existsByEmail(req.getEmail()))
            throw new BadRequestException("Email already exists");

        VolunteerProfile v =
            new VolunteerProfile(req.getName(), req.getEmail(), "AVAILABLE");

        return repo.save(v);
    }

    public VolunteerProfile updateAvailability(Long id, String status) {
        if (!status.equals("AVAILABLE") && !status.equals("UNAVAILABLE"))
            throw new BadRequestException("Invalid availability");

        VolunteerProfile v = repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Volunteer not found"));

        v.setAvailabilityStatus(status);
        return repo.save(v);
    }

    public List<VolunteerProfile> getAvailableVolunteers() {
        return repo.findByAvailabilityStatus("AVAILABLE");
    }
}
