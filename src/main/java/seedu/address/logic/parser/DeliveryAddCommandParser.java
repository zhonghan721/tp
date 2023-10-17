package seedu.address.logic.parser;

import seedu.address.logic.commands.delivery.DeliveryAddCommand;
import seedu.address.logic.commands.delivery.DeliveryAddCommand.DeliveryAddDescriptor;
import seedu.address.logic.parser.exceptions.ParseException;

import java.util.stream.Stream;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CUSTOMER_ID;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;

public class DeliveryAddCommandParser implements Parser<DeliveryAddCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeliveryAddCommand
     * and returns a DeliveryAddCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeliveryAddCommand parse(String args) throws ParseException {

        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args,PREFIX_CUSTOMER_ID, PREFIX_DATE);

        if (!arePrefixesPresent(argMultimap,PREFIX_CUSTOMER_ID, PREFIX_DATE)
                || argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeliveryAddCommand.MESSAGE_USAGE));
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_CUSTOMER_ID, PREFIX_DATE);

        DeliveryAddDescriptor deliveryAddDescriptor = new DeliveryAddDescriptor();

        if (!argMultimap.getPreamble().isEmpty()) {
            deliveryAddDescriptor.setDeliveryName(ParserUtil
                    .parseDeliveryName(argMultimap.getPreamble()));
        }
        if (argMultimap.getValue(PREFIX_CUSTOMER_ID).isPresent()) {
            deliveryAddDescriptor.setCustomerId(ParserUtil
                    .parseId(argMultimap.getValue(PREFIX_CUSTOMER_ID).get()));
        }
        if (argMultimap.getValue(PREFIX_DATE).isPresent()) {
            deliveryAddDescriptor.setDeliveryDate(ParserUtil
                    .parseDeliveryDate(argMultimap.getValue(PREFIX_DATE).get()));
        }

        return new DeliveryAddCommand(deliveryAddDescriptor);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
