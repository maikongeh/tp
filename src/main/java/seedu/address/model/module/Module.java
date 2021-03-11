package seedu.address.model.module;

import java.util.Objects;

public class Module implements Comparable<Module> {
    private Title title;
    private AssignmentList assignments;
    private ExamList exams;

    /**
     * Constructs a {@code Module} with {@code Title} as the input representing the module title.
     */
    public Module(Title title) {
        this.title = title;
        this.assignments = new AssignmentList();
        this.exams = new ExamList();
    }

    /**
     * Gets the title of the module.
     *
     * @return Module title.
     */
    public Title getTitle() {
        return title;
    }

    /**
     * Gets the assignment list in the module.
     *
     * @return List of module assignments.
     */
    public AssignmentList getAssignments() {
        return assignments;
    }

    /**
     * Gets the assignment at the specified index.
     *
     * @param index Index of assignment.
     * @return Assignment at index.
     */
    public Assignment getAssignment(int index) {
        return assignments.get(index);
    }

    /**
     * Gets the exams of the module.
     *
     * @return List of module exams.
     */
    public ExamList getExams() {
        return exams;
    }

    /**
     * Gets {@code exam} at specific index.
     *
     * @param index index of the examList.
     * @return {@code exam} at index.
     */
    public Exam getExamAt(int index) {
        return exams.getExamAt(index);
    }

    /**
     * Checks if the module has the given assignment in its assignment list.
     *
     * @param assignment Assignment to be checked.
     * @return Boolean
     */
    public boolean hasAssignment(Assignment assignment) {
        return assignments.contains(assignment);
    }

    /**
     * Checks if the module has the given exam in its exam list.
     *
     * @param exam Exam to be checked.
     * @return Boolean
     */
    public boolean hasExam(Exam exam) {
        return exams.contains(exam);
    }

    /**
     * Adds an assignment to the assignment list of the module.
     *
     * @param assignment Assignment to be added.
     */
    public void addAssignment(Assignment assignment) {
        this.assignments.add(assignment);
    }

    /**
     * Adds an exam to the exam list of the module.
     *
     * @param exam Exam to be added.
     */
    public void addExam(Exam exam) {
        this.exams.add(exam);
    }

    /**
     * Delete {@code assignment} from {@code assignments}
     * {@code assignment} must exist in {@code assignments}
     */
    public Assignment deleteAssignment(Assignment assignment) {
        return assignments.delete(assignment);
    }

    /**
     * Delete {@code assignment} from {@code assignments}
     * {@code assignment} must exist in {@code assignments}
     */
    public Exam deleteExam(Exam exam) {
        return exams.delete(exam);
    }

    /**
     * Returns true if both modules have the same title.
     * This defines a weaker notion of equality between two modules.
     * todo Remove if this is useless.
     */
    public boolean isSameModule(Module otherModule) {
        if (otherModule == this) {
            return true;
        }

        return otherModule != null
                && otherModule.getTitle().equals(getTitle());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Module)) {
            return false;
        }

        Module otherModule = (Module) other;
        return otherModule.getTitle().equals(getTitle())
                && otherModule.getAssignments().equals(getAssignments())
                && otherModule.getExams().equals(getExams());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(title, assignments, exams);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getTitle())
                .append(";\nAssignments: ")
                .append(getAssignments())
                .append("\n")
                //.append("; Exam Date: ")
                .append(getExams());

        return builder.toString();
    }

    @Override
    public int compareTo(Module o) {
        return title.compareTo(o.title);
    }
}
