package seedu.address.model.delivery;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class NoteTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Note(null));
    }

    @Test
    public void constructor_invalidName_throwsIllegalArgumentException() {
        String invalidName = "";
        assertThrows(IllegalArgumentException.class, () -> new Note(invalidName));
    }

    @Test
    public void isNotEmpty() {
        // null name
        assertThrows(NullPointerException.class, () -> Note.isNotEmpty(null));

        // invalid note
        assertFalse(Note.isNotEmpty("")); // empty string

        // valid name
        assertTrue(Note.isNotEmpty("peter jack")); // alphabets only
    }

    @Test
    public void equals() {
        Note note = new Note("Valid Name");

        // same values -> returns true
        assertTrue(note.equals(new Note("Valid Name")));

        // same object -> returns true
        assertTrue(note.equals(note));

        // null -> returns false
        assertFalse(note.equals(null));

        // different types -> returns false
        assertFalse(note.equals(5.0f));

        // different values -> returns false
        assertFalse(note.equals(new Note("Other Valid Name")));
    }
}
