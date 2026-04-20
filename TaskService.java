package projectone;
import java.util.ArrayList;

public class TaskService {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task is null");
        }

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getTaskId().equals(task.getTaskId())) {
                throw new IllegalArgumentException("ID already exists");
            }
        }

        tasks.add(task);
    }

    public void deleteTask(String taskId) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getTaskId().equals(taskId)) {
                tasks.remove(i);
                return;
            }
        }

        throw new IllegalArgumentException("Cannot delete task");
    }

    public void updateName(String taskId, String name) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getTaskId().equals(taskId)) {
                tasks.get(i).setName(name);
                return;
            }
        }

        throw new IllegalArgumentException("Cannot update task");
    }

    public void updateDescription(String taskId, String description) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getTaskId().equals(taskId)) {
                tasks.get(i).setDescription(description);
                return;
            }
        }

        throw new IllegalArgumentException("Cannot update description");
    }
}
