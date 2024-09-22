package exercise_1.src.structural.adapter;


public class TemperatureSensorAdapter implements SensorAdapter {
    private TemperatureSensor sensor;

    public TemperatureSensorAdapter(TemperatureSensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public SensorData getSensorData() {
        return new SensorData("Temperature", sensor.readTemperature());
    }
}
