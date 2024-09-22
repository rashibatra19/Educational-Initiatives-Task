package exercise_1.src.structural.composite;


import java.util.ArrayList;
import java.util.List;

public class Folder implements Component {
    private String name;
    private List<Component> components = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Folder: " + name);
        for (Component component : components) {
            component.showDetails();
        }
    }
}
