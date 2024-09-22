/*
 * Singleton Pattern: The ScheduleManager class uses a singleton pattern to ensure a single instance 
 * is used throughout the application. This design prevents multiple instances that could lead to 
 * inconsistent task data.
 * 
 * CSV File Handling: The application uses a CSV file (tasks.csv) to persist task data, ensuring 
 * that tasks are saved and loaded between application sessions.
 * 
 * Task Management Methods: The class provides methods for adding, removing, viewing, editing, 
 * and marking tasks as completed, encapsulating all task-related functionalities.
 * 
 * Validation Logic: Each method includes validation checks to ensure that tasks are added, edited, 
 * or removed correctly, handling potential errors gracefully.
 * 
 * File I/O Operations: Buffered readers and writers are used for efficient file operations, with 
 * proper exception handling to catch potential I/O errors.
 * 
 * Utility Functions: Helper functions like isValidPriority ensure that the application logic is 
 * clean and modular, making the code easier to maintain.
 */

 
 
package exercise_2;

import java.io.*; // Import necessary classes for file handling
import java.nio.file.*; // Import classes for path operations
import java.util.ArrayList; // Import ArrayList for dynamic task storage
import java.util.Collections; // Import Collections for sorting tasks
import java.util.List; // Import List interface

// ScheduleManager class handles task management operations.
// It follows the Singleton design pattern to ensure only one instance exists throughout the application.
class ScheduleManager {
    private static ScheduleManager instance; // Singleton instance
    private final List<Task> tasks; // List to hold Task objects
    private static final String CSV_FILE = "tasks.csv"; // Path for CSV file storage

    // Private constructor to prevent external instantiation.
    private ScheduleManager() {
        tasks = new ArrayList<>(); // Initialize the task list
        initializeCSV(); // Ensure the CSV file has headers
        loadTasksFromCSV(); // Load existing tasks from the CSV file
    }

