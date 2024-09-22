package exercise_1.src.structural.adapter;


import java.util.Random;

public class TemperatureSensor {
    public double readTemperature() {
        return 20 + (30 - 20) * new Random().nextDouble();
    }
}
