import java.util.List;
import java.util.Optional;

public interface VolunteerProfileService {

    VolunteerProfile createVolunteer(VolunteerProfile profile);

    VolunteerProfile updateVolunteer(Long id, VolunteerProfile profile);

    Optional<VolunteerProfile> findByVolunteerId(String volunteerId);

    VolunteerProfile getVolunteerById(long id);

    List<VolunteerProfile> getAllVolunteers();

    List<VolunteerProfile> getAvailableVolunteers();
}
