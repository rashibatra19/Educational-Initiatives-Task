package exercise_1.src.structural.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SensorDataManager {
    private List<SensorAdapter> sensors = new ArrayList<>();

    public void addSensor(SensorAdapter sensor) {
        sensors.add(sensor);
    }

    public void collectData() {
        for (SensorAdapter sensor : sensors) {
            SensorData data = sensor.getSensorData();
            System.out.println(data);
        }
    }

    public void manageSensors() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of sensors to add (1 for Temperature, 2 for Humidity): ");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.print("Choose sensor type (1: Temperature, 2: Humidity): ");
            int type = scanner.nextInt();
            if (type == 1) {
                addSensor(new TemperatureSensorAdapter(new TemperatureSensor()));
            } else if (type == 2) {
                addSensor(new HumiditySensorAdapter(new HumiditySensor()));
            }
        }

        System.out.println("Collecting sensor data...");
        collectData();

        scanner.close();
    }
}
