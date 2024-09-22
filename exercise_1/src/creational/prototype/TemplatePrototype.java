package exercise_1.src.creational.prototype;


import java.util.HashMap;
import java.util.Map;

public class TemplatePrototype {
    private Map<String, Template> templates = new HashMap<>();

    public TemplatePrototype() {
        templates.put("landing", new LandingPageTemplate());
        templates.put("form", new FormTemplate());
    }

    public Template getTemplate(String type) {
        Template template = templates.get(type);
        return template != null ? template.clone() : null;
    }
}
