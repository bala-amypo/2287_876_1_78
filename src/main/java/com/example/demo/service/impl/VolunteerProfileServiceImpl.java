package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.service.VolunteerProfileService;
import java.util.*;

public class VolunteerProfileServiceImpl implements VolunteerProfileService {

    private final VolunteerProfileRepository repo;

    public VolunteerProfileServiceImpl(VolunteerProfileRepository r) {
        this.repo = r;
    }

    public VolunteerProfile createVolunteer(VolunteerProfile p) {
        if (repo.existsByVolunteerId(p.getVolunteerId()))
            throw new BadRequestException("VolunteerId exists");
        if (repo.existsByEmail(p.getEmail()))
            throw new BadRequestException("Email already exists");
        if (repo.existsByPhone(p.getPhone()))
            throw new BadRequestException("Phone exists");
        return repo.save(p);
    }

    public VolunteerProfile getVolunteerById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<VolunteerProfile> getAllVolunteers() {
        return repo.findAll();
    }

    public Optional<VolunteerProfile> findByVolunteerId(String id) {
        return repo.findByVolunteerId(id);
    }
}
