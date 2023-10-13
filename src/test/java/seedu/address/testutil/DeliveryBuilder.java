package seedu.address.testutil;

import java.time.LocalDate;

import seedu.address.model.delivery.Delivery;
import seedu.address.model.delivery.DeliveryStatus;
import seedu.address.model.person.Customer;

/**
 * A utility class to help with building Delivery objects.
 */
public class DeliveryBuilder {
    public static final int DEFAULT_ID = 1;
    public static final String DEFAULT_NAME = "Gabriel's Milk";
    public static final Customer DEFAULT_CUSTOMER = new PersonBuilder().withName("Gabriel Seethor")
        .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
        .withPhone("94351253")
        .withTags("friends").build();
    public static final LocalDate DEFAULT_ORDERED_AT = LocalDate.now();
    public static final LocalDate DEFAULT_DELIVERED_AT = LocalDate.of(2023, 12, 12);
    public static final DeliveryStatus DEFAULT_STATUS = DeliveryStatus.PENDING;

    private int deliveryId;
    private String name;
    private Customer customer;
    private LocalDate orderedAt;
    private LocalDate deliveredAt;
    private DeliveryStatus status;


    /**
     * Creates a {@code DeliveryBuilder} with the default details.
     */
    public DeliveryBuilder() {
        this.deliveryId = DEFAULT_ID;
        this.name = DEFAULT_NAME;
        this.customer = DEFAULT_CUSTOMER;
        this.orderedAt = DEFAULT_ORDERED_AT;
        this.deliveredAt = DEFAULT_DELIVERED_AT;
        this.status = DEFAULT_STATUS;
    }

    /**
     * Initializes the DeliveryBuilder with the data of {@code deliveryToCopy}.
     *
     * @param delivery The delivery to copy.
     */
    public DeliveryBuilder(Delivery delivery) {
        this.deliveryId = delivery.getDeliveryId();
        this.name = delivery.getName();
        this.customer = delivery.getCustomer();
        this.orderedAt = delivery.getOrderedAt();
        this.deliveredAt = delivery.getDeliveredAt();
        this.status = delivery.getStatus();
    }

    /**
     * Sets the {@code id} of the {@code Delivery} that we are building.
     *
     * @param id The id to set.
     * @return The DeliveryBuilder with the id set.
     */
    public DeliveryBuilder withId(int id) {
        this.deliveryId = id;
        return this;
    }

    /**
     * Sets the {@code name} of the {@code Delivery} that we are building.
     *
     * @param name The name to set.
     * @return The DeliveryBuilder with the name set.
     */
    public DeliveryBuilder withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Sets the {@code customer} of the {@code Delivery} that we are building.
     *
     * @param customer The customer to set.
     * @return The DeliveryBuilder with the customer set.
     */
    public DeliveryBuilder withCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    /**
     * Sets the {@code orderedAt} of the {@code Delivery} that we are building.
     *
     * @param orderedAt The orderedAt to set.
     * @return The DeliveryBuilder with the orderedAt set.
     */
    public DeliveryBuilder withOrderedAt(LocalDate orderedAt) {
        this.orderedAt = orderedAt;
        return this;
    }

    /**
     * Sets the {@code deliveredAt} of the {@code Delivery} that we are building.
     *
     * @param deliveredAt The deliveredAt to set.
     * @return The DeliveryBuilder with the deliveredAt set.
     */
    public DeliveryBuilder withDeliveredAt(LocalDate deliveredAt) {
        this.deliveredAt = deliveredAt;
        return this;
    }

    /**
     * Sets the {@code status} of the {@code Delivery} that we are building.
     *
     * @param status The status to set.
     * @return The DeliveryBuilder with the status set.
     */
    public DeliveryBuilder withStatus(DeliveryStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Builds the {@code Delivery} with the given parameters.
     *
     * @return The Delivery with the given parameters.
     */
    public Delivery build() {
        return new Delivery(deliveryId, name, customer, orderedAt, deliveredAt, status);
    }
}
