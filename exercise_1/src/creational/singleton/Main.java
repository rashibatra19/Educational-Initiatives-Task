package exercise_1.src.creational.singleton;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of connection requests: ");
        int requests = scanner.nextInt();

        for (int i = 1; i <= requests; i++) {
            DatabaseConnection connection = DatabaseConnection.getInstance();
            connection.connect();
        }

        System.out.println("Only one instance of DatabaseConnection is maintained across all requests.");
        scanner.close();
    }
}
