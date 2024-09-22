package exercise_2;

/*
 * TimeUtils Class
 * 
 * The TimeUtils class provides utility methods for handling time-related functionalities
 * within the task scheduling application. This class includes methods for validating
 * and normalizing time input to ensure it adheres to a specific format.
 */
class TimeUtils {
    /*
     * Validates and normalizes a given time string.
     * 
     * This method checks if the input time string is in the format HH:MM (24-hour format).
     * If the format is valid, the method returns the time string; otherwise, it returns null.
     *
     * @param time The time string to validate.
     * @return The normalized time string if valid, or null if invalid.
     */
    public static String validateAndNormalizeTime(String time) {
        // Regular expression to match HH:MM format (24-hour)
        if (time.matches("^([01]\\d|2[0-3]):([0-5]\\d)$")) {
            return time; // Return the valid time in HH:MM format
        }
        return null; // Return null for invalid time format
    }
}
