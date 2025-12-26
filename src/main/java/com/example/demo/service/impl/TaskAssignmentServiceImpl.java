package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.TaskAssignmentService;
import com.example.demo.util.SkillLevelUtil;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    private final TaskAssignmentRecordRepository ar;
    private final TaskRecordRepository tr;
    private final VolunteerProfileRepository vr;
    private final VolunteerSkillRecordRepository sr;

    public TaskAssignmentServiceImpl(
            TaskAssignmentRecordRepository ar,
            TaskRecordRepository tr,
            VolunteerProfileRepository vr,
            VolunteerSkillRecordRepository sr) {
        this.ar = ar; this.tr = tr; this.vr = vr; this.sr = sr;
    }

    public TaskAssignmentRecord assignTask(Long taskId) {
        TaskRecord task = tr.findById(taskId).orElseThrow();

        if (ar.existsByTaskIdAndStatus(taskId, "ACTIVE"))
            throw new BadRequestException("ACTIVE assignment");

        for (VolunteerProfile v : vr.findByAvailabilityStatus("AVAILABLE")) {
            for (VolunteerSkillRecord s : sr.findByVolunteerId(v.getId())) {
                if (s.getSkillName().equals(task.getRequiredSkill()) &&
                        SkillLevelUtil.levelRank(s.getSkillLevel()) >=
                        SkillLevelUtil.levelRank(task.getRequiredSkillLevel())) {

                    TaskAssignmentRecord r = new TaskAssignmentRecord();
                    r.setTaskId(taskId);
                    r.setVolunteerId(v.getId());
                    return ar.save(r);
                }
            }
        }
        throw new BadRequestException("required skill level");
    }

    public List<TaskAssignmentRecord> getAssignmentsByTask(Long id) {
        return ar.findByTaskId(id);
    }

    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long id) {
        return ar.findByVolunteerId(id);
    }

    public List<TaskAssignmentRecord> getAllAssignments() {
        return ar.findAll();
    }
}
