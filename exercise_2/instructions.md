# File Descriptions for Task Scheduler Project

This document provides a comprehensive overview of each file in the Task Scheduler project, explaining its purpose, key features, design patterns employed, and important implementation details.

## 1. `Task.java`
### Purpose:
The `Task` class represents individual tasks in the scheduler. Each task is characterized by a description, start time, end time, priority level, and a completion status. This class encapsulates the data and behaviors associated with tasks.

### Key Features:
- **Attributes**: 
  - `description`: A string that describes the task's nature or goal.
  - `startTime`: The time when the task begins, formatted as HH:MM.
  - `endTime`: The time when the task ends, formatted as HH:MM.
  - `priority`: The priority level of the task, which can be Low, Medium, or High. This helps users identify tasks that need immediate attention.
  - `completed`: A boolean flag indicating whether the task has been completed, allowing users to track progress.

### Methods:
- **Getters**: Accessor methods for each attribute ensure encapsulation and allow controlled access to task properties.
- **Comparable Interface**: Implements `Comparable<Task>` to allow tasks to be sorted by their start time, facilitating easier task management.

### Design Patterns:
- **None**: The `Task` class is primarily a data model and does not implement complex design patterns.

---

## 2. `ScheduleManager.java`
### Purpose:
The `ScheduleManager` class acts as the central controller for task management. It implements the singleton pattern to ensure that only one instance of this class exists throughout the application, managing all tasks effectively.

### Key Features:
- **Task Management**: 
  - `addTask(...)`: Validates input and adds a new task to the schedule. It checks for time overlaps with existing tasks, ensuring no two tasks conflict.
  - `removeTask(...)`: Removes a task based on its index after confirming that the index is valid.
  - `viewTasks()`: Displays all tasks in a user-friendly format, sorted by start time, helping users quickly identify their schedule.
  - `editTask(...)`: Modifies existing tasks, allowing users to update descriptions, times, and priorities.
  - `markTaskCompleted(...)`: Updates the task status to completed, providing users with a clear view of their progress.

### Error Handling:
- Robust error handling is implemented for various scenarios, including:
  - Overlapping tasks.
  - Invalid time formats.
  - Non-existent tasks.
  
### Design Patterns:
- **Singleton Pattern**: Ensures that only one instance of `ScheduleManager` exists, providing a single point of control for managing tasks across the application.

---

## 3. `TaskFactory.java`
### Purpose:
The `TaskFactory` class provides a method for creating `Task` objects. By centralizing the creation logic, this factory simplifies the instantiation process and enhances flexibility.

### Key Features:
- **Task Creation**: 
  - `createTask(...)`: Instantiates a new `Task` object with the specified attributes, ensuring that all tasks are created consistently.

### Design Patterns:
- **Factory Pattern**: This pattern decouples the instantiation process from the rest of the application, allowing for future enhancements or modifications without affecting other parts of the code.

---

## 4. `TimeUtils.java`
### Purpose:
The `TimeUtils` class contains utility methods for validating and normalizing time inputs. This ensures that user inputs conform to expected formats, improving robustness.

### Key Features:
- **Time Validation**: 
  - `validateAndNormalizeTime(...)`: Checks if the time is in a valid HH:MM format. If valid, it normalizes it for consistent processing.

### Design Patterns:
- **None**: This class serves as a utility with static methods and does not employ any design patterns.

---

## 5. `TaskScheduler.java`
### Purpose:
The `TaskScheduler` class is the main entry point of the application, providing a console-based interface for user interaction. It orchestrates the flow of the application, guiding users through task management operations.

### Key Features:
- **User Interface**: 
  - `displayMenu()`: Presents a menu of options to the user and processes their input, allowing for intuitive interaction.
  - `addTask()`: Collects user input for adding a new task, enhancing user engagement with clear prompts.
  - `removeTask()`: Manages the process of removing tasks, including displaying available tasks for the user to choose from.

### Interaction Flow:
- The application operates in a loop, continuously presenting options until the user chooses to exit. This design allows for a seamless user experience.

### Design Patterns:
- **None**: The `TaskScheduler` class coordinates user interactions without implementing complex patterns.

---

## Conclusion
This project showcases the application of fundamental design patterns and principles to create a robust and maintainable task management application. Each class is designed with a clear purpose, adhering to the SOLID principles to enhance code readability, scalability, and maintainability.

## Future Enhancements
- **Observer Pattern**: Consider implementing this pattern to notify users of task updates or conflicts in real-time, improving the user experience.
- **Logging Mechanism**: Enhance error tracking and user activity monitoring for better application insights and debugging.
- **User Preferences**: Allow users to customize their experience, such as choosing date formats or notification settings.

## Contribution Guidelines
If you would like to contribute to this project, please fork the repository, make your changes, and submit a pull request. Ensure to follow the coding standards and document any new features or changes. Collaboration is encouraged to improve the overall quality of the application!

---

### File Structure
- **Task.java**: Represents individual tasks, encapsulating all task-related data.
- **ScheduleManager.java**: Manages task operations and enforces the singleton pattern.
- **TaskFactory.java**: Provides a centralized method for creating task objects.
- **TimeUtils.java**: Utility class for validating and normalizing time inputs.
- **TaskScheduler.java**: Main class for user interaction and task management orchestration.
