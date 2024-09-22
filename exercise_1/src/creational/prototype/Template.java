package exercise_1.src.creational.prototype;


public abstract class Template {
    protected String name;
    protected String category;
    protected String version;

    public abstract Template clone();

    public void display() {
        System.out.println("Template: " + name + ", Category: " + category + ", Version: " + version);
    }

    // Setters for modifying template details
    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
