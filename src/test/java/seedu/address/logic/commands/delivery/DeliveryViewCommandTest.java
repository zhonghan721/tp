package seedu.address.logic.commands.delivery;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalDeliveries.getTypicalDeliveryBook;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.delivery.Delivery;

class DeliveryViewCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), getTypicalDeliveryBook(), new UserPrefs(), true);

    @Test
    public void execute_allFieldsValid_success() throws CommandException {
        DeliveryViewCommand deliveryViewCommand = new DeliveryViewCommand(1);
        Optional<Delivery> delivery = model.getDelivery(1);
        String expectedMessage = Messages.format(delivery.get());

        assertCommandSuccess(deliveryViewCommand, model, expectedMessage, model);
    }

    @Test
    public void execute_invalidTargetId_throwsCommandException() {
        DeliveryViewCommand deliveryViewCommand = new DeliveryViewCommand(-1);
        assertCommandFailure(deliveryViewCommand, model, Messages.MESSAGE_INVALID_DELIVERY_ID);
    }
}
