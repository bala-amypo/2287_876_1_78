package com.example.demo.repository;

import com.example.demo.model.TaskRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRecordRepository extends JpaRepository<TaskRecord, Long> {

    List<TaskRecord> findByStatus(String status);

    List<TaskRecord> findByRequiredSkillAndRequiredSkillLevel(
            String requiredSkill,
            String requiredSkillLevel
    );
}
