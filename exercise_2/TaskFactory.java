package exercise_2;

/*
 * TaskFactory Class
 * 
 * The TaskFactory class is responsible for creating Task objects. It serves as a factory to encapsulate 
 * the instantiation of Task instances, promoting loose coupling and adherence to the Factory Design Pattern.
 *
 * Methods:
 * - createTask(String description, String startTime, String endTime, String priority):
 *   This static method takes the necessary parameters to create a new Task object. It returns the newly created Task.
 *   This method can be expanded in the future to include additional logic for task creation if needed, 
 *   such as applying default values or validation.
 */

class TaskFactory {
    public static Task createTask(String description, String startTime, String endTime, String priority) {
        return new Task(description, startTime, endTime, priority);
    }
}
