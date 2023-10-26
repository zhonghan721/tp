package seedu.address.logic.commands.customer;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_USER_NOT_AUTHENTICATED;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Customer;

/**
 * Deletes a person identified using it's displayed index from the address book.
 */
public class CustomerDeleteCommand extends CustomerCommand {

    public static final String COMMAND_WORD = CustomerCommand.COMMAND_WORD + " " + "delete";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the customer identified by the index number used in the displayed customer list.\n"
            + "Parameters: CUSTOMER_ID (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 0001";

    public static final String MESSAGE_DELETE_PERSON_SUCCESS = "Deleted Person: %1$s";

    private final Index targetIndex;

    public CustomerDeleteCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        // User cannot perform this operation before logging in
        if (!model.getUserLoginStatus()) {
            throw new CommandException(MESSAGE_USER_NOT_AUTHENTICATED);
        }

        List<Customer> lastShownList = model.getFilteredPersonList();

        // Instead of the above, loop through the list, and check if the customer ID matches
        boolean found = false;
        Customer customerToDelete = null;
        for (Customer customer : lastShownList) {
            if (customer.getCustomerId() == targetIndex.getOneBased()) {
                found = true;
                customerToDelete = customer;
                break;
            }
        }

        if (found && customerToDelete != null) {
            model.deletePerson(customerToDelete);
            // delete all deliveries associated with this customer
            // then refresh lists

            model.deleteDeliveryByCustomer(customerToDelete);
            return new CommandResult(String.format(MESSAGE_DELETE_PERSON_SUCCESS,
                    Messages.format(customerToDelete)), true);
        } else {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }
        
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CustomerDeleteCommand)) {
            return false;
        }

        CustomerDeleteCommand otherDeleteCommand = (CustomerDeleteCommand) other;
        return targetIndex.equals(otherDeleteCommand.targetIndex);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("targetIndex", targetIndex)
                .toString();
    }
}
