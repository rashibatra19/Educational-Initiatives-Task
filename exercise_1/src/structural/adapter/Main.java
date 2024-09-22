package exercise_1.src.structural.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<SensorAdapter> sensors = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many sensors would you like to add? ");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.print("Choose sensor type (1: Temperature, 2: Humidity): ");
            int type = scanner.nextInt();
            if (type == 1) {
                sensors.add(new TemperatureSensorAdapter(new TemperatureSensor()));
            } else if (type == 2) {
                sensors.add(new HumiditySensorAdapter(new HumiditySensor()));
            } else {
                System.out.println("Invalid sensor type! Please try again.");
                i--; // Repeat this iteration
            }
        }

        System.out.println("Collecting sensor data...");
        for (SensorAdapter sensor : sensors) {
            System.out.println(sensor.getSensorData());
        }

        scanner.close();
    }
}

