package exercise_1.src.structural.adapter;




import java.util.Random;

public class HumiditySensor {
    public double readHumidity() {
        return 30 + (70 - 30) * new Random().nextDouble();
    }
}


