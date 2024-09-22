package exercise_1.src.structural.adapter;



public class HumiditySensorAdapter implements SensorAdapter {
    private HumiditySensor sensor;

    public HumiditySensorAdapter(HumiditySensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public SensorData getSensorData() {
        return new SensorData("Humidity", sensor.readHumidity());
    }
}

