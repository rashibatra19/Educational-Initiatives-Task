
### 2. Composite Pattern - File System Structure

#### `instructions.md`
```markdown
# Composite Pattern - File System Structure

## Description
The Composite Pattern is a structural pattern that allows you to compose objects into tree structures to represent part-whole hierarchies. This pattern enables clients to treat individual objects and compositions uniformly.

## Use Case
In this implementation, we create a file system structure that allows users to add both files and folders. Each folder can contain files and other folders, enabling a hierarchical organization of files.

## Components
- **Component**: An interface that defines common operations for both files and folders.
- **File**: A class representing a file.
- **Folder**: A class representing a folder that can contain files and other folders.
- **Main**: The entry point where users can add files and folders interactively.

## How to Run
1. Compile the Java files:
   ```bash
   javac structural/composite/*.java

2. Run the application
    ```bash
    java structural.composite.Main
