package exercise_1.src.creational.prototype;



public class FormTemplate extends Template {
    public FormTemplate() {
        this.name = "Default Form";
        this.category = "Form";
        this.version = "1.0";
    }

    @Override
    public Template clone() {
        return new FormTemplate();
    }
}
