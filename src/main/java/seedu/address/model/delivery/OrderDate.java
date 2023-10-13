package seedu.address.model.delivery;

import java.time.LocalDate;

import seedu.address.model.date.Date;

/**
 * Represents a Delivery's date in the address book.
 */
public class OrderDate extends Date {

    /**
     * Constructs a {@code DeliveryDate}.
     *
     * @param date A valid date.
     */
    public OrderDate(String date) {
        super(date);
    }

    /**
     * Returns true if a given string is a valid delivery date.
     *
     * @param date A string representing a date.
     * @return True if the date is valid.
     */
    public static boolean isPastDate(String date) {
        LocalDate orderDate = LocalDate.parse(date);
        return orderDate.isBefore(LocalDate.now());
    }

    /**
     * Returns true if a given string is a valid delivery date.
     *
     * @param test A string representing a date.
     * @return True if the date is valid.
     */
    public static boolean isValidOrderDate(String test) {
        return Date.isValidDate(test) && isPastDate(test);
    }
}
