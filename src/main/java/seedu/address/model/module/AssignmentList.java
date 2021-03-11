package seedu.address.model.module;

import java.util.ArrayList;

public class AssignmentList {
    private ArrayList<Assignment> assignments;

    /**
     * Constructs an {@code AssignmentList} to store {@code Assignments}
     */
    public AssignmentList() {
        this.assignments = new ArrayList<>();
    }

    /**
     * Get the assignment at the index from the list.
     *
     * @param index Index of the assignment.
     * @return Assignment at index.
     */
    public Assignment get(int index) {
        return assignments.get(index);
    }

    /**
     * Gets the index of the {@code assignment} in the assignment list.
     * {@code assignment} must exist in the assignment list.
     */
    public int getIndex(Assignment assignment) {
        int index = -1;
        for (int i = 0; i < assignments.size(); i++) {
            if (assignments.get(i).equals(assignment)) {
                index = i;
            }
        }
        return index;
    }

    /**
     * Adds an assignment to the list.
     *
     * @param assignment Assignment to be added.
     */
    public void add(Assignment assignment) {
        assignments.add(assignment);
    }

    /**
     * Removes the assignment at the index from the list.
     *
     * @param index Index of assignment to be removed.
     * @return Removed assignment.
     */
    public Assignment delete(int index) {
        Assignment deleted = assignments.remove(index);
        return deleted;
    }

    /**
     * Delete the {@code assignment} from assignment list.
     * {@code assignment} must exist in the assignment list.
     */
    public Assignment delete(Assignment assignment) {
        int index = getIndex(assignment);
        return delete(index);
    }

    /**
     * Checks if the assignment list contains the given assignment.
     *
     * @param assignment Assignment to check.
     * @return Boolean.
     */
    public boolean contains(Assignment assignment) {
        boolean hasAssignment = false;
        for (int i = 0; i < assignments.size() && !hasAssignment; i++) {
            if (assignments.get(i).equals(assignment)) {
                hasAssignment = true;
            }
        }
        return hasAssignment;
    }

    /**
     * Gets the size of the list.
     *
     * @return List size.
     */
    public int size() {
        return assignments.size();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            builder.append(i + 1).append(". ")
                    .append(get(i)).append("\n");
        }
        return builder.toString();
    }
}
