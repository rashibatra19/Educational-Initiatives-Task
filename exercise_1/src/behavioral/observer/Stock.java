package exercise_1.src.behavioral.observer;


import java.util.ArrayList;
import java.util.List;

public class Stock {
    private String stockSymbol;
    private float price;
    private List<StockObserver> observers = new ArrayList<>();

    public Stock(String stockSymbol, float price) {
        this.stockSymbol = stockSymbol;
        this.price = price;
    }

    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    public void setPrice(float newPrice) {
        this.price = newPrice;
        notifyObservers();
    }

    private void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(stockSymbol, price);
        }
    }
}

