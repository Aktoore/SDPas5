public class MathCourse implements Course {
    private String name;

    public MathCourse(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getTitle() {
        return "Math Course " + name;
    }

    @Override
    public String deliverContent() {
        return "Delivering math fundamentals " + name;
    }
}
