package exercise_2;

/*
 * Task Class
 * 
 * The Task class represents a task with its associated details and completion status. It implements the Comparable
 * interface to allow sorting tasks based on their start time.
 *
 * Attributes:
 * - description: A String representing the task's description.
 * - startTime: A String representing the task's start time in HH:MM format.
 * - endTime: A String representing the task's end time in HH:MM format.
 * - priority: A String indicating the priority level of the task (e.g., Low, Medium, High).
 * - isCompleted: A boolean flag indicating whether the task has been completed.
 *
 * Constructors:
 * - Task(String description, String startTime, String endTime, String priority, boolean isCompleted): 
 *   Initializes a new task with the provided details, including its completion status.
 * - Task(String description, String startTime, String endTime, String priority):
 *   An overloaded constructor for creating new tasks that are not yet completed. It defaults the isCompleted field to false.
 *
 * Getters and Setters:
 * - The class provides getter and setter methods for all attributes, allowing external classes to access and modify task details.
 *
 * Comparison:
 * - The compareTo method is overridden to define the natural ordering of tasks based on their start time, 
 *   enabling sorting of tasks in the ScheduleManager.
 */

class Task implements Comparable<Task> {
    private String description;
    private String startTime;
    private String endTime;
    private String priority;
    private boolean isCompleted; // New field for task completion status

    // Constructor including the isCompleted field
    public Task(String description, String startTime, String endTime, String priority, boolean isCompleted) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.isCompleted = isCompleted;
    }

    // Overloaded constructor (for new tasks that are not completed yet)
    public Task(String description, String startTime, String endTime, String priority) {
        this(description, startTime, endTime, priority, false); // Calls the other constructor with isCompleted=false
    }

    // Getter and setter methods
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    // compareTo method for sorting tasks by start time
    @Override
    public int compareTo(Task other) {
        return this.startTime.compareTo(other.startTime);
    }
}
