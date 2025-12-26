package com.example.demo.repository;

import com.example.demo.model.VolunteerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolunteerProfileRepository extends JpaRepository<VolunteerProfile, Long> {
    VolunteerProfile findByVolunteerCode(String code);
}
