

package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface VolunteerSkillRecordRepository
        extends JpaRepository<VolunteerSkillRecord, Long> {

    List<VolunteerSkillRecord> findByVolunteerId(Long id);
    List<VolunteerSkillRecord> findBySkillName(String name);
    List<VolunteerSkillRecord> findBySkillNameAndSkillLevel(String n, String l);
}
