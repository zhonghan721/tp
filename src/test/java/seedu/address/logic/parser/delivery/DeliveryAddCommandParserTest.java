package seedu.address.logic.parser.delivery;

import org.junit.jupiter.api.Test;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.customer.AddCommand;
import seedu.address.logic.commands.delivery.DeliveryAddCommand;
import seedu.address.logic.commands.delivery.DeliveryAddCommand.DeliveryAddDescriptor;
import seedu.address.logic.parser.DeliveryAddCommandParser;
import seedu.address.model.delivery.Delivery;
import seedu.address.model.delivery.DeliveryDate;
import seedu.address.model.delivery.DeliveryName;
import seedu.address.model.person.Customer;
import seedu.address.testutil.DeliveryBuilder;
import seedu.address.testutil.PersonBuilder;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.*;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CUSTOMER_ID;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.logic.parser.ParserUtil.MESSAGE_INVALID_INDEX;
import static seedu.address.testutil.TypicalPersons.BOB;

public class DeliveryAddCommandParserTest {
    DeliveryAddCommandParser parser = new DeliveryAddCommandParser();


    @Test
    public void parse_allFieldsPresent_success() {
        DeliveryAddDescriptor expectedDescriptor = new DeliveryAddDescriptor(DESC_MILK);

        // whitespace only preamble
        assertParseSuccess(parser, NAME_DESC_MILK + CUSTOMER_ID_DESC_MILK
                + DELIVERY_DATE_DESC_MILK, new DeliveryAddCommand(expectedDescriptor));
    }

    @Test
    public void parse_missingPrefix_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeliveryAddCommand.MESSAGE_USAGE);
        // missing customer prefix
        assertParseFailure(parser, NAME_DESC_MILK + VALID_CUSTOMER_ID_1
                + DELIVERY_DATE_DESC_MILK, expectedMessage);

        // missing delivery date prefix
        assertParseFailure(parser, NAME_DESC_MILK + CUSTOMER_ID_DESC_MILK
                + VALID_DELIVERY_DATE_1, expectedMessage);
    }

    @Test
    public void parse_missingPreamble_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeliveryAddCommand.MESSAGE_USAGE);

        assertParseFailure(parser,  CUSTOMER_ID_DESC_MILK
                + DELIVERY_DATE_DESC_MILK, expectedMessage);

    }

    @Test
    public void parse_duplicatePrefix_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeliveryAddCommand.MESSAGE_USAGE);

        assertParseFailure(parser,  CUSTOMER_ID_DESC_MILK + CUSTOMER_ID_DESC_MILK
                + DELIVERY_DATE_DESC_MILK, expectedMessage);
    }

    @Test
    public void parse_noArgs_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeliveryAddCommand.MESSAGE_USAGE);

        assertParseFailure(parser,  "", expectedMessage);
    }
    @Test
    public void parse_invalidArgs_throwsParseException() {
        // delivery add <name> --customer <customer id> --date <delivery date>

        // invalid name
        assertParseFailure(parser, INVALID_NAME_DESC + CUSTOMER_ID_DESC_MILK
                + DELIVERY_DATE_DESC_MILK, DeliveryName.MESSAGE_CONSTRAINTS);

        // invalid delivery date
        assertParseFailure(parser, NAME_DESC_MILK + CUSTOMER_ID_DESC_MILK
                + INVALID_DELIVERY_DATE_DESC, DeliveryDate.MESSAGE_CONSTRAINTS);


//        // invalid customer id
        assertParseFailure(parser, NAME_DESC_MILK + INVALID_CUSTOMER_ID_DESC
                + DELIVERY_DATE_DESC_MILK, MESSAGE_INVALID_INDEX);

    }

}