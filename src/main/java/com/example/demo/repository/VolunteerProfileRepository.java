package com.example.demo.repository;

import com.example.demo.model.VolunteerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VolunteerProfileRepository extends JpaRepository<VolunteerProfile, Long> {

    // Test may expect this method
    List<VolunteerProfile> findBySkill(String skill);
}
