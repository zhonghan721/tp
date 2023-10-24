package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.Messages.MESSAGE_UNKNOWN_COMMAND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DELIVERY_DATE_3;
import static seedu.address.logic.commands.CommandTestUtil.VALID_VIEW_CUSTOMER_ID_1;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CUSTOMER_ID;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PASSWORD;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PASSWORD_CONFIRM;
import static seedu.address.logic.parser.CliSyntax.PREFIX_USER;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalDeliveries.GABRIELS_MILK;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.customer.AddCommand;
import seedu.address.logic.commands.customer.CustomerDeleteCommand;
import seedu.address.logic.commands.customer.CustomerEditCommand;
import seedu.address.logic.commands.customer.CustomerEditCommand.EditPersonDescriptor;
import seedu.address.logic.commands.customer.CustomerListCommand;
import seedu.address.logic.commands.delivery.DeliveryAddCommand;
import seedu.address.logic.commands.delivery.DeliveryAddCommand.DeliveryAddDescriptor;
import seedu.address.logic.commands.delivery.DeliveryCreateNoteCommand;
import seedu.address.logic.commands.delivery.DeliveryDeleteCommand;
import seedu.address.logic.commands.delivery.DeliveryEditCommand;
import seedu.address.logic.commands.delivery.DeliveryEditCommand.DeliveryEditDescriptor;
import seedu.address.logic.commands.delivery.DeliveryStatusCommand;
import seedu.address.logic.commands.delivery.DeliveryViewCommand;
import seedu.address.logic.commands.user.UserRegisterCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.delivery.Delivery;
import seedu.address.model.delivery.DeliveryStatus;
import seedu.address.model.delivery.Note;
import seedu.address.model.person.Customer;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.testutil.*;


public class AddressBookParserTest {

    private final AddressBookParser parser = new AddressBookParser();

    @Test
    public void parseCommand_add() throws Exception {
        Customer customer = new PersonBuilder().withCustomerId(Customer.getCustomerCount()).build();
        AddCommand command = (AddCommand) parser.parseCommand(PersonUtil.getAddCommand(customer));
        assertEquals(new AddCommand(customer), command);
    }

    @Test
    public void parseCommand_clear() throws Exception {
        assertTrue(parser.parseCommand(ClearCommand.COMMAND_WORD) instanceof ClearCommand);
        assertTrue(parser.parseCommand(ClearCommand.COMMAND_WORD + " 3") instanceof ClearCommand);
    }

    @Test
    public void parseCommand_deliveryCreateNote() throws Exception {
        DeliveryCreateNoteCommand command = (DeliveryCreateNoteCommand) parser.parseCommand(
                DeliveryCreateNoteCommand.COMMAND_WORD + " 1 --note This is a note");
        assertEquals(new DeliveryCreateNoteCommand(1, new Note("This is a note")), command);
    }

    @Test
    public void parseCommand_delete() throws Exception {
        CustomerDeleteCommand command = (CustomerDeleteCommand) parser.parseCommand(
                CustomerDeleteCommand.COMMAND_WORD + " " + INDEX_FIRST_PERSON.getOneBased());
        assertEquals(new CustomerDeleteCommand(INDEX_FIRST_PERSON), command);
    }

    @Test
    public void parseCommand_deliveryStatus() throws Exception {
        DeliveryStatusCommand command = (DeliveryStatusCommand) parser.parseCommand(
                DeliveryStatusCommand.COMMAND_WORD + " "
                        + DeliveryStatus.COMPLETED + " " + GABRIELS_MILK.getDeliveryId());
        assertEquals(new DeliveryStatusCommand(GABRIELS_MILK.getDeliveryId(), DeliveryStatus.COMPLETED), command);
    }

    @Test
    public void parseCommand_deliveryView() throws Exception {
        DeliveryViewCommand command = (DeliveryViewCommand) parser.parseCommand(
                DeliveryViewCommand.COMMAND_WORD + " " + GABRIELS_MILK.getDeliveryId());
        assertEquals(new DeliveryViewCommand(GABRIELS_MILK.getDeliveryId()), command);
    }

    @Test
    public void parseCommand_editCustomer() throws Exception {
        Customer customer = new PersonBuilder().build();
        EditPersonDescriptor descriptor = new EditPersonDescriptorBuilder(customer).build();
        CustomerEditCommand command = (CustomerEditCommand) parser.parseCommand(CustomerEditCommand.COMMAND_WORD + " "
                + INDEX_FIRST_PERSON.getOneBased() + " " + PersonUtil.getEditPersonDescriptorDetails(descriptor));
        assertEquals(new CustomerEditCommand(INDEX_FIRST_PERSON, descriptor), command);
    }

