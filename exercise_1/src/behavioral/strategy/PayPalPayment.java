package exercise_1.src.behavioral.strategy;

public class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + (amount - (amount * 0.03)) + " using PayPal with 3% discount.");
    }
}

