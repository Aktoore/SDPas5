public abstract class CourseDecorator implements Course {
    protected Course wrapped;

    public CourseDecorator(Course wrapped) {
        this.wrapped = wrapped;
    }

    public Course getWrapped() {
        return wrapped;
    }

    public Course getBaseCourse() {
        if (wrapped instanceof CourseDecorator decorator) {
            return decorator.getBaseCourse();
        }
        return wrapped;
    }

    @Override
    public String getName() {
        return wrapped.getName();
    }

    @Override
    public String getTitle() {
        return wrapped.getTitle();
    }

    @Override
    public String deliverContent() {
        return wrapped.deliverContent();
    }
}
