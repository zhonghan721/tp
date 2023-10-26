package seedu.address.logic.commands.delivery;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_USER_NOT_AUTHENTICATED;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.delivery.DeliveryNameContainsKeywordsPredicate;

/**
 * Finds and lists all deliveries in delivery book whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class DeliveryFindCommand extends DeliveryCommand {

    public static final String COMMAND_WORD = DeliveryCommand.COMMAND_WORD + " find";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all deliveries whose names contain any of "
        + "the specified keywords (case-insensitive) and displays them as a list with ID numbers.\n"
        + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
        + "Example: " + COMMAND_WORD + " chocolate vanilla";

    private final DeliveryNameContainsKeywordsPredicate predicate;

    public DeliveryFindCommand(DeliveryNameContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        // User cannot perform this operation before logging in
        if (!model.getUserLoginStatus()) {
            throw new CommandException(MESSAGE_USER_NOT_AUTHENTICATED);
        }

        model.updateFilteredDeliveryList(predicate);
        return new CommandResult(
            String.format(Messages.MESSAGE_DELIVERY_LISTED_OVERVIEW,
                model.getFilteredDeliveryList().size()), true);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof DeliveryFindCommand)) {
            return false;
        }
        DeliveryFindCommand otherDeliveryFindCommand = (DeliveryFindCommand) other;
        return predicate.equals(otherDeliveryFindCommand.predicate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .add("predicate", predicate)
            .toString();
    }
}