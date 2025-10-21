import java.util.Random;
import java.util.Scanner;

public class GamificationDecorator extends CourseDecorator {
    public GamificationDecorator(Course wrapped) {
        super(wrapped);
    }

    @Override
    public String getTitle() {
        return wrapped.getTitle() + " + Gamification";
    }

    @Override
    public String deliverContent() {
        return wrapped.deliverContent() + " [Gamified Learning Enabled]";
    }

    public int awardPoints(int basePoints) {
        return basePoints + 10;
    }

    public void playMiniGame(Student student) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int score = 0;

        System.out.println("\n🎯 Welcome to the Mini Game: " + getTitle());
        System.out.println("Answer 3 questions to earn bonus XP!\n");

        Course base = getBaseCourse();

        if (base instanceof MathCourse) {
            for (int i = 1; i <= 3; i++) {
                int a = random.nextInt(10) + 1;
                int b = random.nextInt(10) + 1;
                int answer = a + b;

                System.out.println(i + "️⃣ What is " + a + " + " + b + "?");
                System.out.print("> ");

                if (sc.hasNextInt() && sc.nextInt() == answer) {
                    System.out.println("✅ Correct!");
                    score++;
                } else {
                    System.out.println("❌ Wrong. Correct answer: " + answer);
                    if (sc.hasNext()) sc.next();
                }
            }
        } else if (base instanceof ProgrammingCourse) {
            sc.nextLine();

            System.out.println("1️⃣ What will this print?\nSystem.out.println(2 + \"2\");");
            System.out.print("> ");
            if (sc.nextLine().trim().equals("22")) score++;

            System.out.println("2️⃣ What keyword creates a class?");
            System.out.print("> ");
            if (sc.nextLine().trim().equalsIgnoreCase("class")) score++;

            System.out.println("3️⃣ Which symbol is used for single-line comments?");
            System.out.print("> ");
            if (sc.nextLine().trim().equals("//")) score++;
        }

        int bonusXP = score * 5;
        System.out.println("\n⭐ You got " + score + "/3 correct! Bonus XP: " + bonusXP);

        student.addPoints(bonusXP);
        System.out.println("🎉 " + student.getName() + " earned +" + bonusXP + " XP! Total: " + student.getPoints() + " XP");
    }
}
