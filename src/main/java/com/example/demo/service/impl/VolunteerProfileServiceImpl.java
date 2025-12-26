package com.example.demo.service.impl;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.stereotype.Service;

@Service
public class VolunteerProfileServiceImpl
        implements VolunteerProfileService {

    private final VolunteerProfileRepository repo;

    public VolunteerProfileServiceImpl(VolunteerProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public VolunteerProfile save(VolunteerProfile profile) {
        return repo.save(profile);
    }

    @Override
    public VolunteerProfile findByVolunteerId(String volunteerId) {
        return repo.findByVolunteerId(volunteerId);
    }

    @Override
    public VolunteerProfile updateVolunteer(Long id,
                                            VolunteerProfile profile) {
        profile.setId(id);
        return repo.save(profile);
    }
}
