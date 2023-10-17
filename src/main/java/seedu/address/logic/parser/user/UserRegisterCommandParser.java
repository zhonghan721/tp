package seedu.address.logic.parser.user;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PASSWORD;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PASSWORD_CONFIRM;
import static seedu.address.logic.parser.CliSyntax.PREFIX_USER;

import java.util.stream.Stream;

import seedu.address.logic.commands.user.UserRegisterCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.Prefix;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.user.Password;
import seedu.address.model.user.User;
import seedu.address.model.user.Username;

/**
 * Parses input arguments and creates a new UserRegisterCommand object
 */
public class UserRegisterCommandParser implements Parser<UserRegisterCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the UserRegisterCommand
     * and returns an UserRegisterCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public UserRegisterCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_USER, PREFIX_PASSWORD, PREFIX_PASSWORD_CONFIRM);

        if (!arePrefixesPresent(argMultimap, PREFIX_USER, PREFIX_PASSWORD, PREFIX_PASSWORD_CONFIRM)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, UserRegisterCommand.MESSAGE_USAGE));
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_USER, PREFIX_PASSWORD, PREFIX_PASSWORD_CONFIRM);
        Username username = ParserUtil.parseUsername(argMultimap.getValue(PREFIX_USER).get());
        Password password = ParserUtil.parsePassword(argMultimap.getValue(PREFIX_PASSWORD).get());
        Password confirmPassword = ParserUtil.parsePassword(argMultimap.getValue(PREFIX_PASSWORD_CONFIRM).get());

        if (!password.equals(confirmPassword)) {
            throw new ParseException(UserRegisterCommand.MESSAGE_PASSWORD_MISMATCH);
        }

        User user = new User(username, password, true);

        return new UserRegisterCommand(user);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
