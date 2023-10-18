package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import seedu.address.model.user.Password;
import seedu.address.model.user.User;
import seedu.address.model.user.Username;

public class UserPrefsTest {

    @Test
    public void setGuiSettings_nullGuiSettings_throwsNullPointerException() {
        UserPrefs userPref = new UserPrefs();
        assertThrows(NullPointerException.class, () -> userPref.setGuiSettings(null));
    }

    @Test
    public void setAddressBookFilePath_nullPath_throwsNullPointerException() {
        UserPrefs userPrefs = new UserPrefs();
        assertThrows(NullPointerException.class, () -> userPrefs.setAddressBookFilePath(null));
    }

    @Test
    public void setAuthenticationPath_nullPath_throwsNullPointerException() {
        UserPrefs userPrefs = new UserPrefs();
        assertThrows(NullPointerException.class, () -> userPrefs.setAuthenticationPath(null));
    }

    @Test
    public void readFileAsString_invalidFilePath_throwsException() {
        assertThrows(Exception.class, () -> UserPrefs.readFileAsString("invalidFilePath"));
    }

    @Test
    // test different cases
    public void userMatches_nullUser_throwsNullPointerException() {
        UserPrefs userPrefs = new UserPrefs();

        assertThrows(NullPointerException.class, () -> userPrefs.userMatches(null));
    }

    @Test
    public void userMatches_differentUser_returnsFalse() {
        UserPrefs userPrefs = new UserPrefs();
        userPrefs.registerUser(new User(new Username("username1"), new Password("password1"), false));
        Username username = new Username("username2");
        Password password = new Password("password2");
        User user = new User(username, password, true);
        assertFalse(userPrefs.userMatches(user));
    }

    @Test
    public void getStoredUser_nullUser_returnsNull() {
        // assume authentication file is empty
        UserPrefs userPrefs = new UserPrefs();
        userPrefs.setAuthenticationPath(Paths.get("data", ""));
        assertTrue(userPrefs.getStoredUser() == null);
    }

    @Test
    public void registerUser_nullUser_throwsNullPointerException() {
        UserPrefs userPrefs = new UserPrefs();
        assertThrows(NullPointerException.class, () -> userPrefs.registerUser(null));
    }

    @Test
    public void registerUser_validUser_returnsTrue() {
        UserPrefs userPrefs = new UserPrefs();
        Username username = new Username("username");
        Password password = new Password("password");
        User user = new User(username, password, true);
        assertTrue(userPrefs.registerUser(user));
    }

    @Test
    public void equals_sameObject_returnsTrue() {
        UserPrefs userPrefs = new UserPrefs();

        // same object -> returns true
        assertTrue(userPrefs.equals(userPrefs));
    }

    @Test
    public void equals_differentObject_returnsFalse() {
        UserPrefs userPrefs = new UserPrefs();

        // null -> returns false
        assertFalse(userPrefs.equals(null));

        // different types -> returns false
        assertFalse(userPrefs.equals(5));

        // different addressBookFilePath -> returns false
        UserPrefs differentUserPrefs = new UserPrefs();
        differentUserPrefs.setAddressBookFilePath(Paths.get("differentFilePath"));
        assertFalse(userPrefs.equals(differentUserPrefs));

        // different authenticationPath -> returns false
        differentUserPrefs = new UserPrefs();
        differentUserPrefs.setAuthenticationPath(Paths.get("differentFilePath"));
        assertFalse(userPrefs.equals(differentUserPrefs));
    }

    @Test
    public void hashCode_sameHashCode_returnsTrue() {
        UserPrefs userPrefs = new UserPrefs();
        assertTrue(userPrefs.hashCode() == userPrefs.hashCode());
    }

    @Test
    public void hashCode_differentHashCode_returnsFalse() {
        UserPrefs userPrefs = new UserPrefs();
        UserPrefs differentUserPrefs = new UserPrefs();
        differentUserPrefs.setAddressBookFilePath(Paths.get("differentFilePath"));
        assertFalse(userPrefs.hashCode() == differentUserPrefs.hashCode());
    }

}
