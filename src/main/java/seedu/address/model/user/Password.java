package seedu.address.model.user;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class Password {


    public static final String MESSAGE_CONSTRAINTS =
            "Password should only contain alphanumeric characters, at least 8 characters, and it should not be blank";

    /*
     * The first character of the password must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "^[\\p{Alnum}]{8,}$";

    public final String password;

    /**
     * Constructs a {@code Password}.
     *
     * @param password A valid password.
     */
    public Password(String password) {
        requireNonNull(password);
        checkArgument(isValidPassword(password), MESSAGE_CONSTRAINTS);
        this.password = password;
    }

    /**
     * Returns true if a given string is a valid password.
     */
    public static boolean isValidPassword(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return password;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Password)) {
            return false;
        }

        Password otherPassword = (Password) other;
        return password.equals(otherPassword.password);
    }

    @Override
    public int hashCode() {
        return password.hashCode();
    }
}
