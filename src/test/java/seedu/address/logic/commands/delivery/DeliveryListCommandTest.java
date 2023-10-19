package seedu.address.logic.commands.delivery;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandListSuccess;
import static seedu.address.testutil.TypicalDeliveries.getTypicalDeliveryBook;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.logic.Sort;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.delivery.DeliveryStatus;

public class DeliveryListCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), getTypicalDeliveryBook(), new UserPrefs(), true);

    @Test
    public void execute_listIsNotFiltered_showsSameList() {
        assertCommandListSuccess(new DeliveryListCommand(null), model, DeliveryListCommand.MESSAGE_SUCCESS, model);
    }

    @Test
    public void execute_listIsFiltered_showsEverything() {
        assertCommandListSuccess(new DeliveryListCommand(DeliveryStatus.CREATED), model,
            DeliveryListCommand.MESSAGE_SUCCESS, model);
        assertCommandListSuccess(new DeliveryListCommand(DeliveryStatus.SHIPPED), model,
            DeliveryListCommand.MESSAGE_SUCCESS, model);
        assertCommandListSuccess(new DeliveryListCommand(DeliveryStatus.COMPLETED), model,
            DeliveryListCommand.MESSAGE_SUCCESS,
            model);
        assertCommandListSuccess(new DeliveryListCommand(DeliveryStatus.CANCELLED), model,
            DeliveryListCommand.MESSAGE_SUCCESS, model);
    }

    @Test
    public void execute_listIsFilteredAndSortedAscending_showsSameList() {
        assertCommandListSuccess(new DeliveryListCommand(DeliveryStatus.CREATED, Sort.ASC), model,
            DeliveryListCommand.MESSAGE_SUCCESS, model);
        assertCommandListSuccess(new DeliveryListCommand(DeliveryStatus.SHIPPED, Sort.ASC), model,
            DeliveryListCommand.MESSAGE_SUCCESS, model);
        assertCommandListSuccess(new DeliveryListCommand(DeliveryStatus.COMPLETED, Sort.ASC), model,
            DeliveryListCommand.MESSAGE_SUCCESS,
            model);
        assertCommandListSuccess(new DeliveryListCommand(DeliveryStatus.CANCELLED, Sort.ASC), model,
            DeliveryListCommand.MESSAGE_SUCCESS, model);
    }

    @Test
    public void execute_listIsSortedAscending_showsSameList() {
        assertCommandListSuccess(new DeliveryListCommand(null, Sort.ASC), model, DeliveryListCommand.MESSAGE_SUCCESS,
            model);
    }

    @Test
    public void execute_listIsSortedDescending_showsSameList() {
        assertCommandListSuccess(new DeliveryListCommand(null, Sort.DESC), model, DeliveryListCommand.MESSAGE_SUCCESS,
            model);
    }

    @Test
    public void execute_listIsNotFilteredLoggedOut_throwsCommandException() {
        model.setLogoutSuccess();
        assertCommandFailure(new DeliveryListCommand(null), model, Messages.MESSAGE_USER_NOT_AUTHENTICATED);
    }

    @Test
    public void execute_listIsFilteredLoggedOut_throwsCommandException() {
        model.setLogoutSuccess();
        assertCommandFailure(new DeliveryListCommand(DeliveryStatus.CREATED), model,
                Messages.MESSAGE_USER_NOT_AUTHENTICATED);
        assertCommandFailure(new DeliveryListCommand(DeliveryStatus.SHIPPED), model,
                Messages.MESSAGE_USER_NOT_AUTHENTICATED);
        assertCommandFailure(new DeliveryListCommand(DeliveryStatus.COMPLETED), model,
                Messages.MESSAGE_USER_NOT_AUTHENTICATED);
        assertCommandFailure(new DeliveryListCommand(DeliveryStatus.CANCELLED), model,
                Messages.MESSAGE_USER_NOT_AUTHENTICATED);
    }

    @Test
    public void execute_listIsFilteredAndSortedAscendingLoggedOut_throwsCommandException() {
        model.setLogoutSuccess();
        assertCommandFailure(new DeliveryListCommand(DeliveryStatus.CREATED, Sort.ASC), model,
                Messages.MESSAGE_USER_NOT_AUTHENTICATED);
        assertCommandFailure(new DeliveryListCommand(DeliveryStatus.SHIPPED, Sort.ASC), model,
                Messages.MESSAGE_USER_NOT_AUTHENTICATED);
        assertCommandFailure(new DeliveryListCommand(DeliveryStatus.COMPLETED, Sort.ASC), model,
                Messages.MESSAGE_USER_NOT_AUTHENTICATED);
        assertCommandFailure(new DeliveryListCommand(DeliveryStatus.CANCELLED, Sort.ASC), model,
                Messages.MESSAGE_USER_NOT_AUTHENTICATED);
    }

    @Test
    public void execute_listIsSortedAscendingLoggedOut_throwsCommandException() {
        model.setLogoutSuccess();
        assertCommandFailure(new DeliveryListCommand(null, Sort.ASC), model,
                Messages.MESSAGE_USER_NOT_AUTHENTICATED);
    }

    @Test
    public void execute_listIsSortedDescendingLoggedOut_throwsCommandException() {
        model.setLogoutSuccess();
        assertCommandFailure(new DeliveryListCommand(null, Sort.DESC), model,
                Messages.MESSAGE_USER_NOT_AUTHENTICATED);
    }

    @Test
    public void equals() {
        DeliveryListCommand deliveryListCommand = new DeliveryListCommand(null);
        DeliveryListCommand deliveryListCommand1 = new DeliveryListCommand(DeliveryStatus.CREATED);
        DeliveryListCommand deliveryListCommand2 = new DeliveryListCommand(DeliveryStatus.CREATED, Sort.ASC);
        DeliveryListCommand deliveryListCommand3 = new DeliveryListCommand(DeliveryStatus.CREATED, Sort.DESC);
        DeliveryListCommand deliveryListCommand4 = new DeliveryListCommand(DeliveryStatus.COMPLETED, Sort.ASC);

        // same object -> returns true
        assertTrue(deliveryListCommand.equals(deliveryListCommand));

        // same values -> returns true
        DeliveryListCommand deliveryListCommandCopy = new DeliveryListCommand(null);
        assertTrue(deliveryListCommand.equals(deliveryListCommandCopy));

        // different types -> returns false
        assertFalse(deliveryListCommand.equals(1));

        // null -> returns false
        assertFalse(deliveryListCommand.equals(null));

        // different delivery status -> returns false
        assertFalse(deliveryListCommand.equals(deliveryListCommand1));

        // different sort -> returns false
        assertTrue(deliveryListCommand1.equals(deliveryListCommand2));
        assertFalse(deliveryListCommand1.equals(deliveryListCommand3));
        assertFalse(deliveryListCommand1.equals(deliveryListCommand4));
    }
}
