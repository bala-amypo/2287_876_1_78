package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.VolunteerSkillRecord;

public interface VolunteerSkillRepository extends JpaRepository<VolunteerSkillRecord, Long> {
}
