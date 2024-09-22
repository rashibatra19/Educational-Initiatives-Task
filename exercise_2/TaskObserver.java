package exercise_2;

/*
 * TaskObserver Interface
 * 
 * The TaskObserver interface defines a contract for observer classes that need to be notified 
 * about task-related events, specifically conflicts. This interface follows the Observer Design Pattern,
 * allowing for loose coupling between the task management system and the components that handle task conflicts.
 *
 * Methods:
 * - notifyConflict(Task task):
 *   This method is intended to be implemented by observer classes to handle notifications when a 
 *   conflict with a task is detected. It provides the task that caused the conflict as a parameter, 
 *   allowing the observer to take appropriate action (e.g., logging the conflict, notifying the user, etc.).
 */

interface TaskObserver {
    void notifyConflict(Task task);
}
