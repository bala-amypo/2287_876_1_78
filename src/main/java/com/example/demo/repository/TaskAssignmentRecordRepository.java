
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.*;
import java.util.List;




public interface TaskAssignmentRecordRepository
        extends JpaRepository<TaskAssignmentRecord, Long> {

    boolean existsByTaskIdAndStatus(Long taskId, String status);
    List<TaskAssignmentRecord> findByTaskId(Long taskId);
    List<TaskAssignmentRecord> findByVolunteerId(Long volunteerId);
}
