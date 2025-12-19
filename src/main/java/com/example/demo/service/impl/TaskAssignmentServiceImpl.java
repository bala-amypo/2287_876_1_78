@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    private final TaskAssignmentRecordRepository assignmentRepo;
    private final TaskRecordRepository taskRepo;
    private final VolunteerProfileRepository volunteerRepo;
    private final VolunteerSkillRecordRepository skillRepo;

    public TaskAssignmentServiceImpl(
            TaskAssignmentRecordRepository a,
            TaskRecordRepository t,
            VolunteerProfileRepository v,
            VolunteerSkillRecordRepository s) {
        this.assignmentRepo = a;
        this.taskRepo = t;
        this.volunteerRepo = v;
        this.skillRepo = s;
    }

    public TaskAssignmentRecord assignTask(Long taskId) {

        if (assignmentRepo.existsByTaskIdAndStatus(taskId, "ACTIVE"))
            throw new BadRequestException("ACTIVE assignment already exists");

        TaskRecord task = taskRepo.findById(taskId)
            .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        for (var v : volunteerRepo.findByAvailabilityStatus("AVAILABLE")) {
            for (var s : skillRepo.findByVolunteerId(v.getId())) {
                if (SkillLevelUtil.isSkillSufficient(
                        s.getSkillLevel(), task.getRequiredSkillLevel()) &&
                    s.getSkillName().equals(task.getRequiredSkill())) {

                    TaskAssignmentRecord a =
                        new TaskAssignmentRecord(taskId, v.getId(), "ACTIVE");

                    task.setStatus("ACTIVE");
                    taskRepo.save(task);
                    return assignmentRepo.save(a);
                }
            }
        }
        throw new BadRequestException("Insufficient skill level");
    }

    public List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId) {
        return assignmentRepo.findByTaskId(taskId);
    }

    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId) {
        return assignmentRepo.findByVolunteerId(volunteerId);
    }
}
