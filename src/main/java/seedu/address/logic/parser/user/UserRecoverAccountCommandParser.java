package seedu.address.logic.parser.user;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ANSWER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PASSWORD;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PASSWORD_CONFIRM;

import java.util.stream.Stream;

import seedu.address.logic.commands.user.UserRecoverAccountCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.Prefix;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.user.Password;

/**
 * Parses input arguments and creates a new UserRecoverAccountCommand object
 */
public class UserRecoverAccountCommandParser implements Parser<UserRecoverAccountCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the UserRecoverAccountCommand
     * and returns an UserRecoverAccountCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public UserRecoverAccountCommand parse(String args) throws ParseException {
        System.out.println(args);

        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_ANSWER, PREFIX_PASSWORD, PREFIX_PASSWORD_CONFIRM);

        if (arePrefixesAbsent(argMultimap, PREFIX_ANSWER, PREFIX_PASSWORD, PREFIX_PASSWORD_CONFIRM)) {
            return new UserRecoverAccountCommand();
        }

        if (!arePrefixesPresent(argMultimap, PREFIX_ANSWER, PREFIX_PASSWORD, PREFIX_PASSWORD_CONFIRM)
                || !argMultimap.getPreamble().isEmpty()) {
            // if not viewing secret question, then all prefixes must be present
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    UserRecoverAccountCommand.MESSAGE_USAGE));
        }
        // all prefixes present
        // check if password and password confirm are present and matches
        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_ANSWER, PREFIX_PASSWORD, PREFIX_PASSWORD_CONFIRM);
        Password password = ParserUtil.parsePassword(argMultimap.getValue(PREFIX_PASSWORD).get());
        Password confirmPassword = ParserUtil.parsePassword(argMultimap.getValue(PREFIX_PASSWORD_CONFIRM).get());
        String answer = ParserUtil.parseAnswer(argMultimap.getValue(PREFIX_ANSWER).get());
        if (!password.equals(confirmPassword)) {
            throw new ParseException(UserRecoverAccountCommand.MESSAGE_PASSWORD_MISMATCH);
        }
        return new UserRecoverAccountCommand(answer, password);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

    /**
     * Returns true if all of the prefixes contains empty {@code Optional} values in the given
     */
    private static boolean arePrefixesAbsent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isEmpty());
    }
}
