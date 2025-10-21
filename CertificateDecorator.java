public class CertificateDecorator extends CourseDecorator {
    public CertificateDecorator(Course wrapped) {
        super(wrapped);
    }

    @Override
    public String getTitle() {
        return wrapped.getTitle() + " + Certificate";
    }

    @Override
    public String deliverContent() {
        return wrapped.deliverContent() + " [Certificate available]";
    }
}
