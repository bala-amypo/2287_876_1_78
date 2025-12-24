@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRecordService taskRecordService;

    public TaskController(TaskRecordService taskRecordService) {
        this.taskRecordService = taskRecordService;
    }

    @PostMapping("/{taskId}/assign")
    public ResponseEntity<TaskAssignmentRecord> assignTask(@PathVariable Long taskId) {
        TaskAssignmentRecord record = taskRecordService.assignTask(taskId);
        return ResponseEntity.ok(record);
    }
}
