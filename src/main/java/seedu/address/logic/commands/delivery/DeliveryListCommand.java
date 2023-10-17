package seedu.address.logic.commands.delivery;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_DELIVERIES;

import java.util.Comparator;
import java.util.List;

import seedu.address.logic.Sort;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;
import seedu.address.model.delivery.Delivery;
import seedu.address.model.delivery.DeliveryStatus;

/**
 * Lists all deliveries in the delivery list to the user.
 */
public class DeliveryListCommand extends DeliveryCommand {
    public static final String COMMAND_WORD = DeliveryCommand.COMMAND_WORD + " " + "list";
    public static final String MESSAGE_SUCCESS = "Listed all Deliveries";

    private DeliveryStatus status;
    private Sort sortType = Sort.ASC;

    /**
     * Default constructor for a DeliveryList Command with status filter and ascending sort.
     *
     * @param status status to filter by.
     */
    public DeliveryListCommand(DeliveryStatus status) {
        this.status = status;
    }

    /**
     * Constructor for a DeliveryList Command with status filter and sort type.
     *
     * @param status   status to filter by.
     * @param sortType asc or desc.
     */
    public DeliveryListCommand(DeliveryStatus status, Sort sortType) {
        this(status);
        this.sortType = sortType;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredDeliveryList(PREDICATE_SHOW_ALL_DELIVERIES);

        if (status != null) {
            // filter by status
            model.updateFilteredDeliveryList(delivery -> delivery.getStatus().equals(status));
        }

        // sort
        model.sortFilteredDeliveryList(
            sortType.equals("asc") ? Comparator.comparing(Delivery::getName) : Comparator.comparing(Delivery::getName)
                .reversed());

        List<Delivery> deliveryList = model.getSortedDeliveryList();

        //TODO: UI
        return new CommandResult(MESSAGE_SUCCESS);
    }

    @Override
    public boolean equals(Object other) {

        if (other == this) {
            return true;
        }

        if (!(other instanceof DeliveryListCommand)) {
            return false;
        }

        DeliveryListCommand otherCommand = (DeliveryListCommand) other;

        return otherCommand.status == this.status && otherCommand.sortType.equals(this.sortType);
    }
}
