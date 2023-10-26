package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    public void getStoredUser_noUserStored_returnsNull() {
        // assume authentication file is empty
        UserPrefs userPrefs = new UserPrefs();
        userPrefs.setAuthenticationPath(Paths.get("data", ""));
        assertTrue(userPrefs.getStoredUser() == null);
    }

    @Test
    public void getStoredUser_validUserStored_returnsUser() {
        UserPrefs userPrefs = new UserPrefs();
        Username username = new Username("gab");
        Password password = new Password("password");
        String secretQuestion = "Your first pet's name?";
        String answer = "koko";
        User user = new User(username, password, true, secretQuestion, answer);
        userPrefs.setAuthenticationPath(Paths.get("src/test/data/Authentication", "authentication.json"));

        try {
            User storedUser = userPrefs.getStoredUser();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        assertTrue(userPrefs.getStoredUser() != null);
    }

    @Test
    public void registerUser_nullUser_throwsNullPointerException() {
        UserPrefs userPrefs = new UserPrefs();
        assertThrows(NullPointerException.class, () -> userPrefs.registerUser(null));
    }

    @Test
    public void registerUser_validUser_success() {
        UserPrefs userPrefs = new UserPrefs();
        Username username = new Username("gab");
        Password password = new Password("password");
        String secretQuestion = "Your first pet's name?";
        String answer = "koko";
        User user = new User(username, password, true, secretQuestion, answer);
        userPrefs.setAuthenticationPath(Paths.get("src/test/data/Authentication", "authentication.json"));
        assertTrue(userPrefs.registerUser(user));
        assertEquals(userPrefs.getStoredUser(), user);
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

    @Test
    public void getAuthenticationFilePath() {
        UserPrefs userPrefs = new UserPrefs();
        userPrefs.setAuthenticationPath(Paths.get("data", "authentication.json"));
        assertTrue(userPrefs.getAuthenticationPath().equals(Paths.get("data", "authentication.json")));
    }

    @Test
    public void deleteUser_noFilesFound_noExceptionThrown() {
        UserPrefs userPrefs = new UserPrefs();
        userPrefs.setAuthenticationPath(Paths.get("data", ""));
        userPrefs.deleteUser();
    }

}
