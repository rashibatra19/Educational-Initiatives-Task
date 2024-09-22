# Prototype Pattern - Design Template Library

## Description
The Prototype Pattern is a creational design pattern that enables the cloning of existing objects to create new instances. This pattern is particularly useful when object creation is costly or complex, allowing for more efficient resource management.

## Use Case
In this implementation, we have a design template library that allows designers to clone existing design templates (such as landing pages or forms). This promotes consistency and efficiency by enabling rapid modifications of pre-defined templates.

## Components
- **Template**: An abstract class defining the common interface for all templates.
- **TemplatePrototype**: An interface specifying the `clone` method for cloning templates.
- **LandingPageTemplate**: A concrete class representing a landing page template that implements the `Template` and `TemplatePrototype` interfaces.
- **FormTemplate**: A concrete class representing a form template that also implements the `Template` and `TemplatePrototype` interfaces.
- **TemplateManager**: A class responsible for managing templates, including cloning functionality.
- **Main**: The entry point that interacts with users, allowing them to clone and modify templates.

## How to Run
1. Compile the Java files:
   ```bash
   javac structural/prototype/*.java

2. Run the application
    ```bash
    java structural.prototype.Main
