package exercise_1.src.creational.prototype;


public class LandingPageTemplate extends Template {
    public LandingPageTemplate() {
        this.name = "Default Landing Page";
        this.category = "Landing Page";
        this.version = "1.0";
    }

    @Override
    public Template clone() {
        return new LandingPageTemplate();
    }
}
