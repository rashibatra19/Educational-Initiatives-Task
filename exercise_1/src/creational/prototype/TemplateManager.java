package exercise_1.src.creational.prototype;



import java.util.Scanner;

public class TemplateManager {
    private TemplatePrototype prototype = new TemplatePrototype();

    public void manageTemplates() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Choose template type to clone: 1. Landing Page 2. Form");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String templateType = (choice == 1) ? "landing" : "form";
        Template clonedTemplate = prototype.getTemplate(templateType);

        if (clonedTemplate != null) {
            System.out.println("Cloning template...");
            clonedTemplate.display();

            System.out.print("Enter new name for the cloned template: ");
            clonedTemplate.setName(scanner.nextLine());

            System.out.print("Enter new category for the cloned template: ");
            clonedTemplate.setCategory(scanner.nextLine());

            System.out.print("Enter new version for the cloned template: ");
            clonedTemplate.setVersion(scanner.nextLine());

            System.out.println("Cloned Template Details:");
            clonedTemplate.display();
        } else {
            System.out.println("Template type not found.");
        }

        scanner.close();
    }
}

