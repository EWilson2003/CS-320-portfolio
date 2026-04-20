package projectone;

public class Task {
    private final String taskId;
    private String name;
    private String description;

    public Task(String taskId, String name, String description) {
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("invalid task ID");
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("invalid name");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("invalid description");
        }

        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }
    //Getters and Setters
    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("invalid name");
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("invalid description");
        }
        this.description = description;
    }
}