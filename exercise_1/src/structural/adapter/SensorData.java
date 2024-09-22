package exercise_1.src.structural.adapter;

public class SensorData {
    private String type;
    private double value;

    public SensorData(String type, double value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Sensor Type: " + type + ", Value: " + value;
    }
}

