package exercise_1.src.behavioral.observer;


public class Trader implements StockObserver {
    private String name;

    public Trader(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockSymbol, float price) {
        System.out.println("Trader " + name + " notified. " + stockSymbol + " price updated to $" + price);
    }
}