    @Test
    public void parseCommand_deleteDelivery() throws Exception {
        DeliveryDeleteCommand command = (DeliveryDeleteCommand) parser.parseCommand(
                DeliveryDeleteCommand.COMMAND_WORD + " " + INDEX_FIRST_PERSON.getOneBased());
        assertEquals(new DeliveryDeleteCommand(INDEX_FIRST_PERSON), command);
    }

    @Test
    public void parseCommand_addDelivery() throws Exception {
        DeliveryAddCommand command = (DeliveryAddCommand) parser.parseCommand(
                DeliveryAddCommand.COMMAND_WORD + " "
                        + "Gabriels "
                        + PREFIX_CUSTOMER_ID + VALID_VIEW_CUSTOMER_ID_1 + " "
                        + PREFIX_DATE + VALID_DELIVERY_DATE_3);

        DeliveryBuilder deliveryBuilder = new DeliveryBuilder();
        Delivery validDelivery = deliveryBuilder.build();
        DeliveryAddDescriptorBuilder deliveryAddDescriptorBuilder = new DeliveryAddDescriptorBuilder(validDelivery);
        DeliveryAddDescriptor validDeliveryAddDescriptor = deliveryAddDescriptorBuilder.build();

        assertEquals(new DeliveryAddCommand(validDeliveryAddDescriptor), command);
    }

    @Test
    public void parseCommand_editDelivery() throws Exception {
        Delivery delivery = new DeliveryBuilder().build();
        DeliveryEditDescriptor descriptor = new DeliveryEditDescriptorBuilder(delivery).build();
        DeliveryEditCommand command = (DeliveryEditCommand) parser.parseCommand(DeliveryEditCommand
                .COMMAND_WORD + " " + INDEX_FIRST_PERSON.getOneBased()
                + " " + DeliveryUtil.getEditDeliveryDescriptorDetails(descriptor));
        assertEquals(new DeliveryEditCommand(INDEX_FIRST_PERSON, descriptor), command);
    }

    @Test
    public void parseCommand_exit() throws Exception {
        assertTrue(parser.parseCommand(ExitCommand.COMMAND_WORD) instanceof ExitCommand);
        assertTrue(parser.parseCommand(ExitCommand.COMMAND_WORD + " 3") instanceof ExitCommand);
    }

    @Test
    public void parseCommand_find() throws Exception {
        List<String> keywords = Arrays.asList("foo", "bar", "baz");
        FindCommand command = (FindCommand) parser.parseCommand(
                FindCommand.COMMAND_WORD + " " + keywords.stream().collect(Collectors.joining(" ")));
        assertEquals(new FindCommand(new NameContainsKeywordsPredicate(keywords)), command);
    }

    @Test
    public void parseCommand_help() throws Exception {
        assertTrue(parser.parseCommand(HelpCommand.COMMAND_WORD) instanceof HelpCommand);
        assertTrue(parser.parseCommand(HelpCommand.COMMAND_WORD + " 3") instanceof HelpCommand);
    }

    @Test
    public void parseCommand_customerList() throws Exception {
        assertTrue(parser.parseCommand(CustomerListCommand.COMMAND_WORD) instanceof CustomerListCommand);
        assertTrue(parser.parseCommand(CustomerListCommand.COMMAND_WORD + " 3") instanceof CustomerListCommand);
    }

    @Test
    public void parseCommand_unrecognisedInput_throwsParseException() {
        assertThrows(ParseException.class, String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE), ()
                -> parser.parseCommand(""));
    }

    @Test
    public void parseCommand_unknownCommand_throwsParseException() {
        assertThrows(ParseException.class, MESSAGE_UNKNOWN_COMMAND, () -> parser.parseCommand("unknownCommand"));
    }

    @Test
    public void parseCommand_invalidPrefix_throwsParseException() {
        // Cannot wrap lines due to Separator Wrap not allowing lambda on newline
        assertThrows(
                ParseException.class, MESSAGE_UNKNOWN_COMMAND, () -> parser.parseCommand("invalidPrefix list"));
    }

    @Test
    // test user register command
    public void parseCommand_userRegister() throws Exception {
        assertTrue(parser.parseCommand(UserRegisterCommand.COMMAND_WORD + " "
                + PREFIX_USER + " username "
                + PREFIX_PASSWORD + " password "
                + PREFIX_PASSWORD_CONFIRM + " password") instanceof UserRegisterCommand);
    }

}
