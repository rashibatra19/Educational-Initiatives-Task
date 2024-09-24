# Coding Exercises - Design Patterns and Mini Project

This repository contains two coding exercises as part of a technical assessment. The code is written in **Java**, organized into two folders: **Exercise 1** and **Exercise 2**.

## Structure

### 1. Exercise 1: Design Patterns Demonstration
This folder showcases six use cases demonstrating an understanding of the following design patterns:
- **Behavioral Design Patterns**
  1. Observer Pattern-Stock Market Monitoring
  2. Strategy Pattern - Payment Processing System
  
- **Creational Design Patterns**
  1. Prototype Pattern - Design Template Library
  2. Singleton Pattern - Database Connection Example
  
- **Structural Design Patterns**
  1. Adapter Pattern - Sensor Data Collection
  2. Composite Pattern - File System Structure

Each pattern has its own class file, and the code is structured to adhere to **best practices**, with a focus on code quality, logging, and performance.
Each pattern consists of instructions.md file for the explanation of each class.

### 2. Exercise 2: Astronaut Daily Schedule Organizer (Mini-Project)
**Problem Statement**:

Design and implement a console-based application that helps astronauts organize their daily schedules. The application should allow users
to add, remove, and view daily tasks. Each task will have a description, start time, end time, and priority level. The intent behind this problem
statement is to evaluate your ability to implement a basic CRUD (Create, Read, Update, Delete) application, manage data efficiently, and
apply best coding practices.

This folder contains the implementation of a **console-based application** that helps astronauts organize their daily schedules. It supports the following features:
- **CRUD operations** (Add, Remove, View tasks).
- Tasks are managed by a **Singleton Schedule Manager**.
- Uses the **Factory Pattern** to create task objects.
- The **Observer Pattern** is implemented to notify users of task conflicts.

#### Functionalities:
- Add tasks with description, start time, end time, and priority level.
- Prevent task overlap.
- Edit or mark tasks as completed (optional requirements).
- View tasks based on priority level (optional).
- Edit an existing task.
- Mark tasks as completed.
- View tasks for a specific priority level

#### Example Scenarios:
- **Positive Case**: Add Task("Morning Exercise", "07:00", "08:00", "High") – Task added successfully.
- **Negative Case**: Add Task("Overlap Task", "08:30", "09:30", "Medium") – Error: Task conflicts with existing task "Team Meeting".

### Key Focus:
- **Design Patterns**: Singleton, Factory, and Observer Patterns.
- **Adherence to SOLID Principles** and **OOP Best Practices**.
- **Performance Optimization** and **Error Handling**.

## Requirements for Running the Application
To run the Java code:
1. Clone the repository
2. Navigate to the desired folder (Exercise 1 or 2).
3. Compile and run the Java code using the command:
   ```bash
   javac Main.java
   java Main
```
