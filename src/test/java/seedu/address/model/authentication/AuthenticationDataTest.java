package seedu.address.model.authentication;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AuthenticationDataTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AuthenticationData(null, null));
    }

    @Test
    public void constructor_invalidUsername_throwsIllegalArgumentException() {
        String invalidUsername = null;
        assertThrows(NullPointerException.class, () -> new AuthenticationData(invalidUsername, null));
    }

    @Test
    public void constructor_invalidPassword_throwsIllegalArgumentException() {
        String invalidPassword = null;
        assertThrows(NullPointerException.class, () -> new AuthenticationData(null, invalidPassword));
    }
}
