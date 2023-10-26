package seedu.address.logic.commands.user;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalDeliveries.getTypicalDeliveryBook;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.user.Password;
import seedu.address.model.user.User;
import seedu.address.model.user.Username;

public class UserDeleteCommandTest {

    @Test
    public void execute_nullModel_throwsNullPointerException() {
        User user = new User(new Username("username"), new Password("password"), false);
        assertThrows(NullPointerException.class, () -> new UserDeleteCommand().execute(null));
    }

    @Test
    // test when storedUser is null
    public void execute_storedUserDoesNotExist_throwsCommandException() {
        Model model = new ModelManager(getTypicalAddressBook(), getTypicalDeliveryBook(),
                new UserPrefs(), false);
        UserDeleteCommand userDeleteCommand = new UserDeleteCommand();

        assertCommandFailure(userDeleteCommand, model, UserDeleteCommand.MESSAGE_NO_ACCOUNT);
    }

    @Test
    // test success
    public void execute_storedUserExists_success() {
        // Create a Model with an initial state where the user is not logged in and
        // there's no stored user.
        Model model = new ModelManager(getTypicalAddressBook(), getTypicalDeliveryBook(),
                new UserPrefs(), false);
        User user = new User(new Username("username"), new Password("password"), false);
        model.setLoggedInUser(user);

        UserDeleteCommand userDeleteCommand = new UserDeleteCommand();

        ModelManager expectedModel = new ModelManager(model.getAddressBook(), model.getDeliveryBook(),
                new UserPrefs(), false);
        expectedModel.deleteUser();

        assertCommandSuccess(userDeleteCommand, model, UserDeleteCommand.MESSAGE_SUCCESS, expectedModel, true);
    }

}
