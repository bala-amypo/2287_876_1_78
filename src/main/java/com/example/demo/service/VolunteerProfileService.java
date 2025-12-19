

package com.example.demo.service;

import java.util.List;
import com.example.demo.model.*;
import com.example.demo.dto.*;

public interface VolunteerProfileService {
  
    VolunteerProfile updateAvailability(Long id, String status);
    List<VolunteerProfile> getAvailableVolunteers();
}
