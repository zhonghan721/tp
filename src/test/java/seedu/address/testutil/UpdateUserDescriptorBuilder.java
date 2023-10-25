package seedu.address.testutil;

import seedu.address.logic.commands.user.UserUpdateCommand.UpdateUserDescriptor;
import seedu.address.model.user.Password;
import seedu.address.model.user.User;
import seedu.address.model.user.Username;

/**
 * A utility class to help with building EditPersonDescriptor objects.
 */
public class UpdateUserDescriptorBuilder {

    private UpdateUserDescriptor descriptor;

    public UpdateUserDescriptorBuilder() {
        descriptor = new UpdateUserDescriptor();
    }

    public UpdateUserDescriptorBuilder(UpdateUserDescriptor descriptor) {
        this.descriptor = new UpdateUserDescriptor(descriptor);
    }

    /**
     * Returns a {@code UpdateUserDescriptor} with fields containing {@code User}'s details
     */
    public UpdateUserDescriptorBuilder(User user) {
        descriptor = new UpdateUserDescriptor();
        descriptor.setUsername(user.getUsername());
        descriptor.setPassword(user.getPassword());
        descriptor.setSecretQuestion(user.getSecretQuestion());
        descriptor.setAnswer(user.getAnswer());
    }

    /**
     * Sets the {@code Username} of the {@code UpdateUserDescriptor} that we are building.
     */
    public UpdateUserDescriptorBuilder withUsername(String username) {
        descriptor.setUsername(new Username(username));
        return this;
    }

    /**
     * Sets the {@code Password} of the {@code UpdateUserDescriptor} that we are building.
     */
    public UpdateUserDescriptorBuilder withPassword(String password) {
        descriptor.setPassword(new Password(password));
        return this;
    }

    /**
     * Sets the secretQuestion of the {@code UpdateUserDescriptor} that we are building.
     */
    public UpdateUserDescriptorBuilder withSecretQuestion(String secretQuestion) {
        descriptor.setSecretQuestion(secretQuestion);
        return this;
    }

    /**
     * Sets the answer of the {@code UpdateUserDescriptor} that we are building.
     */
    public UpdateUserDescriptorBuilder withAnswer(String answer) {
        descriptor.setAnswer(answer);
        return this;
    }

    public UpdateUserDescriptor build() {
        return descriptor;
    }
}

