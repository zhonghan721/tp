package seedu.address.testutil;

import seedu.address.logic.commands.customer.CustomerEditCommand;
import seedu.address.logic.commands.delivery.DeliveryEditCommand;
import seedu.address.logic.commands.delivery.DeliveryEditCommand.DeliveryEditDescriptor;
import seedu.address.model.tag.Tag;

import java.util.Set;

import static seedu.address.logic.parser.CliSyntax.*;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

public class DeliveryUtil {
    public static String getEditDeliveryDescriptorDetails(DeliveryEditDescriptor descriptor) {
        StringBuilder sb = new StringBuilder();
        descriptor.getDeliveryName().ifPresent(name -> sb.append(PREFIX_NAME).append(name).append(" "));
        descriptor.getCustomerId().ifPresent(customerId -> sb.append(PREFIX_CUSTOMER_ID).append(customerId).append(
                " "));
        descriptor.getDeliveryDate().ifPresent(deliveryDate -> sb.append(PREFIX_DATE).append(deliveryDate).append(" "));
        descriptor.getNote().ifPresent(note -> sb.append(PREFIX_NOTE).append(note).append(" "));
        descriptor.getStatus().ifPresent(status -> sb.append(PREFIX_STATUS).append(status).append(" "));

        return sb.toString();
    }
}
