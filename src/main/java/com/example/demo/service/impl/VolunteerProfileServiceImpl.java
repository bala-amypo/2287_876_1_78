package com.example.demo.service.impl;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerProfileServiceImpl implements VolunteerProfileService {

    private final VolunteerProfileRepository repository;

    public VolunteerProfileServiceImpl(VolunteerProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public VolunteerProfile createVolunteer(VolunteerProfile volunteer) {
        return repository.save(volunteer);
    }

    @Override
    public VolunteerProfile getVolunteerById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<VolunteerProfile> getAllVolunteers() {
        return repository.findAll();
    }

    @Override
    public VolunteerProfile updateVolunteer(Long id, VolunteerProfile volunteer) {
        volunteer.setId(id);
        return repository.save(volunteer);
    }

    @Override
    public void deleteVolunteer(Long id) {
        repository.deleteById(id);
    }
}
