package seedu.address.logic.commands.user;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalDeliveries.getTypicalDeliveryBook;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.user.Password;
import seedu.address.model.user.User;
import seedu.address.model.user.Username;

public class UserRecoverAccountCommandTest {

    @Test
    public void execute_noUserStored_throwsCommandException() {
        Model model = new ModelManager(getTypicalAddressBook(), getTypicalDeliveryBook(),
                new UserPrefs(), false);
        model.setLoggedInUser(null);
        UserRecoverAccountCommand userRecoverAccountCommand = new UserRecoverAccountCommand();

        assertCommandFailure(userRecoverAccountCommand, model, UserDeleteCommand.MESSAGE_NO_ACCOUNT);
    }

    @Test
    public void execute_nullModel_throwsNullPointerException() {
        UserRecoverAccountCommand userRecoverAccountCommand = new UserRecoverAccountCommand();
        assertThrows(NullPointerException.class, () -> userRecoverAccountCommand.execute(null));
    }

    @Test
    public void execute_userStored_success() {
        String answer = "answer";
        Password newPassword = new Password("newPassword");

        // set up model with user stored
        Model model = new ModelManager(getTypicalAddressBook(), getTypicalDeliveryBook(),
                new UserPrefs(), true);
        User user = new User(new Username("username"), new Password("password"),
                true, "secret question", answer);
        model.setLoggedInUser(user);

        UserRecoverAccountCommand userRecoverAccountCommand = new UserRecoverAccountCommand(answer, newPassword);

        // copy of model with user updated to new password
        ModelManager expectedModel = new ModelManager(model.getAddressBook(), model.getDeliveryBook(),
                new UserPrefs(), model.getUserLoginStatus());
        User newUser = new User(new Username("username"), newPassword,
                true, "secret question", answer);
        expectedModel.setLoggedInUser(newUser);

        assertCommandSuccess(userRecoverAccountCommand, model, UserRecoverAccountCommand.MESSAGE_SUCCESS_WITH_FLAGS,
                expectedModel, false);
    }

    @Test
    public void execute_userStoredWrongAnswer_throwsCommandException() {
        String answer = "answer";
        Password newPassword = new Password("newPassword");

        // set up model with user stored
        Model model = new ModelManager(getTypicalAddressBook(), getTypicalDeliveryBook(),
                new UserPrefs(), true);
        User user = new User(new Username("username"), new Password("password"),
                true, "secret question", answer);
        model.setLoggedInUser(user);

        UserRecoverAccountCommand userRecoverAccountCommand =
                new UserRecoverAccountCommand("wrong answer", newPassword);

        assertCommandFailure(userRecoverAccountCommand, model, UserRecoverAccountCommand.MESSAGE_WRONG_ANSWER);
    }

    @Test
    public void execute_showSecretQuestion_success() {
        // set up model with user stored
        Model model = new ModelManager(getTypicalAddressBook(), getTypicalDeliveryBook(),
                new UserPrefs(), true);
        User user = new User(new Username("username"), new Password("password"),
                true, "secret question", "answer");
        model.setLoggedInUser(user);

        UserRecoverAccountCommand userRecoverAccountCommand = new UserRecoverAccountCommand();
        String desiredOutput =
                String.format(UserRecoverAccountCommand.MESSAGE_SUCCESS_WITHOUT_FLAGS, user.getSecretQuestion());
        desiredOutput += "\n" + "Please answer the question using the following command: "
                + UserRecoverAccountCommand.MESSAGE_USAGE;

        assertCommandSuccess(userRecoverAccountCommand, model,
                desiredOutput, model, false);
    }

    @Test
    public void equals() {
        String answer = "answer";
        Password newPassword = new Password("newPassword");
        UserRecoverAccountCommand userRecoverAccountCommand = new UserRecoverAccountCommand(answer, newPassword);

        // same object -> returns true
        assert (userRecoverAccountCommand.equals(userRecoverAccountCommand));

        // same values -> returns true
        UserRecoverAccountCommand userRecoverAccountCommandCopy = new UserRecoverAccountCommand(answer, newPassword);
        assert (userRecoverAccountCommand.equals(userRecoverAccountCommandCopy));

        // different types -> returns false
        assert (!userRecoverAccountCommand.equals(1));

        // null -> returns false
        assert (!userRecoverAccountCommand.equals(null));

        // different answer -> returns false
        UserRecoverAccountCommand userRecoverAccountCommandDifferentAnswer =
                new UserRecoverAccountCommand("different answer", newPassword);
        assert (!userRecoverAccountCommand.equals(userRecoverAccountCommandDifferentAnswer));

        // different password -> returns false
        UserRecoverAccountCommand userRecoverAccountCommandDifferentPassword =
                new UserRecoverAccountCommand(answer, new Password("differentPassword"));
        assert (!userRecoverAccountCommand.equals(userRecoverAccountCommandDifferentPassword));

        // different showSecretQuestion -> returns false
        UserRecoverAccountCommand userRecoverAccountCommandDifferentShowSecretQuestion =
                new UserRecoverAccountCommand();
        assert (!userRecoverAccountCommand.equals(userRecoverAccountCommandDifferentShowSecretQuestion));
    }

}
