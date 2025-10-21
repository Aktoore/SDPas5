import java.util.*;

public class StudentPortalFacade {
    private Map<String, Student> students = new HashMap<>();
    private Map<String, Course> courses = new HashMap<>();

    public void addStudent(String name, int year) {
        students.put(name.toLowerCase(), new Student(name, year));
        System.out.println("✅ Student added: " + name + " (Year " + year + ")");
    }

    public void addCourse(Course course) {
        courses.put(course.getName().toLowerCase(), course);
        System.out.println("✅ Course added: " + course.getName());
    }

    public void listCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available yet.");
            return;
        }
        System.out.println("Available courses:");
        for (Course course : courses.values()) {
            System.out.println("- " + course.getTitle());
        }
    }
    public void enrollStudent(String studentName, String courseName) {
        Student student = students.get(studentName.toLowerCase());
        Course course = courses.get(courseName.toLowerCase());

        if (student == null || course == null) {
            System.out.println(" Student or couse not found.");
            return;
        }

        int year = student.getYear();
        String title = course.getTitle().toLowerCase();

        if (year == 1 && !title.contains("math")) {
            System.out.println("First-year students can only take Math couses.");
            return;
        } else if (year == 2 && !(title.contains("math") || title.contains("programming"))) {
            System.out.println("Second-year students can take Math courses or Programming courses.");
            return;
        } else if (year == 3 && title.contains("programming")) {
            System.out.println("Third-year students can only take Programming course.");
            return;
        }

        student.enroll(course);
        System.out.println("✅ " + student.getName() + " enrolled in " + course.getTitle());
    }


    public void startLearning(String studentName, String courseName) {
        Student student = students.get(studentName.toLowerCase());
        if(student == null) {
            System.out.println(" Student not found.");
            return;
        }
        Course course = student.getCourse(courseName);
        if(course == null) {
            System.out.println("Student not enrolled in this course.");
            return;
        }
        System.out.println("⏳ Starting" + course.getTitle());
        System.out.println(course.deliverContent());

        if (course instanceof GamificationDecorator) {
            ((GamificationDecorator) course).playMiniGame(student);
        }
    }

    public void listEnrollments() {
        if (students.isEmpty()) {
            System.out.println("No students enrolled yet.");
            return;
        }

        System.out.println("📋 Enrollments:");
        for (Student s : students.values()) {
            System.out.print("👩‍🎓 " + s.getName() + " enrolled in: ");
            if (s.getCourses().isEmpty()) {
                System.out.println("no courses yet.");
            } else {
                for (Course c : s.getCourses()) {
                    System.out.print(c.getName() + " ");
                }
                System.out.println();
            }
        }
    }

    public void completeCourse(String studentName, String courseName) {
        Student student = students.get(studentName.toLowerCase());
        if(student == null) {
            System.out.println(" Student not found.");
            return;
        }
        Course course = student.getCourse(courseName);
        if(course == null) {
            System.out.println("Student not enrolled in this course.");
            return;
        }
        System.out.println(student.getName() + " completed " + course.getTitle());

        if (course instanceof GamificationDecorator g) {
            int points = g.awardPoints(5);
            System.out.println("⭐ Points earned: " + points);
        }
    }

    public Student getStudent(String name) {
        return students.get(name.toLowerCase());
    }
}
