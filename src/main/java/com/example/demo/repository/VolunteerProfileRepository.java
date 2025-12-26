package com.example.demo.repository;

import com.example.demo.model.VolunteerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VolunteerProfileRepository extends JpaRepository<VolunteerProfile, Long> {

    boolean existsByVolunteerId(String volunteerId);

    boolean existsByPhone(String phone);

    boolean existsByEmail(String email);

    List<VolunteerProfile> findByAvailabilityStatus(String status);

    // For service method getByVolunteerCode or findByVolunteerId
    Optional<VolunteerProfile> findByVolunteerCode(String code);

    // Optional: keep this if your service uses findByVolunteerId
    Optional<VolunteerProfile> findByVolunteerId(String volunteerId);
}
