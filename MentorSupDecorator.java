public class MentorSupDecorator extends CourseDecorator {
    public MentorSupDecorator(Course wrapped) {
        super(wrapped);
    }

    @Override
    public String getTitle() {
        return wrapped.getTitle() + " + Mentor Support";
    }

    @Override
    public String deliverContent() {
        return wrapped.deliverContent() + " [Includes personal mentor support sessions]";
    }

}
