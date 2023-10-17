package seedu.address.logic.commands.delivery;

import org.junit.jupiter.api.Test;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.testutil.TypicalDeliveries.getTypicalDeliveryBook;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

class DeliveryViewCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), getTypicalDeliveryBook(), new UserPrefs(), true);

    @Test
    public void execute_allFieldsValid_success() throws CommandException {
        DeliveryViewCommand deliveryViewCommand = new DeliveryViewCommand(1);

        String expectedMessage = String.format(DeliveryViewCommand.MESSAGE_SUCCESS, deliveryViewCommand.toString());

        assertEquals(expectedMessage, deliveryViewCommand.execute(model));
    }
}