import java.util.List;
import java.util.ArrayList;

public class Student {
    private String name;
    private int year;
    private List<Course> enrolledCourses = new ArrayList<>();
    private int points = 0;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public void enroll(Course course) {
        enrolledCourses.add(course);
        System.out.println("Welcome " + name + "! You enrolled in " + course.getTitle());
    }

    public List<Course> getCourses() {
        return enrolledCourses;
    }

    public boolean isEnrolled(String courseName) {
        return enrolledCourses.stream().anyMatch(c -> c.getName().equalsIgnoreCase(courseName));
    }

    public Course getCourse(String courseName) {
        return enrolledCourses.stream().filter(c -> c.getName().equalsIgnoreCase(courseName)).findFirst().orElse(null);
    }

    public void addPoints(int pts) {
        points += pts;
    }

    public int getPoints() {
        return points;
    }
}
