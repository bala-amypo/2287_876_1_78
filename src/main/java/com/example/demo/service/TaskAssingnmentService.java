package com.example.demo.service;

import java.util.List;
import com.example.demo.model.*;
import com.example.demo.dto.*;

public interface TaskAssignmentService {
    TaskAssignmentRecord assignTask(Long taskId);
    List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId);
    List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId);
}
