package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_PASSWORD_AARON;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PASSWORD_FOODBEAR;
import static seedu.address.logic.commands.CommandTestUtil.VALID_USERNAME_AARON;
import static seedu.address.logic.commands.CommandTestUtil.VALID_USERNAME_FOODBEAR;

import seedu.address.model.user.User;

/**
 * A utility class containing a list of {@code User} objects to be used in tests.
 */
public class TypicalUsers {

    public static final User ANDY = new UserBuilder().withUsername("andy").withPassword("abcd1234").build();
    public static final User CARL = new UserBuilder().withUsername("car1").withPassword("1234ABcd").build();

    // Manually added
    public static final User AARON = new UserBuilder().withUsername(VALID_USERNAME_AARON)
            .withPassword(VALID_PASSWORD_AARON).build();

    public static final User FOODBEAR = new UserBuilder().withUsername(VALID_USERNAME_FOODBEAR)
            .withPassword(VALID_PASSWORD_FOODBEAR).build();

    private TypicalUsers() {
    } // prevents instantiation
}
