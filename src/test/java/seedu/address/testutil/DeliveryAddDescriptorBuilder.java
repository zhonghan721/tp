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
     * Returns an {@code EditPersonDescriptor} with fields containing {@code person}'s details
     */
    public DeliveryAddDescriptorBuilder(Delivery delivery) {
        descriptor = new DeliveryAddDescriptor();
        descriptor.setDeliveryName(delivery.getName());
        descriptor.setDeliveryDate(delivery.getDeliveryDate());
        descriptor.setCustomerId(delivery.getCustomer().getCustomerId());
    }

    /**
     * Sets the customerId of the {@code EditPersonDescriptor} that we are building.
     */
    public DeliveryAddDescriptorBuilder withDeliveryName(String deliveryName) {
        descriptor.setDeliveryName(new DeliveryName(deliveryName));
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code EditPersonDescriptor} that we are building.
     */
    public DeliveryAddDescriptorBuilder withCustomerId(int customerId) {
        descriptor.setCustomerId(customerId);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code EditPersonDescriptor} that we are building.
     */
    public DeliveryAddDescriptorBuilder withDeliveryDate(String deliveryDate) {
        descriptor.setDeliveryDate(new DeliveryDate(deliveryDate));
        return this;
    }


    public DeliveryAddDescriptor build() {
        return descriptor;
    }
}

