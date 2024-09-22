package exercise_2;

import java.util.Scanner;

/*
 * TaskScheduler Class
 * 
 * The TaskScheduler class serves as the entry point for the task scheduling application.
 * It provides a command-line interface that allows users to interact with the ScheduleManager
 * to manage their tasks effectively. The class is responsible for displaying the menu,
 * processing user input, and invoking the corresponding methods in the ScheduleManager.
 */
public class TaskScheduler {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ScheduleManager scheduleManager = ScheduleManager.getInstance();

    public static void main(String[] args) {
        displayMenu(); // Initiate the menu display for user interaction
    }

    /*
     * Displays the main menu for task management.
     * Continuously prompts the user for an action until they choose to exit.
     */
    private static void displayMenu() {
        while (true) {
            System.out.println("\nTask Scheduler Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Edit Task");
            System.out.println("5. Mark Task as Completed");
            System.out.println("6. View Tasks by Priority");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    addTask(); // Invoke method to add a task
                    break;
                case "2":
                    removeTask(); // Invoke method to remove a task
                    break;
                case "3":
                    scheduleManager.viewTasks(); // Display all tasks
                    break;
                case "4":
                    editTask(); // Invoke method to edit a task
                    break;
                case "5":
                    markTaskAsCompleted(); // Invoke method to mark a task as completed
                    break;
                case "6":
                    viewTasksByPriority(); // Invoke method to view tasks by priority
                    break;
                case "7":
                    System.out.println("Exiting..."); // Exit the application
                    return;
                default:
                    System.out.println("Invalid option. Please choose again."); // Handle invalid input
                    break;
            }
        }
    }

    /*
     * Prompts the user for task details and adds a new task using the ScheduleManager.
     */
    private static void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter start time (HH:MM): ");
        String startTime = scanner.nextLine();
        System.out.print("Enter end time (HH:MM): ");
        String endTime = scanner.nextLine();
        System.out.print("Enter priority (Low, Medium, High): ");
        String priority = scanner.nextLine();
        scheduleManager.addTask(description, startTime, endTime, priority); // Add task to the manager
    }

    /*
     * Displays tasks for removal and prompts the user to specify which task to remove.
     */
    private static void removeTask() {
        scheduleManager.displayTasksForRemoval(); // Show tasks available for removal
        System.out.print("Enter task number to remove: ");
        int taskNumber = Integer.parseInt(scanner.nextLine());
        scheduleManager.removeTask(taskNumber); // Remove the specified task
    }

    /*
     * Displays tasks for removal and prompts the user to specify which task to edit,
     * along with the new details for the task.
     */
    private static void editTask() {
        scheduleManager.displayTasksForRemoval(); // Show tasks available for editing
        System.out.print("Enter task number to edit: ");
        int taskNumber = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter new description: ");
        String newDescription = scanner.nextLine();
        System.out.print("Enter new start time (HH:MM): ");
        String newStartTime = scanner.nextLine();
        System.out.print("Enter new end time (HH:MM): ");
        String newEndTime = scanner.nextLine();
        System.out.print("Enter new priority (Low, Medium, High): ");
        String newPriority = scanner.nextLine();
        scheduleManager.editTask(taskNumber, newDescription, newStartTime, newEndTime, newPriority); // Edit the specified task
    }

    /*
     * Displays tasks for removal and prompts the user to specify which task to mark as completed.
     */
    private static void markTaskAsCompleted() {
        scheduleManager.displayTasksForRemoval(); // Show tasks available for marking as completed
        System.out.print("Enter task number to mark as completed: ");
        int taskNumber = Integer.parseInt(scanner.nextLine());
        scheduleManager.markTaskAsCompleted(taskNumber); // Mark the specified task as completed
    }

    /*
     * Prompts the user for a priority level and displays tasks matching that priority.
     */
    private static void viewTasksByPriority() {
        System.out.print("Enter priority (Low, Medium, High): ");
        String priority = scanner.nextLine();
        scheduleManager.viewTasksByPriority(priority); // View tasks filtered by the specified priority
    }
}
