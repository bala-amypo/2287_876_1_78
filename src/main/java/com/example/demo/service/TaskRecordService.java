import java.util.List;

public interface TaskRecordService {

    TaskRecord createTask(TaskRecord record);

    TaskRecord updateTask(Long id, TaskRecord record);

    List<TaskRecord> getAllTasks();

    List<TaskRecord> getOpenTasks();
}