    // Provides access to the single instance of ScheduleManager.
    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    // Initializes the CSV file with headers if it does not exist.
    private void initializeCSV() {
        Path path = Paths.get(CSV_FILE);
        if (Files.notExists(path)) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_FILE))) {
                bw.write("Description,Start Time,End Time,Priority,Completed\n"); // Write headers
            } catch (IOException e) {
                System.out.println("Error initializing CSV file."); // Error handling for file operations
            }
        }
    }

    // Adds a new task to the task list.
    public void addTask(String description, String startTime, String endTime, String priority) {
        // Validate and normalize start and end times.
        String finalStartTime = TimeUtils.validateAndNormalizeTime(startTime);
        String finalEndTime = TimeUtils.validateAndNormalizeTime(endTime);

        if (finalStartTime == null || finalEndTime == null) {
            System.out.println("Error: Invalid time format. Use HH:MM (24-hour format).");
            return;
        }

        // Ensure the start time is earlier than the end time.
        if (finalStartTime.compareTo(finalEndTime) >= 0) {
            System.out.println("Error: Start time must be earlier than end time.");
            return;
        }

        // Validate priority input.
        if (!isValidPriority(priority)) {
            System.out.println("Error: Invalid priority. Allowed values are Low, Medium, High.");
            return;
        }

        // Check for task overlap.
        boolean isConflict = tasks.stream().anyMatch(
                task -> finalStartTime.compareTo(task.getEndTime()) < 0
                        && finalEndTime.compareTo(task.getStartTime()) > 0);

        if (isConflict) {
            System.out.println("Error: Task conflicts with existing tasks.");
            return;
        }

        // Create and add the new task, then save to CSV.
        Task task = TaskFactory.createTask(description, finalStartTime, finalEndTime, priority);
        tasks.add(task);
        Collections.sort(tasks); // Sort tasks based on their start time
        saveTasksToCSV(); // Persist changes to CSV
        System.out.println("Task added successfully.");
    }

    // Validates the priority input.
    private boolean isValidPriority(String priority) {
        return priority.equalsIgnoreCase("Low") ||
               priority.equalsIgnoreCase("Medium") ||
               priority.equalsIgnoreCase("High");
    }

    // Removes a task based on its index.
    public void removeTask(int taskNumber) {
        int index = taskNumber - 1; // Adjust for zero-based index
        if (index >= 0 && index < tasks.size()) {
            Task removedTask = tasks.remove(index); // Remove task from list
            saveTasksToCSV(); // Save updated task list to CSV
            System.out.println("Task \"" + removedTask.getDescription() + "\" removed successfully.");
        } else {
            System.out.println("Error: Invalid task number.");
        }
    }

    // Displays all tasks in the task list.
    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                // Display task details including completion status
                System.out.printf("%d. %s - %s: %s [%s]%s%n", i + 1, task.getStartTime(), task.getEndTime(),
                        task.getDescription(), task.getPriority(),
                        task.isCompleted() ? " (Completed)" : "");
            }
        }
    }

    // Views tasks filtered by a specific priority level.
    public void viewTasksByPriority(String priority) {
        boolean found = false; // Flag to check if any tasks are found
        for (Task task : tasks) {
            if (task.getPriority().equalsIgnoreCase(priority)) {
                // Display matching tasks
                System.out.printf("%s - %s: %s [%s] %s%n",
                        task.getStartTime(), task.getEndTime(),
                        task.getDescription(), task.getPriority(),
                        task.isCompleted() ? "(Completed)" : "");
                found = true; // Set found to true
            }
        }
        if (!found) {
            System.out.println("No tasks found with the given priority."); // Notify if no tasks match
        }
    }

    // Displays tasks for removal, allowing the user to select one.
    public void displayTasksForRemoval() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
        } else {
            System.out.println("Select a task to remove:");
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                // Display tasks with their completion status
                System.out.printf("%d. %s - %s: %s [%s]%s%n", i + 1, task.getStartTime(), task.getEndTime(),
                        task.getDescription(), task.getPriority(),
                        task.isCompleted() ? " (Completed)" : "");
            }
        }
    }

    // Loads tasks from the CSV file into the task list.
    private void loadTasksFromCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            boolean firstLine = true; // To skip the header
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // Skip header line
                    continue;
                }
                String[] data = line.split(","); // Split CSV data into fields
                if (data.length == 5) {
                    String description = data[0];
                    String startTime = data[1];
                    String endTime = data[2];
                    String priority = data[3];
                    boolean isCompleted = Boolean.parseBoolean(data[4]); // Read completion status
                    tasks.add(new Task(description, startTime, endTime, priority, isCompleted));
                }
            }
        } catch (IOException e) {
            System.out.println("No previous tasks found or error reading file."); // Handle file reading errors
        }
    }
    
    // Saves the current task list to the CSV file.
    private void saveTasksToCSV() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_FILE))) {
            bw.write("Description,Start Time,End Time,Priority,Completed\n"); // Write header
            for (Task task : tasks) {
                // Save each task's details to CSV including completion status
                bw.write(String.format("%s,%s,%s,%s,%s%n",
                        task.getDescription(),
                        task.getStartTime(),
                        task.getEndTime(),
                        task.getPriority(),
                        task.isCompleted()));
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks to CSV file."); // Error handling for file operations
        }
    }

    // Edits an existing task by updating its details.
    public void editTask(int taskNumber, String newDescription, String newStartTime, String newEndTime, String newPriority) {
        int index = taskNumber - 1; // Adjust for zero-based index
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            // Validate new times and priority
            String finalStartTime = TimeUtils.validateAndNormalizeTime(newStartTime);
            String finalEndTime = TimeUtils.validateAndNormalizeTime(newEndTime);

            if (finalStartTime == null || finalEndTime == null) {
                System.out.println("Error: Invalid time format. Use HH:MM (24-hour format).");
                return;
            }

            if (finalStartTime.compareTo(finalEndTime) >= 0) {
                System.out.println("Error: Start time must be earlier than end time.");
                return;
            }

            if (!isValidPriority(newPriority)) {
                System.out.println("Error: Invalid priority. Allowed values are Low, Medium, High.");
                return;
            }

            // Check for conflicts with existing tasks
            boolean isConflict = tasks.stream().anyMatch(t -> t != task &&
                    finalStartTime.compareTo(t.getEndTime()) < 0 &&
                    finalEndTime.compareTo(t.getStartTime()) > 0);

            if (isConflict) {
                System.out.println("Error: Task conflicts with existing tasks.");
                return;
            }

            // Update task properties
            task.setDescription(newDescription);
            task.setStartTime(finalStartTime);
            task.setEndTime(finalEndTime);
            task.setPriority(newPriority);
            saveTasksToCSV(); // Save updated task list to CSV
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Error: Invalid task number."); // Handle invalid task number
        }
    }

    // Marks a task as completed.
    public void markTaskAsCompleted(int taskNumber) {
        int index = taskNumber - 1; // Adjust for zero-based index
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.setCompleted(true); // Update completion status
            saveTasksToCSV(); // Save updated task list to CSV
            System.out.println("Task \"" + task.getDescription() + "\" marked as completed.");
        } else {
            System.out.println("Error: Invalid task number."); // Handle invalid task number
        }
    }
}
