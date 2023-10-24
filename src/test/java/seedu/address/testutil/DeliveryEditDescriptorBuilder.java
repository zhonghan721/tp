package seedu.address.testutil;

import seedu.address.logic.commands.delivery.DeliveryAddCommand;
import seedu.address.logic.commands.delivery.DeliveryEditCommand;
import seedu.address.logic.commands.delivery.DeliveryEditCommand.DeliveryEditDescriptor;
import seedu.address.model.delivery.*;

public class DeliveryEditDescriptorBuilder {
    private DeliveryEditDescriptor descriptor;

    public DeliveryEditDescriptorBuilder() {
        descriptor = new DeliveryEditDescriptor();
    }

    public DeliveryEditDescriptorBuilder(DeliveryEditDescriptor descriptor) {
        this.descriptor = new DeliveryEditDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditPersonDescriptor} with fields containing {@code person}'s details
     */
    public DeliveryEditDescriptorBuilder(Delivery delivery) {
        descriptor = new DeliveryEditDescriptor();
        descriptor.setDeliveryName(delivery.getName());
        descriptor.setDeliveryDate(delivery.getDeliveryDate());
        descriptor.setCustomerId(delivery.getCustomerId());
        descriptor.setOrderDate(delivery.getOrderDate());
        descriptor.setStatus(delivery.getStatus());
        descriptor.setDeliveryId(delivery.getDeliveryId());
        descriptor.setNote(delivery.getNote());
    }

    /**
     * Sets the customerId of the {@code EditPersonDescriptor} that we are building.
     */
    public DeliveryEditDescriptorBuilder withDeliveryName(String deliveryName) {
        descriptor.setDeliveryName(new DeliveryName(deliveryName));
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code EditPersonDescriptor} that we are building.
     */
    public DeliveryEditDescriptorBuilder withCustomerId(int customerId) {
        descriptor.setCustomerId(customerId);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code EditPersonDescriptor} that we are building.
     */
    public DeliveryEditDescriptorBuilder withDeliveryDate(String deliveryDate) {
        descriptor.setDeliveryDate(new DeliveryDate(deliveryDate));
        return this;
    }

    public DeliveryEditDescriptorBuilder withOrderDate(String orderDate) {
        descriptor.setOrderDate(new OrderDate(orderDate));
        return this;
    }
    public DeliveryEditDescriptorBuilder withStatus(DeliveryStatus status) {
        descriptor.setStatus(status);
        return this;
    }
    public DeliveryEditDescriptorBuilder withNote (String note) {
        descriptor.setNote (new Note (note));
        return this;
    }
    public DeliveryEditDescriptorBuilder withDeliveryId(int deliveryId) {
        descriptor.setDeliveryId(deliveryId);
        return this;
    }



    public DeliveryEditDescriptor build() {
        return descriptor;
    }
}



