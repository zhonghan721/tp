package seedu.address.logic.commands.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalDeliveries.getTypicalDeliveryBook;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.user.Password;
import seedu.address.model.user.User;
import seedu.address.model.user.Username;

public class UserRegisterCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), getTypicalDeliveryBook(),
            new UserPrefs(), false);
    private Model expectedModel = new ModelManager(getTypicalAddressBook(), getTypicalDeliveryBook(),
            new UserPrefs(), false);

    @Test
    public void execute_nullModel_throwsNullPointerException() {
        User user = new User(new Username("username"), new Password("password"), false);
        assertThrows(NullPointerException.class, () -> new UserRegisterCommand(user).execute(null));
    }

    @Test
    // // Logged in user cannot register
    // if (model.getUserLoginStatus()) {
    // throw new CommandException(MESSAGE_ALREADY_HAVE_ACCOUNT);
    // }
    public void execute_userAlreadyLoggedIn_throwsCommandException() {
        User user = new User(new Username("username"), new Password("password"), false);
        model.setLoginSuccess();
        UserRegisterCommand userRegisterCommand = new UserRegisterCommand(user);
        // catch the exception thrown when executing command
        // Use assertThrows to catch the exception and verify its message
        CommandException exception = assertThrows(CommandException.class, () -> userRegisterCommand.execute(model));

        // Verify the exception message
        assertEquals(String.format(UserRegisterCommand.MESSAGE_ALREADY_HAVE_ACCOUNT, user.getUsername()),
                exception.getMessage());
    }

    @Test
    public void execute_storedUserExists_throwsCommandException() {
        User user = new User(new Username("username"), new Password("password"), false);
        model.registerUser(user);
        UserRegisterCommand userRegisterCommand = new UserRegisterCommand(user);
        // catch the exception thrown when executing command
        // Use assertThrows to catch the exception and verify its message
        CommandException exception = assertThrows(CommandException.class, () -> userRegisterCommand.execute(model));

        // Verify the exception message
        assertEquals(String.format(UserRegisterCommand.MESSAGE_ALREADY_HAVE_ACCOUNT, user.getUsername()),
                exception.getMessage());
    }

    @Test // expect success when storedUser is null
    public void execute_storedUserDoesNotExist_success() {
        // Create a Model with an initial state where the user is not logged in and
        // there's no stored user.
        Model model = new ModelManager(getTypicalAddressBook(), getTypicalDeliveryBook(),
                new UserPrefs(), false);

        // Create a User instance that you want to register
        User user = new User(new Username("username"), new Password("password"), false);

        // Create the UserRegisterCommand with the user
        UserRegisterCommand userRegisterCommand = new UserRegisterCommand(user);

        // Execute the command
        CommandResult result;

        try {
            result = userRegisterCommand.execute(model, true);
        } catch (CommandException e) {
            throw new AssertionError("Execution of command should not fail.", e);
        }

        // Assert that the result indicates success
        assertEquals(UserRegisterCommand.MESSAGE_SUCCESS, result.getFeedbackToUser());
    }

    @Test
    public void equals() {
        User user = new User(new Username("username"), new Password("password"), false);
        UserRegisterCommand userRegisterCommand = new UserRegisterCommand(user);

        // same object -> returns true
        assertTrue(userRegisterCommand.equals(userRegisterCommand));

        // same values -> returns true
        UserRegisterCommand userRegisterCommandCopy = new UserRegisterCommand(user);
        assertTrue(userRegisterCommand.equals(userRegisterCommandCopy));

        // different types -> returns false
        assertFalse(userRegisterCommand.equals(1));

        // null -> returns false
        assertFalse(userRegisterCommand.equals(null));

        // different person -> returns false
        User user2 = new User(new Username("username2"), new Password("password2"), false);
        UserRegisterCommand userRegisterCommand2 = new UserRegisterCommand(user2);
        assertFalse(userRegisterCommand.equals(userRegisterCommand2));
    }
}
