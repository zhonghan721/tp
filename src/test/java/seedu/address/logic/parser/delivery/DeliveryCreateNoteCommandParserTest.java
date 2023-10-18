package seedu.address.logic.parser.delivery;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_NOTE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NOTE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NOTE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.delivery.DeliveryCreateNoteCommand;
import seedu.address.model.delivery.Note;

public class DeliveryCreateNoteCommandParserTest {
    private static final String MESSAGE_INVALID_FORMAT =
        String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeliveryCreateNoteCommand.MESSAGE_USAGE);

    private DeliveryCreateNoteCommandParser parser = new DeliveryCreateNoteCommandParser();

    @Test
    public void parse_allFieldsValid_success() {
        DeliveryCreateNoteCommand expectedCommand = new DeliveryCreateNoteCommand(1, new Note(VALID_NOTE));
        assertParseSuccess(parser, "1 " + PREFIX_NOTE + " " + VALID_NOTE, expectedCommand);
    }

    @Test
    public void parse_allFieldsValidExtraSpaces_success() {
        DeliveryCreateNoteCommand expectedCommand = new DeliveryCreateNoteCommand(1, new Note(VALID_NOTE));
        assertParseSuccess(parser, "   1 " + PREFIX_NOTE + "   " + VALID_NOTE, expectedCommand);
    }


    @Test
    public void parse_invalidNote_failure() {
        assertParseFailure(parser, "1 " + PREFIX_NOTE + " " + INVALID_NOTE, Note.MESSAGE_CONSTRAINTS);
    }

    @Test
    public void parse_missingNotePrefix_failure() {
        assertParseFailure(parser, "1 " + VALID_NOTE, MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_invalidIdNegative_failure() {
        assertParseFailure(parser, "-1 " + PREFIX_NOTE + " " + VALID_NOTE, MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_invalidIdNan_failure() {
        assertParseFailure(parser, "NaN " + PREFIX_NOTE + " " + VALID_NOTE, MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_missingId_failure() {
        assertParseFailure(parser, PREFIX_NOTE + " " + VALID_NOTE, MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_invalidOrder_failure() {
        assertParseFailure(parser, PREFIX_NOTE + " " + VALID_NOTE + " 1", MESSAGE_INVALID_FORMAT);
    }
}
