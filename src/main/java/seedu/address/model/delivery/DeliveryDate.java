package seedu.address.model.delivery;

import java.time.LocalDate;

/**
 * Represents a Delivery's delivery date in the delivery list.
 */
public class DeliveryDate extends Date {

    /**
     * Constructs a {@code DeliveryDate}.
     *
     * @param date A valid date.
     */
    public DeliveryDate(String date) {
        super(date);
    }

    /**
     * Returns true if a given string is a valid delivery date.
     *
     * @param date A string representing a date.
     * @return True if the date is valid.
     */
    public static boolean isFutureDate(String date) {
        LocalDate deliveryDate = LocalDate.parse(date);
        return deliveryDate.isAfter(LocalDate.now());
    }

    /**
     * Returns true if a given string is a valid delivery date.
     *
     * @param test A string representing a date.
     * @return True if the date is valid.
     */
    public static boolean isValidDeliveryDate(String test) {
        return Date.isValidDate(test) && isFutureDate(test);
    }
}
