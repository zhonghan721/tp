package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.DeliveryBook;
import seedu.address.model.delivery.Delivery;

/**
 * A utility class containing a list of {@code Delivery} objects to be used in tests.
 */
public class TypicalDeliveries {
    public static final Delivery GABRIELS_MILK = new DeliveryBuilder().withId(1).withName("Gabriel Milk")
        .withCustomer(TypicalPersons.ALICE).withNote("Note").withOrderDate("2021-12-12").build();

    public static final Delivery GAMBES_RICE = new DeliveryBuilder().withId(2).withName("Gambe Rice")
        .withCustomer(TypicalPersons.BENSON).withOrderDate("2021-12-12").build();

    public static final Delivery JY_CAKE = new DeliveryBuilder().withId(3).withName("Jian Yang Cake")
        .withCustomer(TypicalPersons.BENSON).withNote("Note").build();

    private TypicalDeliveries() {
    } // prevents instantiation

    /**
     * Returns an {@code DeliveryBook} with all the typical deliveries.
     */
    public static DeliveryBook getTypicalDeliveryBook() {
        DeliveryBook db = new DeliveryBook();
        for (Delivery delivery : getTypicalDeliveries()) {
            db.addDelivery(delivery);
        }
        return db;
    }

    public static List<Delivery> getTypicalDeliveries() {
        return new ArrayList<>(Arrays.asList(GABRIELS_MILK, GAMBES_RICE));
    }
}
