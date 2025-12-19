



public interface VolunteerProfileRepository
        extends JpaRepository<VolunteerProfile, Long> {

    boolean existsByEmail(String email);
    List<VolunteerProfile> findByAvailabilityStatus(String status);
}
