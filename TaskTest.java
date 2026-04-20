package projectone;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void testValidTask() {
        Task task = new Task("1", "Homework", "Finish Milestone");
        assertEquals("1", task.getTaskId());
        assertEquals("Homework", task.getName());
        assertEquals("Finish Milestone", task.getDescription());
    }

    @Test
    public void testBadTaskId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Homework", "Finish Milestone");
        });
    }

    @Test
    public void testBadName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1", null, "Finish Milestone");
        });
    }

    @Test
    public void testBadDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1", "Homework", null);
        });
    }

    @Test
    public void testSetFields() {
        Task task = new Task("1", "Homework", "Finish Milestone");
        task.setName("Reading");
        task.setDescription("Read chapter 6");

        assertEquals("Reading", task.getName());
        assertEquals("Read chapter 6", task.getDescription());
    }
}