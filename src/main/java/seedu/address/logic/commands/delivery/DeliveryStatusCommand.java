package seedu.address.logic.commands.delivery;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.delivery.DeliveryStatus;

/**
 * Represents a Command to update DeliveryStatus
 */
public class DeliveryStatusCommand extends DeliveryCommand {

    public static final String COMMAND_WORD = DeliveryCommand.COMMAND_WORD + " " + "status";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the status of the delivery identified "
            + "by the ID of the delivery. Existing status will be overwritten by the input status.\n"
            + "Parameters: STATUS (must be one of SHIPPED/COMPLETED/CANCELLED) "
            + "ID (must be a integer representing a valid ID)\n"
            + "Example: " + COMMAND_WORD + "COMPLETED 1";

    private final int targetId;
    private final DeliveryStatus updatedStatus;

    /**
     * Constructor for a DeliveryStatus Command.
     * @param targetId target delivery to update.
     * @param updatedStatus new status to update with.
     */
    public DeliveryStatusCommand(int targetId, DeliveryStatus updatedStatus) {
        requireNonNull(updatedStatus);

        this.targetId = targetId;
        this.updatedStatus = updatedStatus;
    }
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        throw new CommandException("Command not implemented");
    }
}
