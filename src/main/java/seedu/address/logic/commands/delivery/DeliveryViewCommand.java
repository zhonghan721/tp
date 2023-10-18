package seedu.address.logic.commands.delivery;

import static seedu.address.logic.Messages.MESSAGE_INVALID_DELIVERY_ID;

import java.util.Optional;

import seedu.address.logic.Messages;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.delivery.Delivery;

/**
 * Represents a DeliveryViewCommand which displays a single delivery order.
 */
public class DeliveryViewCommand extends DeliveryCommand {

    public static final String COMMAND_WORD = DeliveryCommand.COMMAND_WORD + " view";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Displays a single delivery order.\n"
        + "Parameters: "
        + "DELIVERY_ID\n"
        + "Example: " + COMMAND_WORD + " "
        + "1";

    public static final String MESSAGE_SUCCESS = "Delivery order displayed: %1$s";

    private final int deliveryId;

    /**
     * Creates a DeliveryViewCommand to display the specified {@code Delivery}.
     */
    public DeliveryViewCommand(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        Optional<Delivery> delivery = model.getDelivery(deliveryId);

        if (delivery.isEmpty()) {
            throw new CommandException(String.format(MESSAGE_INVALID_DELIVERY_ID, deliveryId));
        }

        return new CommandResult(Messages.format(delivery.get()));
    }
}
