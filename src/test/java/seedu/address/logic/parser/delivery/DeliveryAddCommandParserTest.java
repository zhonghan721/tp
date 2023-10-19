package seedu.address.logic.parser.delivery;

import org.junit.jupiter.api.Test;
import seedu.address.logic.commands.customer.AddCommand;
import seedu.address.logic.commands.delivery.DeliveryAddCommand;
import seedu.address.logic.commands.delivery.DeliveryAddCommand.DeliveryAddDescriptor;
import seedu.address.logic.parser.DeliveryAddCommandParser;
import seedu.address.model.delivery.Delivery;
import seedu.address.model.person.Customer;
import seedu.address.testutil.DeliveryBuilder;
import seedu.address.testutil.PersonBuilder;

import static seedu.address.logic.commands.CommandTestUtil.*;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalPersons.BOB;

public class DeliveryAddCommandParserTest {
    DeliveryAddCommandParser parser = new DeliveryAddCommandParser();



    @Test
    public void parse_allFieldsPresent_success() {

        DeliveryAddDescriptor expectedDescriptor = new DeliveryAddDescriptor(DESC_MILK);

        // whitespace only preamble
            assertParseSuccess(parser, NAME_DESC_MILK + CUSTOMER_DESC_MILK
                    + DELIVERY_DATE_DESC_MILK, new DeliveryAddCommand(expectedDescriptor));

    }


}
