package com.example.demo.repository;

import com.example.demo.model.VolunteerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface VolunteerProfileRepository extends JpaRepository<VolunteerProfile, Long> {
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
    boolean existsByVolunteerId(String volunteerId);
    Optional<VolunteerProfile> findById(Long id);
}
