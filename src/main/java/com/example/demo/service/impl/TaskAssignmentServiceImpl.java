package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.TaskAssignmentService;
import com.example.demo.util.SkillLevelUtil;
import java.util.*;

public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    private final TaskAssignmentRecordRepository assignRepo;
    private final TaskRecordRepository taskRepo;
    private final VolunteerProfileRepository volRepo;
    private final VolunteerSkillRecordRepository skillRepo;

    public TaskAssignmentServiceImpl(
            TaskAssignmentRecordRepository a,
            TaskRecordRepository t,
            VolunteerProfileRepository v,
            VolunteerSkillRecordRepository s) {

        assignRepo = a; taskRepo = t; volRepo = v; skillRepo = s;
    }

    public TaskAssignmentRecord assignTask(Long taskId) {

        if (assignRepo.existsByTaskIdAndStatus(taskId, "ACTIVE"))
            throw new BadRequestException("ACTIVE assignment exists");

        TaskRecord task = taskRepo.findById(taskId).orElseThrow();

        List<VolunteerProfile> vols =
                volRepo.findByAvailabilityStatus("AVAILABLE");

        for (VolunteerProfile v : vols) {
            for (VolunteerSkillRecord s :
                    skillRepo.findByVolunteerId(v.getId())) {

                if (s.getSkillName().equals(task.getRequiredSkill()) &&
                    SkillLevelUtil.levelRank(s.getSkillLevel()) >=
                    SkillLevelUtil.levelRank(task.getRequiredSkillLevel())) {

                    TaskAssignmentRecord rec = new TaskAssignmentRecord();
                    rec.setTaskId(taskId);
                    rec.setVolunteerId(v.getId());

                    task.setStatus("ACTIVE");
                    taskRepo.save(task);
                    return assignRepo.save(rec);
                }
            }
        }
        throw new BadRequestException("required skill level");
    }

    public List<TaskAssignmentRecord> getAssignmentsByTask(Long id) {
        return assignRepo.findByTaskId(id);
    }

    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long id) {
        return assignRepo.findByVolunteerId(id);
    }

    public List<TaskAssignmentRecord> getAllAssignments() {
        return assignRepo.findAll();
    }
}
