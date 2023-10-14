package seedu.address.model.user;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Represents a User in the address book.
 */
public class User {

    // Identity fields
    private final Username username;
    private final Password password;

    /**
     * Every field must be present and not null.
     */
    public User(Username username, Password password) {
        requireAllNonNull(username, password);
        this.username = username;
        this.password = password;
    }

    public Username getUsername() {
        return username;
    }

    public Password getPassword() {
        return password;
    }

    /**
     * Returns true if both persons have the same username.
     */
    public boolean isSameUser(User otherUser) {
        if (otherUser == this) {
            return true;
        }

        return otherUser != null
            && otherUser.getUsername().equals(getUsername());
    }

    /**
     * Returns true if both users have the same username and password.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof User)) {
            return false;
        }

        User otherUser = (User) other;
        return username.equals(otherUser.username)
            && password.equals(otherUser.password);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(username, password);
    }

    @Override
    public String toString() {
        // does not show password for security reason
        return new ToStringBuilder(this)
            .add("userName", username)
            .toString();
    }

}
