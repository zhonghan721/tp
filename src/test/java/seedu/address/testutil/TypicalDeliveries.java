package seedu.address.testutil;

import seedu.address.model.delivery.Delivery;

/**
 * A utility class containing a list of {@code Delivery} objects to be used in tests.
 */
public class TypicalDeliveries {
    public static final Delivery GABRIELS_MILK = new DeliveryBuilder().withId(1).withName("Gabriel Milk")
        .withCustomer(TypicalPersons.ALICE).build();

    public static final Delivery GAMBES_RICE = new DeliveryBuilder().withId(2).withName("Gambe Rice")
        .withCustomer(TypicalPersons.BENSON).build();
}
