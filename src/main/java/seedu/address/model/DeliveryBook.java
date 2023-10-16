package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.Optional;

import javafx.collections.ObservableList;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.delivery.Delivery;
import seedu.address.model.delivery.UniqueDeliveryList;

/**
 * Wraps all data at the book level
 * Duplicates are not allowed (by .isSameDelivery comparison)
 */
public class DeliveryBook implements ReadOnlyBook<Delivery> {

    private final UniqueDeliveryList deliveries;

    public DeliveryBook() {
        deliveries = new UniqueDeliveryList();
    }

    /**
     * Creates an Book using the Data in the {@code toBeCopied}
     */
    public DeliveryBook(ReadOnlyBook<Delivery> toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the delivery list with {@code deliveryList}.
     * {@code deliveryList} must not contain duplicate deliveries.
     */
    public void setDeliveries(List<Delivery> deliveryList) {
        this.deliveries.setDeliveries(deliveryList);
    }

    /**
     * Resets the existing data of this {@code Book} with {@code newData}.
     */
    public void resetData(ReadOnlyBook<Delivery> newData) {
        requireNonNull(newData);

        setDeliveries(newData.getList());
    }

    //// person-level operations

    /**
     * Returns true if a delivery with the same identity as {@code person} exists in the book.
     */
    public boolean hasDelivery(Delivery delivery) {
        requireNonNull(delivery);
        return deliveries.contains(delivery);
    }

    /**
     * Adds a delivery to the book.
     * The delivery must not already exist in the book.
     */
    public void addDelivery(Delivery d) {
        deliveries.add(d);
    }

    /**
     * Replaces the given delivery {@code target} in the list with {@code editedDelivery}.
     * {@code target} must exist in the book.
     * The person identity of {@code editedDelivery} must not be the same as another existing delivery in the book.
     */
    public void setDelivery(Delivery target, Delivery editedDelivery) {
        requireNonNull(editedDelivery);

        deliveries.setDelivery(target, editedDelivery);
    }

    /**
     * Removes {@code delivery} from this {@code Book}.
     * {@code key} must exist in the book.
     */
    public void removeDelivery(Delivery key) {
        deliveries.remove(key);
    }

    //// util methods

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .add("deliveries", deliveries)
            .toString();
    }

    @Override
    public ObservableList<Delivery> getList() {
        return deliveries.asUnmodifiableObservableList();
    }

    /**
     * Returns the item with the specified id if it exists
     *
     * @param id the id of the item
     * @return the item specified by the id
     */
    @Override
    public Optional<Delivery> getById(int id) {
        return deliveries.getById(id);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof DeliveryBook)) {
            return false;
        }

        DeliveryBook otherDeliveryBook = (DeliveryBook) other;
        return deliveries.equals(otherDeliveryBook.deliveries);
    }

    @Override
    public int hashCode() {
        return deliveries.hashCode();
    }
}
