package seedu.address.model.delivery;

import java.time.LocalDate;
import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.Customer;

/**
 * Represents a Delivery in the address book.
 */
public class Delivery {
    // Delivery ID Generation
    private static int deliveryCount;

    // Identity fields
    private final int deliveryId;
    private final String name;
    private final Customer customer;
    private LocalDate orderedAt;
    private LocalDate deliveredAt;
    private DeliveryStatus status;

    /**
     * Constructor for Delivery.
     * Every field must be present and not null.
     *
     * @param name     The name of the delivery.
     * @param customer The customer who ordered the delivery.
     */
    public Delivery(String name, Customer customer) {
        this.deliveryId = Delivery.deliveryCount++;
        this.name = name;
        this.customer = customer;
        this.status = DeliveryStatus.PENDING;
    }

    /**
     * Constructor for Delivery.
     *
     * @param deliveryId  The ID of the delivery.
     * @param name        The name of the delivery.
     * @param customer    The customer who ordered the delivery.
     * @param orderedAt   The date the delivery was ordered.
     * @param deliveredAt The date the delivery was delivered.
     * @param status      The status of the delivery.
     */
    public Delivery(int deliveryId, String name, Customer customer, LocalDate orderedAt, LocalDate deliveredAt,
                    DeliveryStatus status) {
        Delivery.deliveryCount = Math.max(deliveryCount, deliveryId + 1);
        this.deliveryId = deliveryId;
        this.name = name;
        this.customer = customer;
        this.orderedAt = orderedAt;
        this.deliveredAt = deliveredAt;
        this.status = status;
    }

    public void setOrderedAt(LocalDate orderedAt) {
        this.orderedAt = orderedAt;
    }

    public void setDeliveredAt(LocalDate deliveredAt) {
        this.deliveredAt = deliveredAt;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public String getName() {
        return name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getOrderedAt() {
        return orderedAt;
    }

    public LocalDate getDeliveredAt() {
        return deliveredAt;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    /**
     * Returns true if both deliveries have the same identity and data fields.
     *
     * @param otherDelivery The other delivery to compare with.
     * @return True if both deliveries have the same identity and data fields.
     */
    public boolean isSameDelivery(Delivery otherDelivery) {
        if (otherDelivery == this) {
            return true;
        }

        return otherDelivery != null
            && otherDelivery.getDeliveryId() == getDeliveryId()
            && otherDelivery.getName().equals(getName())
            && otherDelivery.getCustomer().equals(getCustomer())
            && otherDelivery.getOrderedAt().equals(getOrderedAt())
            && otherDelivery.getDeliveredAt().equals(getDeliveredAt())
            && otherDelivery.getStatus().equals(getStatus());
    }

    /**
     * Returns true if both deliveries have the same identity fields.
     *
     * @param other The other delivery to compare with.
     * @return True if both deliveries have the same identity fields.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Delivery)) {
            return false;
        }

        Delivery otherDelivery = (Delivery) other;

        return otherDelivery.getDeliveryId() == getDeliveryId()
            && otherDelivery.getName().equals(getName())
            && otherDelivery.getCustomer().equals(getCustomer())
            && otherDelivery.getOrderedAt().equals(getOrderedAt())
            && otherDelivery.getDeliveredAt().equals(getDeliveredAt())
            && otherDelivery.getStatus().equals(getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryId, name, customer, orderedAt, deliveredAt);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("deliveryId", deliveryId)
            .add("name", name)
            .add("customer", customer)
            .add("orderedAt", orderedAt)
            .add("deliveredAt", deliveredAt)
            .toString();
    }
}
