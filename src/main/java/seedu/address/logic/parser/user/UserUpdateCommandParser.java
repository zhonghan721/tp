package seedu.address.logic.parser.user;

import static seedu.address.logic.parser.CliSyntax.PREFIX_ANSWER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PASSWORD;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PASSWORD_CONFIRM;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SECRET_QUESTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_USER;

import seedu.address.logic.commands.user.UserUpdateCommand;
import seedu.address.logic.commands.user.UserUpdateCommand.UpdateUserDescriptor;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.user.Password;

/**
 * Parses input arguments and creates a new UserUpdateCommand object
 */
public class UserUpdateCommandParser implements Parser<UserUpdateCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the UserRegisterCommand
     * and returns an UserRegisterCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public UserUpdateCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_USER, PREFIX_PASSWORD, PREFIX_PASSWORD_CONFIRM,
                        PREFIX_SECRET_QUESTION, PREFIX_ANSWER);

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_USER, PREFIX_PASSWORD, PREFIX_PASSWORD_CONFIRM,
                PREFIX_SECRET_QUESTION, PREFIX_ANSWER);

        UpdateUserDescriptor updateUserDescriptor = new UpdateUserDescriptor();

        if (argMultimap.getValue(PREFIX_USER).isPresent()) {
            updateUserDescriptor.setUsername(ParserUtil.parseUsername(argMultimap.getValue(PREFIX_USER).get()));
        }
        // Either one of password or confirm password is missing.
        if (argMultimap.getValue(PREFIX_PASSWORD).isPresent()
            && argMultimap.getValue(PREFIX_PASSWORD_CONFIRM).isEmpty()) {
            throw new ParseException(UserUpdateCommand.MESSAGE_PASSWORD_OR_CONFIRM_PASSWORD_MISSING);
        }
        if (argMultimap.getValue(PREFIX_PASSWORD_CONFIRM).isPresent()
                && argMultimap.getValue(PREFIX_PASSWORD).isEmpty()) {
            throw new ParseException(UserUpdateCommand.MESSAGE_PASSWORD_OR_CONFIRM_PASSWORD_MISSING);
        }
        // Both password and confirm password are present.
        if (argMultimap.getValue(PREFIX_PASSWORD).isPresent()
                && argMultimap.getValue(PREFIX_PASSWORD_CONFIRM).isPresent()) {
            Password password = ParserUtil.parsePassword(argMultimap.getValue(PREFIX_PASSWORD).get());
            Password confirmPassword = ParserUtil.parsePassword(argMultimap.getValue(PREFIX_PASSWORD_CONFIRM).get());
            // Passwords mismatch
            if (!password.equals(confirmPassword)) {
                throw new ParseException(UserUpdateCommand.MESSAGE_PASSWORD_MISMATCH);
            }
            updateUserDescriptor.setPassword(password);
        }
        // Either one of secret question or answer is missing.
        if (argMultimap.getValue(PREFIX_SECRET_QUESTION).isPresent()
                && argMultimap.getValue(PREFIX_ANSWER).isEmpty()) {
            throw new ParseException(UserUpdateCommand.MESSAGE_QUESTION_OR_ANSWER_MISSING);
        }
        if (argMultimap.getValue(PREFIX_ANSWER).isPresent()
                && argMultimap.getValue(PREFIX_SECRET_QUESTION).isEmpty()) {
            throw new ParseException(UserUpdateCommand.MESSAGE_QUESTION_OR_ANSWER_MISSING);
        }
        // Both secret question and answer are present.
        if (argMultimap.getValue(PREFIX_SECRET_QUESTION).isPresent()
                && argMultimap.getValue(PREFIX_ANSWER).isPresent()) {
            updateUserDescriptor.setSecretQuestion(ParserUtil.parseSecretQuestion(
                    argMultimap.getValue(PREFIX_SECRET_QUESTION).get()));
            updateUserDescriptor.setAnswer(ParserUtil.parseAnswer(argMultimap.getValue(PREFIX_ANSWER).get()));
        }

        if (!updateUserDescriptor.isAnyFieldEdited()) {
            throw new ParseException(
                    String.format(UserUpdateCommand.MESSAGE_MISSING_FIELDS, UserUpdateCommand.MESSAGE_USAGE));
        }

        return new UserUpdateCommand(updateUserDescriptor);
    }
}
