package seedu.address.logic.parser.user;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PASSWORD;
import static seedu.address.logic.parser.CliSyntax.PREFIX_USER;

import seedu.address.logic.commands.user.UserLoginCommand;
import seedu.address.logic.parser.*;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.user.Password;
import seedu.address.model.user.User;
import seedu.address.model.user.Username;

import java.util.stream.Stream;

/**
 * Parses input arguments and creates a new AddCommand object
 */
public class UserLoginCommandParser implements Parser<UserLoginCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the UserLoginCommand
     * and returns an UserLoginCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public UserLoginCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_USER, PREFIX_PASSWORD);

        if (!arePrefixesPresent(argMultimap, PREFIX_USER, PREFIX_PASSWORD)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, UserLoginCommand.MESSAGE_USAGE));
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_USER, PREFIX_PASSWORD);
        Username username = ParserUtil.parseUsername(argMultimap.getValue(PREFIX_USER).get());
        Password password = ParserUtil.parsePassword(argMultimap.getValue(PREFIX_PASSWORD).get());

        User user = new User(username, password);

        return new UserLoginCommand(user);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
