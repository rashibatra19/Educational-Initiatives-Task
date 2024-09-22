package exercise_1.src.behavioral.observer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stock stock = new Stock("AAPL", 150.00f);

        System.out.println("Enter number of traders to register: ");
        int numberOfTraders = scanner.nextInt();
        scanner.nextLine(); // Clear the newline character

        for (int i = 1; i <= numberOfTraders; i++) {
            System.out.println("Enter trader name: ");
            String traderName = scanner.nextLine();
            Trader trader = new Trader(traderName);
            stock.addObserver(trader);
        }

        String continueUpdating;
        do {
            System.out.println("Enter the new stock price: ");
            float newPrice = scanner.nextFloat();
            stock.setPrice(newPrice);

            System.out.println("Would you like to continue updating stock prices? (yes/no)");
            continueUpdating = scanner.next();
        } while (continueUpdating.equalsIgnoreCase("yes"));

        System.out.println("Ending stock price updates.");

        // Close the scanner
        scanner.close();
    }
}
