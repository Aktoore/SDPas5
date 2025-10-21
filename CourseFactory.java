public class CourseFactory {
    public static Course createCourse(Student student, int choice, String title) {
        int year = student.getYear();

        switch (choice) {
            case 1:
                if (year >= 1) return new MathCourse(title);
                else {
                    System.out.println("❌ You cannot take Math.");
                    return null;
                }
            case 2:
                if (year >= 2) return new ProgrammingCourse(title);
                else {
                    System.out.println("❌ First-year students cannot take Programming.");
                    return null;
                }
            default:
                System.out.println("❌ Invalid course type.");
                return null;
        }
    }
}
