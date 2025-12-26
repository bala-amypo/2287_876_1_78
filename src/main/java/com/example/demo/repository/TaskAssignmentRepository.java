package com.example.demo.repository;

import com.example.demo.model.TaskAssignmentRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskAssignmentRepository extends JpaRepository<TaskAssignmentRecord, Long> {

    // Get all task assignments for a specific volunteer
    List<TaskAssignmentRecord> findByVolunteerId(Long volunteerId);

    // Get all task assignments for a specific task
    List<TaskAssignmentRecord> findByTaskId(Long taskId);
}
