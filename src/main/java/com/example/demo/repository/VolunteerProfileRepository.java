

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.*;
import java.util.List;


public interface VolunteerProfileRepository
        extends JpaRepository<VolunteerProfile, Long> {

    boolean existsByEmail(String email);
    List<VolunteerProfile> findByAvailabilityStatus(String status);
}
