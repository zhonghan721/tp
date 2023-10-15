package seedu.address.model.delivery;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Delivery's note in the delivery list.
 */
public class Note {

    public static final String MESSAGE_CONSTRAINTS =
        "Note should not be empty";
    public final String note;

    /**
     * Constructs a {@code Note}.
     *
     * @param note A valid note.
     */
    public Note(String note) {
        requireNonNull(note);
        checkArgument(isNotEmpty(note), MESSAGE_CONSTRAINTS);
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String toString() {
        return note;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof Note // instanceof handles nulls
            && note.equals(((Note) other).note)); // state check
    }

    public static boolean isNotEmpty(String test) {
        return !test.isEmpty();
    }
}
