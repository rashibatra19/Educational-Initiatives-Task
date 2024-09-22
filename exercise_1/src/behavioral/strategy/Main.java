package exercise_1.src.behavioral.strategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        System.out.println("Enter payment amount: ");
        int amount = scanner.nextInt();
        scanner.nextLine(); // Clear the newline character

        System.out.println("Choose payment method (CreditCard/PayPal): ");
        String paymentMethod = scanner.nextLine();

        if (paymentMethod.equalsIgnoreCase("CreditCard")) {
            cart.setPaymentStrategy(new CreditCardPayment());
        } else if (paymentMethod.equalsIgnoreCase("PayPal")) {
            cart.setPaymentStrategy(new PayPalPayment());
        } else {
            System.out.println("Invalid payment method!");
            scanner.close(); // Close the scanner before exiting
            return;
        }

        cart.checkout(amount);
        
        // Close the scanner after checkout
        scanner.close();
    }
}
