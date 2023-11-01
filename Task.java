/**
 * The Task class represents a task with an identifier, description, status, and priority.
 */
public class Task {
    private int task_id;
    private String description;
    private Status status;
    private int priority;

    /**
     * Enumeration representing the possible status of a task.
     */
    enum Status {
        PENDING, COMPLETED
    }

    /**
     * Constructs a new Task object with the provided parameters.
     *
     * @param id      The unique identifier for the task.
     * @param desc    The description of the task.
     * @param prior   The priority of the task.
     */
    public Task(int id, String desc, int prior) {
        this.task_id = id;
        this.description = desc;
        this.priority = prior;
        this.status = Status.PENDING;
    }

    /**
     * Retrieves the task identifier.
     *
     * @return The task identifier.
     */
    public int getTask_id() {
        return task_id;
    }

    /**
     * Retrieves the task description.
     *
     * @return The task description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retrieves the task priority.
     *
     * @return The task priority.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Sets the status of the task to either PENDING or COMPLETED.
     *
     * @param status The new status to set for the task.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Returns a string representation of the Task object.
     *
     * @return A string containing the task's details, including ID, description, priority, and status.
     */
    public String toString() {
        return "Task ID: " + task_id + ", Description: " + description + ", Priority: " + priority + ", Status: " + status;
    }
}
