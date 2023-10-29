package seedu.address.testutil;

import seedu.address.logic.commands.delivery.DeliveryAddCommand.DeliveryAddDescriptor;
import seedu.address.model.delivery.Delivery;
import seedu.address.model.delivery.DeliveryDate;
import seedu.address.model.delivery.DeliveryName;

/**
 * A utility class to help with building DeliveryAddDescriptor objects.
 */
public class DeliveryAddDescriptorBuilder {
    private DeliveryAddDescriptor descriptor;

    public DeliveryAddDescriptorBuilder() {
        descriptor = new DeliveryAddDescriptor();
    }

    public DeliveryAddDescriptorBuilder(DeliveryAddDescriptor descriptor) {
        this.descriptor = new DeliveryAddDescriptor(descriptor);
    }

    /**
<<<<<<< HEAD
     * Returns an {@code DeliveryAddDescriptor} with fields containing {@code delivery}'s details
=======
     * Returns an {@code CustomerEditDescriptor} with fields containing {@code person}'s details
>>>>>>> 0c6857649c6d1262a90ba82f836141e6d84e1f19
     */
    public DeliveryAddDescriptorBuilder(Delivery delivery) {
        descriptor = new DeliveryAddDescriptor();
        descriptor.setDeliveryName(delivery.getName());
        descriptor.setDeliveryDate(delivery.getDeliveryDate());
        descriptor.setCustomerId(delivery.getCustomer().getCustomerId());
    }

    /**
<<<<<<< HEAD
     * Sets the {@code DeliveryName} of the {@code DeliveryAddDescriptor} that we are building.
=======
     * Sets the customerId of the {@code CustomerEditDescriptor} that we are building.
>>>>>>> 0c6857649c6d1262a90ba82f836141e6d84e1f19
     */
    public DeliveryAddDescriptorBuilder withDeliveryName(String deliveryName) {
        descriptor.setDeliveryName(new DeliveryName(deliveryName));
        return this;
    }

    /**
<<<<<<< HEAD
     * Sets the customer id of the {@code DeliveryAddDescriptor} that we are building.
=======
     * Sets the {@code Phone} of the {@code CustomerEditDescriptor} that we are building.
>>>>>>> 0c6857649c6d1262a90ba82f836141e6d84e1f19
     */
    public DeliveryAddDescriptorBuilder withCustomerId(int customerId) {
        descriptor.setCustomerId(customerId);
        return this;
    }

    /**
<<<<<<< HEAD
     * Sets the {@code DeliveryDate} of the {@code DeliveryAddDescriptor} that we are building.
=======
     * Sets the {@code Email} of the {@code CustomerEditDescriptor} that we are building.
>>>>>>> 0c6857649c6d1262a90ba82f836141e6d84e1f19
     */
    public DeliveryAddDescriptorBuilder withDeliveryDate(String deliveryDate) {
        descriptor.setDeliveryDate(new DeliveryDate(deliveryDate));
        return this;
    }


    public DeliveryAddDescriptor build() {
        return descriptor;
    }
}


