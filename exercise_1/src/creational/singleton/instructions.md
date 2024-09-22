# **Singleton Pattern - Database Connection Example**

## **Introduction**

This example demonstrates the **Singleton Design Pattern**, which ensures that a class has only one instance and provides a global point of access to that instance. This pattern is commonly used for managing shared resources, such as database connections.

In this implementation:
- **DatabaseConnection**: The singleton class that manages the database connection and ensures only one instance exists throughout the application.

---

## **Project Structure**

```bash
exercise_1/src/creational/singleton/
│
├── DatabaseConnection.java   # Singleton class managing the database connection
└── Main.java                 # Main class to test the singleton implementation
```

## Steps:
1. Navigate to the Project Directory
    - Open a terminal or your IDE and navigate to the exercise_1/src/creational/singleton/ folder.

2. Compile the Code
    In your terminal, compile the Java files by running:
    ```bash
    javac *.java
    This command compiles all the .java files in the directory.

3. Run the Program

Once compiled, run the program using:
```bash
java Main
```

Interact with the Program
The program will prompt you to enter the number of connection requests. For each request, it will demonstrate that only one instance of DatabaseConnection is created and used.

## Example Run
Here is an example of how the program interacts with the user:

Enter the number of connection requests: 
3
New DatabaseConnection instance created.
Connected to the database.
Connected to the database.
Connected to the database.
Only one instance of DatabaseConnection is maintained across all requests.
## Design Pattern Explanation
- Singleton Pattern
The Singleton Pattern is a creational design pattern that restricts the instantiation of a class to one single instance. In this example:

- Instance Control: The DatabaseConnection class controls its instance with a private static variable.
- Global Access Point: The getInstance() method provides a global access point to retrieve the single instance.
- Thread Safety: The method is synchronized to ensure that multiple threads can safely access the instance.

# Benefits
- Controlled Access: Ensures controlled access to the single instance of the class.
- Lazy Initialization: The instance is created only when needed, which can save resources.
- Global Point of Access: Provides a simple way to access the single instance throughout the application.