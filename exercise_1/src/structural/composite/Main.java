package exercise_1.src.structural.composite;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Folder rootFolder = new Folder("Root");

        while (true) {
            System.out.println("Add a file or folder (enter 'file' or 'folder' or 'exit'): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("file")) {
                System.out.println("Enter file name: ");
                String fileName = scanner.nextLine();
                rootFolder.addComponent(new File(fileName));
            } else if (input.equalsIgnoreCase("folder")) {
                System.out.println("Enter folder name: ");
                String folderName = scanner.nextLine();
                rootFolder.addComponent(new Folder(folderName));
            } else if (input.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Invalid input.");
            }
        }

        System.out.println("\nFile system structure:");
        rootFolder.showDetails();
        scanner.close();
    }
}
