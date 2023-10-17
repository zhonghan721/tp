package seedu.address.logic.commands.user;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

import static java.util.Objects.requireNonNull;

public class UserLogoutCommand extends Command {

    public static final String COMMAND_WORD = "logout";
    public static final String MESSAGE_SUCCESS = "Bye!";
    public static final String MESSAGE_ALREADY_LOGGED_OUT = "You are already logged out!";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        // Logged out user cannot log out again
        if (!model.getUserLoginStatus()) {
            throw new CommandException(MESSAGE_ALREADY_LOGGED_OUT);
        }

        model.setLogoutSuccess();
        model.updateFilteredPersonList(x -> false);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
