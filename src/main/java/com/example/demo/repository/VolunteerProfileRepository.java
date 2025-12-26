import java.util.Optional;

public interface VolunteerProfileRepository
        extends JpaRepository<VolunteerProfile, Long> {

    Optional<VolunteerProfile> findByVolunteerId(String volunteerId);

    boolean existsByVolunteerId(String volunteerId);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);

    List<VolunteerProfile> findByAvailabilityStatus(String status);
}
