package seedu.address.logic.parser.delivery;

import seedu.address.logic.commands.delivery.DeliveryViewCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

public class DeliveryViewCommandParser implements Parser<DeliveryViewCommand> {

    private static final Pattern ARGUMENT_FORMAT = Pattern.compile(
        "^(?<id>\\d+)$"
    );

    @Override
    public DeliveryViewCommand parse(String args) throws ParseException {
        if (args.isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                DeliveryViewCommand.MESSAGE_USAGE));
        }
        final Matcher matcher = ARGUMENT_FORMAT.matcher(args.trim().toUpperCase());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                DeliveryViewCommand.MESSAGE_USAGE));
        }

        final String id = matcher.group("id");

        int deliveryId = ParserUtil.parseId(id);

        return new DeliveryViewCommand(deliveryId);
    }
}
