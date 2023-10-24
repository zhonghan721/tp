package seedu.address.logic.commands.delivery;


import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.customer.CustomerEditCommand;
import seedu.address.logic.commands.delivery.DeliveryEditCommand;
import seedu.address.logic.commands.delivery.DeliveryEditCommand.DeliveryEditDescriptor;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.*;
import seedu.address.model.delivery.Delivery;
import seedu.address.model.person.Customer;

import seedu.address.testutil.*;


import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.logic.commands.CommandTestUtil.*;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalDeliveries.getTypicalDeliveryBook;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;


/**
 * Contains integration tests (interaction with the Model) and unit tests for EditCommand.
 */
public class DeliveryEditCommandTest {
    private Model modelLoggedIn = new ModelManager(getTypicalAddressBook(), getTypicalDeliveryBook(), new UserPrefs(),
            true);

    private Model modelLoggedOut = new ModelManager(getTypicalAddressBook(), getTypicalDeliveryBook(),
            new UserPrefs(),false);

    @Test
    public void constructor_nullDeliveryEditDescriptor_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new DeliveryEditCommand(null, null));
    }

    @Test
    public void execute_allFieldsSpecifiedUnfilteredList_success() {

        Customer editedCustomer = modelLoggedIn.getFilteredPersonList().get(0);
        Delivery editedDelivery =
                new DeliveryBuilder().withCustomer(editedCustomer).withOrderDate("2021-12-12").build();
        DeliveryEditDescriptor descriptor = new DeliveryEditDescriptorBuilder(editedDelivery).build();
        DeliveryEditCommand editCommand = new DeliveryEditCommand(INDEX_FIRST_PERSON, descriptor);

        String expectedMessage = String.format(DeliveryEditCommand.MESSAGE_EDIT_DELIVERY_SUCCESS,
                Messages.format(editedDelivery));

        Model expectedModel = new ModelManager(new AddressBook(modelLoggedIn.getAddressBook()),
                new DeliveryBook(modelLoggedIn.getDeliveryBook()),
                new UserPrefs(), modelLoggedIn.getUserLoginStatus());

        expectedModel.setDelivery(modelLoggedIn.getFilteredDeliveryList().get(0), editedDelivery);

        assertCommandSuccess(editCommand, modelLoggedIn, expectedMessage, expectedModel, true);
    }

    @Test
    public void execute_invalidPerson_throwsCommandException() { //not done
        PersonBuilder personBuilder = new PersonBuilder();
        Customer invalidCustomer = personBuilder.withCustomerId(TOO_LARGE_CUSTOMER_ID).build();

        Delivery validDelivery = new DeliveryBuilder().withCustomer(invalidCustomer).build();

        DeliveryAddCommand deliveryAddCommand = new DeliveryAddCommand(
                new DeliveryAddDescriptorBuilder(validDelivery).build());

        assertThrows(CommandException.class, Messages.MESSAGE_INVALID_CUSTOMER_DISPLAYED_INDEX, () ->
                deliveryAddCommand.execute(modelLoggedIn));
    }

    @Test
    public void execute_invalidDeliveryDate_throwsCommandException() { //not done
        PersonBuilder personBuilder = new PersonBuilder();
        Customer validCustomer = personBuilder.build();

        Delivery validDelivery =
                new DeliveryBuilder().withCustomer(validCustomer)
                        .withDeliveryDate(INVALID_DELIVERY_DATE).build();

        DeliveryAddCommand deliveryAddCommand = new DeliveryAddCommand(new
                DeliveryAddDescriptorBuilder(validDelivery).build());

        assertThrows(CommandException.class, Messages.MESSAGE_INVALID_DELIVERY_DATE, () ->
                deliveryAddCommand.execute(modelLoggedIn));
    }

    @Test
    public void execute_deliveryAcceptedByModelLoggedOut_addFailure() {
        PersonBuilder personBuilder = new PersonBuilder();
        Customer validCustomer = personBuilder.build();


        Delivery validDelivery = new DeliveryBuilder().withCustomer(validCustomer).build();

        DeliveryEditCommand deliveryEditCommand = new DeliveryEditCommand(INDEX_FIRST_PERSON, new
                DeliveryEditDescriptorBuilder(validDelivery).build());
        assertThrows(CommandException.class, Messages.MESSAGE_USER_NOT_AUTHENTICATED, () ->
                deliveryEditCommand.execute(modelLoggedOut));

    }

    @Test
    public void equals() {
        final DeliveryEditCommand standardCommand = new DeliveryEditCommand(INDEX_FIRST_PERSON, DESC_EDIT_CHIPS);

        // same values -> returns true
        DeliveryEditCommand.DeliveryEditDescriptor copyDescriptor = new DeliveryEditCommand.DeliveryEditDescriptor(DESC_EDIT_CHIPS);
        DeliveryEditCommand commandWithSameValues = new DeliveryEditCommand(INDEX_FIRST_PERSON, copyDescriptor);
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different index -> returns false
        assertFalse(standardCommand.equals(new DeliveryEditCommand(INDEX_SECOND_PERSON, DESC_EDIT_CHIPS)));

        // different descriptor -> returns false
        assertFalse(standardCommand.equals(new DeliveryEditCommand(INDEX_FIRST_PERSON, DESC_EDIT_MILK)));
    }

    @Test
    public void toStringMethod() {
        Index index = Index.fromOneBased(1);
        DeliveryEditCommand.DeliveryEditDescriptor deliveryEditDescriptor = new DeliveryEditCommand.DeliveryEditDescriptor();
        DeliveryEditCommand editCommand = new DeliveryEditCommand(index, deliveryEditDescriptor);
        String expected = DeliveryEditCommand.class.getCanonicalName() + "{index=" + index + ", deliveryEditDescriptor="
                + deliveryEditDescriptor + "}";
        assertEquals(expected, editCommand.toString());
    }

}

