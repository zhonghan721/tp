package seedu.address.logic.commands.delivery;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.customer.AddCommand;
import seedu.address.logic.commands.customer.CustomerCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.delivery.Delivery;
import seedu.address.model.person.Customer;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.*;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;

public class DeliveryAddCommand extends DeliveryCommand {

    public static final String COMMAND_WORD = CustomerCommand.COMMAND_WORD + " " + "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a Delivery to the HomeBoss database. "
            + "Parameters: "
            + "DELIVERY_NAME"
            + PREFIX_CUSTOMER_ID + "CUSTOMER_ID "
            + PREFIX_DATE + "DATE\n "
            + "Example: " + COMMAND_WORD + " "
            + "furniture "
            + PREFIX_CUSTOMER_ID + "5 "
            + PREFIX_DATE + "2023-12-03 ";

    public static final String MESSAGE_SUCCESS = "New delivery added: %1$s";
    public static final String MESSAGE_DUPLICATE_DELIVERY = "This delivery already exists in HomeBoss";

    private final Delivery toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Customer}
     */
    public DeliveryAddCommand(Delivery delivery) {
        requireNonNull(delivery);
        toAdd = delivery;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasDelivery(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_DELIVERY);
        }

        model.addDelivery(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(toAdd)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AddCommand)) {
            return false;
        }

        DeliveryAddCommand otherAddCommand = (DeliveryAddCommand) other;
        return toAdd.equals(otherAddCommand.toAdd);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("toAdd", toAdd)
                .toString();
    }
}

}
