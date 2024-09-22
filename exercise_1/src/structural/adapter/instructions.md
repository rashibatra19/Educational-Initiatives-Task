# Adapter Pattern - Sensor Data Collection

## Description
The Adapter Pattern allows objects with incompatible interfaces to work together. This pattern acts as a bridge between two incompatible interfaces, enabling communication and data exchange.

## Use Case
In this implementation, we have a system that collects data from different types of sensors (Temperature and Humidity). Each sensor provides data in its own format, but the `SensorAdapter` interface standardizes how data is retrieved. This allows the `SensorDataManager` to work with any sensor type without being concerned about their specific implementations.

## Components
- **SensorData**: A class representing the standardized sensor data.
- **TemperatureSensor**: A class simulating a temperature sensor.
- **HumiditySensor**: A class simulating a humidity sensor.
- **SensorAdapter**: An interface defining the adapter contract.
- **TemperatureSensorAdapter**: An adapter class for the temperature sensor.
- **HumiditySensorAdapter**: An adapter class for the humidity sensor.
- **Main**: The entry point that interacts with the user and manages sensors.

## How to Run
1. Compile the Java files:
   ```bash
   javac structural/adapter/*.java

2. Run the application
    ```bash
    java structural.adapter.Main
