package seedu.address.logic.parser.delivery;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.VALID_VIEW_DELIVERY_ID;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.delivery.DeliveryViewCommand;


public class DeliveryViewCommandParserTest {

    private DeliveryViewCommandParser parser = new DeliveryViewCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "",
            String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                DeliveryViewCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsDeliveryViewCommand() {
        assertParseSuccess(parser, VALID_VIEW_DELIVERY_ID,
            new DeliveryViewCommand(1));
    }

    @Test
    public void parse_validArgsExtraSpaceBetween_returnsDeliveryViewCommand() {
        assertParseSuccess(parser, " " + VALID_VIEW_DELIVERY_ID,
            new DeliveryViewCommand(1));
    }

    @Test
    public void parse_invalidArgs_returnsDeliveryViewCommand() {
        assertParseFailure(parser, "a",
            String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                DeliveryViewCommand.MESSAGE_USAGE));
    }
}
