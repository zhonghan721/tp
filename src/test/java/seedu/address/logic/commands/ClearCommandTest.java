package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalDeliveries.getTypicalDeliveryBook;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.model.*;

public class ClearCommandTest {

    @Test
    public void execute_emptyAddressBook_success() {
        Model model = new ModelManager();
        Model expectedModel = new ModelManager();

        model.setLoginSuccess();
        expectedModel.setLoginSuccess();

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel, true);
    }

    @Test
    public void execute_nonEmptyAddressBook_success() {
        Model model = new ModelManager(getTypicalAddressBook(), getTypicalDeliveryBook(),
                new UserPrefs(), true);
        Model expectedModel = new ModelManager(getTypicalAddressBook(), getTypicalDeliveryBook(),
                new UserPrefs(), true);
        expectedModel.setAddressBook(new AddressBook());
        expectedModel.setDeliveryBook(new DeliveryBook());

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel, true);
    }

    @Test
    public void execute_emptyAddressBookLoggedOut_failure() {
        Model model = new ModelManager();
        model.setLogoutSuccess();

        assertCommandFailure(new ClearCommand(), model, Messages.MESSAGE_USER_NOT_AUTHENTICATED);
    }

    @Test
    public void execute_nonEmptyAddressBookLoggedOut_failure() {
        Model model = new ModelManager(getTypicalAddressBook(), getTypicalDeliveryBook(),
                new UserPrefs(), false);

        assertCommandFailure(new ClearCommand(), model, Messages.MESSAGE_USER_NOT_AUTHENTICATED);
    }

}
