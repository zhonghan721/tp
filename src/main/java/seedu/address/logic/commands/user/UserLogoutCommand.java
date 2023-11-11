package seedu.address.logic.commands.user;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_NO_CUSTOMERS;
import static seedu.address.model.Model.PREDICATE_SHOW_NO_DELIVERIES;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Logs out the user.
 */
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

        // Set status in model to logged out, and update filtered lists
        model.setLogoutSuccess();
        model.updateFilteredCustomerList(PREDICATE_SHOW_NO_CUSTOMERS);
        model.updateFilteredDeliveryList(PREDICATE_SHOW_NO_DELIVERIES);
        // Display the updated empty list
        model.setUiListCustomer();
        return new CommandResult(MESSAGE_SUCCESS, true);
    }
}
