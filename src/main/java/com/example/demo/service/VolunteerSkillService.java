
package com.example.demo.service;

import java.util.List;
import com.example.demo.model.*;
import com.example.demo.dto.*;

public interface VolunteerSkillService {
    List<VolunteerSkillRecord> getSkillsByVolunteer(Long volunteerId);
}
