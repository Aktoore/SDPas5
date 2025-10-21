import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentPortalFacade portal = new StudentPortalFacade();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("         LMS MENU        \n");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. List Courses");
            System.out.println("4. Enroll Student");
            System.out.println("5. Start learning");
            System.out.println("6. Complete course");
            System.out.println("7. List Enrollments");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0) break;

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter your course year (1-3): ");
                    int year = Integer.parseInt(sc.nextLine());
                    portal.addStudent(name, year);
                }

                case 2 -> {
                    System.out.print("Enter student name to assign course: ");
                    String studentName = sc.nextLine();
                    Student student = portal.getStudent(studentName);
                    if (student == null) {
                        System.out.println("❌ Student not found!");
                        break;
                    }

                    System.out.print("Choose course type: 1-Math 2-Programming\n> ");
                    int type = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter course name: ");
                    String courseName = sc.nextLine();

                    Course course = CourseFactory.createCourse(student, type, courseName);
                    if (course == null) break; // если студент не может взять курс

                    System.out.print("Add certificate? (y/n): ");
                    boolean cert = sc.nextLine().equalsIgnoreCase("y");
                    System.out.print("Add mentor support? (y/n): ");
                    boolean mentor = sc.nextLine().equalsIgnoreCase("y");
                    System.out.print("Add gamification? (y/n): ");
                    boolean game = sc.nextLine().equalsIgnoreCase("y");

                    if (cert) course = new CertificateDecorator(course);
                    if (mentor) course = new MentorSupDecorator(course);
                    if (game) course = new GamificationDecorator(course);

                    portal.addCourse(course);
                }

                case 3 -> portal.listCourses();

                case 4 -> {
                    System.out.print("Student name: ");
                    String studentName = sc.nextLine();
                    System.out.print("Course name: ");
                    String courseName = sc.nextLine();
                    portal.enrollStudent(studentName, courseName);
                }

                case 5 -> {
                    System.out.print("Student name: ");
                    String studentName = sc.nextLine();
                    System.out.print("Course name: ");
                    String courseName = sc.nextLine();
                    portal.startLearning(studentName, courseName);
                }

                case 6 -> {
                    System.out.print("Student name: ");
                    String studentName = sc.nextLine();
                    System.out.print("Course name: ");
                    String courseName = sc.nextLine();
                    portal.completeCourse(studentName, courseName);
                }

                case 7 -> portal.listEnrollments();

                default -> System.out.println("Invalid choice");
            }
        }

        System.out.println("Goodbye!");
    }
}
