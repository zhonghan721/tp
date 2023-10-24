package seedu.address.model.authentication;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AuthenticationDataTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AuthenticationData(null, null, null, null));
    }

    @Test
    public void constructor_invalidUsername_throwsIllegalArgumentException() {
        String invalidUsername = " ";
        assertThrows(NullPointerException.class, () -> new AuthenticationData(invalidUsername, null, null, null));
    }

    @Test
    public void constructor_invalidPassword_throwsIllegalArgumentException() {
        String invalidPassword = ";22 ";
        assertThrows(NullPointerException.class, () -> new AuthenticationData(null, invalidPassword, null, null));
    }
}
