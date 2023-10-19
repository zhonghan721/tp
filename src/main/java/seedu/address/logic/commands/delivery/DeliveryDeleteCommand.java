package seedu.address.logic.commands.delivery;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.delivery.Delivery;

/**
 * Deletes a delivery identified using it's displayed index from the address book.
 */
public class DeliveryDeleteCommand extends DeliveryCommand {

    public static final String COMMAND_WORD = DeliveryCommand.COMMAND_WORD + " " + "delete";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the delivery identified by the index number used in the displayed delivery list.\n"
            + "Parameters: DELIVERY_ID (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 0001";

    public static final String MESSAGE_DELETE_DELIVERY_SUCCESS = "Deleted Delivery: %1$s";

    private final Index targetIndex;

    public DeliveryDeleteCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Delivery> lastShownList = model.getFilteredDeliveryList();;

        boolean found = false;
        Delivery deliveryToDelete = null;
        for (Delivery delivery : lastShownList) {
            if (delivery.getDeliveryId() == targetIndex.getOneBased()) {
                found = true;
                deliveryToDelete = delivery;
                break;
            }
        }

        if (found && deliveryToDelete != null) {
            model.deleteDelivery(deliveryToDelete);
            return new CommandResult(String.format(MESSAGE_DELETE_DELIVERY_SUCCESS,
                    Messages.format(deliveryToDelete)));
        } else {
            throw new CommandException(Messages.MESSAGE_INVALID_DELIVERY_DISPLAYED_INDEX);
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof DeliveryDeleteCommand)) {
            return false;
        }

        DeliveryDeleteCommand otherDeleteCommand = (DeliveryDeleteCommand) other;
        return targetIndex.equals(otherDeleteCommand.targetIndex);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("targetIndex", targetIndex)
                .toString();
    }
}
