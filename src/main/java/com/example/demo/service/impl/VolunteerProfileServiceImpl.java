package com.example.demo.service.impl;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VolunteerProfileServiceImpl implements VolunteerProfileService {

    @Autowired
    private VolunteerProfileRepository repository;

    @Override
    public VolunteerProfile updateVolunteer(Long id, VolunteerProfile profile) {
        VolunteerProfile existing = repository.findById(id).orElseThrow();
        existing.setName(profile.getName());
        existing.setEmail(profile.getEmail());
        existing.setPhone(profile.getPhone());
        return repository.save(existing);
    }

    @Override
    public VolunteerProfile getByVolunteerCode(String code) {
        return repository.findByVolunteerCode(code);
    }
}
