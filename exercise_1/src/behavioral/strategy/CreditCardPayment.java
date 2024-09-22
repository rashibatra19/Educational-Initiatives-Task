package exercise_1.src.behavioral.strategy;


public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + (amount - (amount * 0.05)) + " using Credit Card with 5% discount.");
    }
}
