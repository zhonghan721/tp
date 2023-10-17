package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalDeliveries.getTypicalDeliveryBook;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.logic.commands.customer.AddCommand;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Customer;
import seedu.address.testutil.PersonBuilder;

/**
 * Contains integration tests (interaction with the Model) for {@code AddCommand}.
 */
public class AddCommandIntegrationTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), getTypicalDeliveryBook(), new UserPrefs(), true);
    }

    @Test
    public void execute_newPerson_success() {
        Customer validCustomer = new PersonBuilder().build();

        Model expectedModel = new ModelManager(model.getAddressBook(), model.getDeliveryBook(),
                new UserPrefs(), model.getUserLoginStatus());
        expectedModel.addPerson(validCustomer);

        assertCommandSuccess(new AddCommand(validCustomer), model,
                String.format(AddCommand.MESSAGE_SUCCESS, Messages.format(validCustomer)),
                expectedModel);
    }

    @Test
    public void execute_duplicatePerson_throwsCommandException() {
        Customer customerInList = model.getAddressBook().getList().get(0);
        assertCommandFailure(new AddCommand(customerInList), model,
                AddCommand.MESSAGE_DUPLICATE_PERSON);
    }

}
