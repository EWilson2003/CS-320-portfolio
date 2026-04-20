package projectone;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TaskServiceTest {

    @Test
    public void testAddTask() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Homework", "Finish Milestone");
        service.addTask(task);

        assertDoesNotThrow(() -> service.updateName("1", "Reading"));
    }

    @Test
    public void testDuplicateTaskId() {
        TaskService service = new TaskService();
        Task t1 = new Task("1", "Homework", "Finish Milestone");
        Task t2 = new Task("1", "Reading", "Read chapter");

        service.addTask(t1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(t2);
        });
    }

    @Test
    public void testDeleteTask() {
        TaskService service = new TaskService();
        Task t1 = new Task("1", "Homework", "Finish Milestone");

        service.addTask(t1);
        service.deleteTask("1");

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateName("1", "Reading");
        });
    }

    @Test
    public void testUpdateTaskFields() {
        TaskService service = new TaskService();
        Task t1 = new Task("1", "Homework", "Finish Milestone");

        service.addTask(t1);
        service.updateName("1", "Reading");
        service.updateDescription("1", "Read chapter 6");

        assertDoesNotThrow(() -> service.updateDescription("1", "New description"));
    }
}