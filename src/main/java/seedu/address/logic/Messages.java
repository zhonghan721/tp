package seedu.address.logic;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.parser.Prefix;
import seedu.address.model.delivery.Delivery;
import seedu.address.model.person.Customer;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_PERSON_DISPLAYED_INDEX = "The person index provided is invalid";
    public static final String MESSAGE_INVALID_DELIVERY_DISPLAYED_INDEX = "The delivery index provided is invalid";
    public static final String MESSAGE_INVALID_DELIVERY_ID = "The delivery ID provided is invalid";
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%1$d persons listed!";
    public static final String MESSAGE_DUPLICATE_FIELDS = "Multiple values specified for the following"
            + "single-valued field(s): ";

    public static final String MESSAGE_USER_NOT_AUTHENTICATED = "Access denied! You are currently not logged in.";

    public static final String MESSAGE_INVALID_DELIVERY_DATE =
            "Delivery Date cannot be before today.";

    /**
     * Returns an error message indicating the duplicate prefixes.
     */
    public static String getErrorMessageForDuplicatePrefixes(Prefix... duplicatePrefixes) {
        assert duplicatePrefixes.length > 0;

        Set<String> duplicateFields =
                Stream.of(duplicatePrefixes).map(Prefix::toString).collect(Collectors.toSet());

        return MESSAGE_DUPLICATE_FIELDS + String.join(" ", duplicateFields);
    }

    /**
     * Formats the {@code person} for display to the user.
     */
    public static String formatCustomer(Customer customer) {
        final StringBuilder builder = new StringBuilder();
        builder.append(customer.getName())
                .append("; Phone: ")
                .append(customer.getPhone())
                .append("; Email: ")
                .append(customer.getEmail())
                .append("; Address: ")
                .append(customer.getAddress())
                .append("; Tags: ");
        customer.getTags().forEach(builder::append);
        return builder.toString();
    }

    /**
     * <<<<<<< HEAD
     * Formats the {@code delivery} for display to the user.
     */
    public static String formatDelivery(Delivery delivery) {
        final StringBuilder builder = new StringBuilder();
        builder.append(delivery.getName())
                .append("; Customer Name: ")
                .append(delivery.getCustomer().getName())
                .append("; Delivery Id: ")
                .append(delivery.getDeliveryId())
                .append("; Delivery Date: ")
                .append(delivery.getDeliveryDate())
                .append("; Order Date: ")
                .append(delivery.getOrderDate());
        return builder.toString();
    }
}

