


public interface VolunteerProfileService {
    VolunteerProfile registerVolunteer(RegisterRequest request);
    VolunteerProfile updateAvailability(Long id, String status);
    List<VolunteerProfile> getAvailableVolunteers();
}
