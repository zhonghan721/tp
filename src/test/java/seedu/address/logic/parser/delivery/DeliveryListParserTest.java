package seedu.address.logic.parser.delivery;

import static seedu.address.logic.commands.CommandTestUtil.INVALID_DELIVERY_LIST;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_DELIVERY_LIST_SORT;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DELIVERY_LIST_ALL;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DELIVERY_LIST_CANCELLED;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DELIVERY_LIST_COMPLETED;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DELIVERY_LIST_CREATED;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DELIVERY_LIST_SHIPPED;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DELIVERY_LIST_SORT_ASC;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DELIVERY_LIST_SORT_DESC;

import org.junit.jupiter.api.Test;

import seedu.address.logic.Sort;
import seedu.address.logic.commands.delivery.DeliveryListCommand;
import seedu.address.logic.parser.CommandParserTestUtil;
import seedu.address.logic.parser.DeliveryListParser;
import seedu.address.model.delivery.DeliveryStatus;


public class DeliveryListParserTest {
    private DeliveryListParser parser = new DeliveryListParser();


    @Test
    public void parse_validArgs_returnsDeliveryListCommand() {
        CommandParserTestUtil.assertParseSuccess(parser, DeliveryListCommand.COMMAND_WORD
                + VALID_DELIVERY_LIST_ALL,
            new DeliveryListCommand(null));
        CommandParserTestUtil.assertParseSuccess(parser, DeliveryListCommand.COMMAND_WORD
                + VALID_DELIVERY_LIST_SHIPPED,
            new DeliveryListCommand(DeliveryStatus.SHIPPED));
        CommandParserTestUtil.assertParseSuccess(parser, DeliveryListCommand.COMMAND_WORD
            + VALID_DELIVERY_LIST_CREATED, new DeliveryListCommand(DeliveryStatus
            .CREATED));
        CommandParserTestUtil.assertParseSuccess(parser, DeliveryListCommand.COMMAND_WORD
                + VALID_DELIVERY_LIST_COMPLETED,
            new DeliveryListCommand(DeliveryStatus.COMPLETED));
        CommandParserTestUtil.assertParseSuccess(parser, DeliveryListCommand.COMMAND_WORD
                + VALID_DELIVERY_LIST_CANCELLED,
            new DeliveryListCommand(DeliveryStatus.CANCELLED));

        CommandParserTestUtil.assertParseSuccess(parser, DeliveryListCommand.COMMAND_WORD
                + VALID_DELIVERY_LIST_ALL + VALID_DELIVERY_LIST_SORT_ASC,
            new DeliveryListCommand(null, Sort.ASC));

        CommandParserTestUtil.assertParseSuccess(parser, DeliveryListCommand.COMMAND_WORD
                + VALID_DELIVERY_LIST_ALL + VALID_DELIVERY_LIST_SORT_DESC,
            new DeliveryListCommand(null, Sort.DESC));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        CommandParserTestUtil.assertParseFailure(parser, DeliveryListCommand.COMMAND_WORD + INVALID_DELIVERY_LIST,
            String.format(DeliveryStatus.MESSAGE_CONSTRAINTS));
    }

    @Test
    public void parse_emptyArgs_throwsParseException() {
        CommandParserTestUtil.assertParseSuccess(parser, "",
            new DeliveryListCommand(null));
    }

    @Test
    public void parse_invalidStatus_throwsParseException() {
        CommandParserTestUtil.assertParseFailure(parser, DeliveryListCommand.COMMAND_WORD + INVALID_DELIVERY_LIST,
            String.format(DeliveryStatus.MESSAGE_CONSTRAINTS));
    }

    @Test
    public void parse_invalidSort_throwsParseException() {
        CommandParserTestUtil.assertParseFailure(parser, DeliveryListCommand.COMMAND_WORD + INVALID_DELIVERY_LIST_SORT,
            String.format(Sort.MESSAGE_CONSTRAINTS));
    }

    @Test
    public void parse_invalidStatusAndSort_throwsParseException() {
        CommandParserTestUtil.assertParseFailure(parser, DeliveryListCommand.COMMAND_WORD
                + INVALID_DELIVERY_LIST + INVALID_DELIVERY_LIST_SORT,
            String.format(DeliveryStatus.MESSAGE_CONSTRAINTS));
    }

    @Test
    public void parse_validStatusAndSort_returnsDeliveryListCommand() {
        CommandParserTestUtil.assertParseSuccess(parser, DeliveryListCommand.COMMAND_WORD
                + VALID_DELIVERY_LIST_SHIPPED + VALID_DELIVERY_LIST_SORT_ASC,
            new DeliveryListCommand(DeliveryStatus.SHIPPED, Sort.ASC));
        CommandParserTestUtil.assertParseSuccess(parser, DeliveryListCommand.COMMAND_WORD
                + VALID_DELIVERY_LIST_SHIPPED + VALID_DELIVERY_LIST_SORT_DESC,
            new DeliveryListCommand(DeliveryStatus.SHIPPED, Sort.DESC));
    }
}
