package seedu.address.logic.commands.user;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ANSWER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PASSWORD;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PASSWORD_CONFIRM;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SECRET_QUESTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_USER;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_CUSTOMERS;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.user.User;

/**
 * Logs in the user and allows the user to access other functionalities.
 */
public class UserRegisterCommand extends Command {

    public static final String COMMAND_WORD = "register";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Register an account for HomeBoss.\n"
            + "Parameters: "
            + PREFIX_USER + " USER " + PREFIX_PASSWORD + " PASSWORD " + PREFIX_PASSWORD_CONFIRM
            + " CONFIRM_PASSWORD " + PREFIX_SECRET_QUESTION + " SECRET_QUESTION " + PREFIX_ANSWER
            + " ANSWER\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_USER + " yourUsername "
            + PREFIX_PASSWORD + " yourPassword "
            + PREFIX_PASSWORD_CONFIRM + " yourPassword"
            + PREFIX_SECRET_QUESTION + " yourSecretQuestion "
            + PREFIX_ANSWER + " yourAnswer";
    public static final String MESSAGE_SUCCESS = "Registration successful. Welcome to HomeBoss!";
    public static final String MESSAGE_PASSWORD_MISMATCH = "Passwords do not match. Please try again.";
    public static final String MESSAGE_ALREADY_HAVE_ACCOUNT = "You have an account already with username %s. ";

    private final User user;

    /**
     * Creates a UserRegisterCommand to log in the specified {@code User}
     */
    public UserRegisterCommand(User user) {
        requireNonNull(user);
        this.user = user;
    }

    /**
     * Executes the register user command.
     *
     * @param model {@code Model} which the command should operate on.
     * @return {@code CommandResult} that indicates success.
     * @throws CommandException if the user is already logged in or the user credentials are wrong.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        User storedUser = model.getStoredUser();

        // Logged in user cannot register
        if (storedUser != null) {
            throw new CommandException(String.format(MESSAGE_ALREADY_HAVE_ACCOUNT, storedUser.getUsername()));
        }

        model.registerUser(this.user);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_CUSTOMERS);
        return new CommandResult(MESSAGE_SUCCESS, true);
    }

    /**
     * Returns true if both users have the same identity and data fields.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof UserRegisterCommand)) {
            return false;
        }

        UserRegisterCommand otherUserRegisterCommand = (UserRegisterCommand) other;
        return user.equals(otherUserRegisterCommand.user);
    }
}
