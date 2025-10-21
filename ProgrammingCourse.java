public class ProgrammingCourse implements Course {
    private String name;

    public ProgrammingCourse(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getTitle() {
        return "Programming Course " + name;
    }

    @Override
    public String deliverContent() {
        return "Delivering programming basics " + name;
    }
}
