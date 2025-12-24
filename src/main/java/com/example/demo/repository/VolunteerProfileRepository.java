package com.example.demo.repository;

import com.example.demo.model.VolunteerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VolunteerProfileRepository extends JpaRepository<VolunteerProfile, Long> {

    Optional<VolunteerProfile> findByVolunteerId(String volunteerId);

    Optional<VolunteerProfile> findByEmail(String email);

    Optional<VolunteerProfile> findByPhone(String phone);
}
public interface VolunteerProfileRepository extends JpaRepository<VolunteerProfile, Long> {
    boolean existsByVolunteerId(String volunteerId);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
    java.util.Optional<VolunteerProfile> findByVolunteerId(String volunteerId);
    List<VolunteerProfile> findByAvailabilityStatus(String status);
}