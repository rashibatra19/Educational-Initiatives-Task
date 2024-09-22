package exercise_2;

// ConsoleTaskObserver implements the TaskObserver interface
// This class is responsible for handling notifications regarding task conflicts.
class ConsoleTaskObserver implements TaskObserver {

    // This method is called when a conflict with a task is detected.
    @Override
    public void notifyConflict(Task task) {
        // Output a message to the console indicating which task has a conflict.
        System.out.println("Conflict detected with task: " + task.getDescription());
    }
}
