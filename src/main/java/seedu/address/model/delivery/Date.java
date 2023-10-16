package seedu.address.model.delivery;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDate;

/**
 * Represents a Date in the address book.
 */
public class Date {
    public static final String MESSAGE_CONSTRAINTS =
        "Order dates should be in the format YYYY-MM-DD";

    public static final String VALIDATION_REGEX = "\\d{4}-\\d{2}-\\d{2}";

    public final LocalDate date;

    /**
     * Constructs a {@code DeliveryDate}.
     *
     * @param date A valid date.
     */
    public Date(String date) {
        requireNonNull(date);
        checkArgument(isValidDate(date), MESSAGE_CONSTRAINTS);
        this.date = LocalDate.parse(date);
    }

    /**
     * Returns true if a given string is a valid date.
     *
     * @param test The string to test.
     * @return True if the string is a valid date.
     */
    public static boolean isValidDate(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return date.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof Date)) {
            return false;
        }

        Date o = (Date) other;
        return date.getYear() == o.date.getYear()
            && date.getMonth() == o.date.getMonth()
            && date.getDayOfMonth() == o.date.getDayOfMonth();
    }

    @Override
    public int hashCode() {
        return date.hashCode();
    }
}
