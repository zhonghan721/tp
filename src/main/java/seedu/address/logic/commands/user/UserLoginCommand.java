package seedu.address.logic.commands.user;

import static seedu.address.logic.parser.CliSyntax.PREFIX_PASSWORD;
import static seedu.address.logic.parser.CliSyntax.PREFIX_USER;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.user.User;

import static java.util.Objects.requireNonNull;

public class UserLoginCommand extends Command {

    public static final String COMMAND_WORD = "login";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Login to HomeBoss.\n"
            + "Parameters: " + PREFIX_USER + " " + PREFIX_PASSWORD +"\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_USER + " yourUsername "
            + PREFIX_PASSWORD + " yourPassword ";
    public static final String MESSAGE_SUCCESS = "Welcome back to HomeBoss!";
    public static final String MESSAGE_WRONG_CREDENTIALS = "Wrong username/password";
    public static final String MESSAGE_ALREADY_LOGGED_IN = "You are already logged in!";

    private final User user;

    public UserLoginCommand(User user) {
        requireNonNull(user);
        this.user = user;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        // Logged in user cannot login again
        if (model.getUserLoginStatus()) {
            throw new CommandException(MESSAGE_ALREADY_LOGGED_IN);
        }

//        if (!model.userMatches(user)) {
//            throw new CommandException(MESSAGE_WRONG_CREDENTIALS);
//        }
        model.setLoginSuccess();
        return new CommandResult(MESSAGE_SUCCESS);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof UserLoginCommand)) {
            return false;
        }

        UserLoginCommand otherUserLoginCommand = (UserLoginCommand) other;
        return user.equals(otherUserLoginCommand.user);
    }
}
