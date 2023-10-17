package seedu.address.logic.commands.customer;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_USER_NOT_AUTHENTICATED;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_CUSTOMERS;

import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Lists all customers in the address book to the user.
 */
public class CustomerListCommand extends CustomerCommand {

    public static final String COMMAND_WORD = CustomerCommand.COMMAND_WORD + " " + "list";
    public static final String MESSAGE_SUCCESS = "Listed all Customers";


    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        // User cannot perform this operation before logging in
        if (!model.getUserLoginStatus()) {
            throw new CommandException(MESSAGE_USER_NOT_AUTHENTICATED);
        }

        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_CUSTOMERS);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
