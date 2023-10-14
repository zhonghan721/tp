package seedu.address.testutil;

import seedu.address.model.user.Password;
import seedu.address.model.user.User;
import seedu.address.model.user.Username;

public class UserBuilder {
    public static final String DEFAULT_USERNAME = "validUsername";
    public static final String DEFAULT_PASSWORD = "Pa55word";
    private Username username;
    private Password password;

    /**
     * Creates a {@code UserBuilder} with the default details.
     */
    public UserBuilder() {
        username = new Username(DEFAULT_USERNAME);
        password = new Password(DEFAULT_PASSWORD);
    }

    /**
     * Initializes the UserBuilder with the data of {@code User}.
     */
    public UserBuilder(User userToCopy) {
        username = userToCopy.getUsername();
        password = userToCopy.getPassword();
    }

    /**
     * Sets the {@code Username} of the {@code User} that we are building.
     */
    public UserBuilder withUsername(String username) {
        this.username = new Username(username);
        return this;
    }

    /**
     * Sets the {@code Password} of the {@code User} that we are building.
     */
    public UserBuilder withPassword(String password) {
        this.password = new Password(password);
        return this;
    }

    /**
     * Builds the {@code User} with the given parameters.
     *
     * @return The User with the given parameters.
     */
    public User build() {
        return new User(username, password);
    }
}
