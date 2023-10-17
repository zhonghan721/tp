package seedu.address.logic.parser;

import static seedu.address.logic.parser.CliSyntax.PREFIX_SORT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STATUS;

import java.util.Optional;

import seedu.address.logic.commands.delivery.DeliveryListCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.delivery.DeliveryStatus;

/**
 * Parses input arguments and creates a new DeliveryListCommand object.
 */
public class DeliveryListParser implements Parser<DeliveryListCommand> {

    @Override
    public DeliveryListCommand parse(String userInput) throws ParseException {
        ArgumentMultimap argMultimap =
            ArgumentTokenizer.tokenize(userInput, PREFIX_STATUS, PREFIX_SORT);

        Optional<String> sort = argMultimap.getValue(PREFIX_SORT);
        DeliveryStatus status = ParserUtil.parseDeliveryStatus(argMultimap.getValue(PREFIX_STATUS).orElse("all"));

        if (sort.isEmpty()) {
            return new DeliveryListCommand(status);
        }

        String sortString = ParserUtil.parseSort(sort.get());

        return new DeliveryListCommand(status, sortString);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof DeliveryListParser); // instanceof handles nulls

    }
}
