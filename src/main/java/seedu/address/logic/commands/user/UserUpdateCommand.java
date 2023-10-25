package seedu.address.logic.commands.user;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_USER_NOT_AUTHENTICATED;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ANSWER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PASSWORD;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PASSWORD_CONFIRM;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SECRET_QUESTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_USER;

import java.util.Objects;
import java.util.Optional;

import seedu.address.commons.util.CollectionUtil;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.user.Password;
import seedu.address.model.user.User;
import seedu.address.model.user.Username;

/**
 * Updates the user's account details.
 */
public class UserUpdateCommand extends Command {

    public static final String COMMAND_WORD = "update";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Update your account details.\n"
            + "Parameters: "
            + "[" + PREFIX_USER + " USERNAME] "
            + "[" + PREFIX_PASSWORD + " PASSWORD "
            + PREFIX_PASSWORD_CONFIRM + " CONFIRM_PASSWORD] "
            + "[" + PREFIX_SECRET_QUESTION + " SECRET_PASSWORD "
            + PREFIX_ANSWER + " ANSWER]\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_PASSWORD + " yourNewPassword "
            + PREFIX_PASSWORD_CONFIRM + " yourNewPassword ";
    public static final String MESSAGE_SUCCESS = "Update successful.";
    public static final String MESSAGE_MISSING_FIELDS = "Please provide at least one field to update! \n%1$s";
    public static final String MESSAGE_PASSWORD_OR_CONFIRM_PASSWORD_MISSING = "Password and Confirm Password "
            + "have to be either all present or all absent. Try again.";
    public static final String MESSAGE_PASSWORD_MISMATCH = "Passwords do not match. Please try again.";
    public static final String MESSAGE_QUESTION_OR_ANSWER_MISSING = "Secret Question and Answer have to be "
            + "either all present or all absent. Try again.";
    private final UpdateUserDescriptor updateUserDescriptor;

    /**
     * Creates a UserLoginCommand to log in the specified {@code User}
     */
    public UserUpdateCommand(UpdateUserDescriptor updateUserDescriptor) {
        requireNonNull(updateUserDescriptor);
        this.updateUserDescriptor = updateUserDescriptor;
    }

    /**
     * Executes the register user command.
     *
     * @param model {@code Model} which the command should operate on.
     * @return {@code CommandResult} that indicates success.
     * @throws CommandException if the user is already logged in or the user credentials are wrong.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        // User cannot perform this operation before logging in
        if (!model.getUserLoginStatus()) {
            throw new CommandException(MESSAGE_USER_NOT_AUTHENTICATED);
        }

        User storedUser = model.getStoredUser();
        // there should always be a stored user after registering/to be able to log in
        assert storedUser != null;

        User updatedUser = createUpdatedUser(storedUser, updateUserDescriptor);

        model.updateUser(updatedUser);
        return new CommandResult(MESSAGE_SUCCESS, true);
    }

    /**
     * Creates and returns a {@code Person} with the details of {@code personToEdit}
     * edited with {@code editPersonDescriptor}.
     */
    private static User createUpdatedUser(User storedUser, UpdateUserDescriptor updateUserDescriptor) {
        assert storedUser != null;

        Username updatedUsername = updateUserDescriptor.getUsername().orElse(storedUser.getUsername());
        Password updatedPassword = updateUserDescriptor.getPassword().orElse(storedUser.getPassword());
        String updatedSecretQuestion = updateUserDescriptor.getSecretQuestion().orElse(storedUser.getSecretQuestion());
        String updatedAnswer = updateUserDescriptor.getAnswer().orElse(storedUser.getAnswer());

        return new User(updatedUsername, updatedPassword, true, updatedSecretQuestion, updatedAnswer);
    }

    /**
     * Returns true if both users have the same identity and data fields.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof UserUpdateCommand)) {
            return false;
        }

        UserUpdateCommand otherUserUpdateCommand = (UserUpdateCommand) other;
        return updateUserDescriptor.equals(otherUserUpdateCommand.updateUserDescriptor);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("updateUserDescriptor", updateUserDescriptor)
                .toString();
    }

    /**
     * Stores the details to update the user with. Each non-empty field value will replace the
     * corresponding field value of the user.
     */
    public static class UpdateUserDescriptor {
        private Username username;
        private Password password;
        private String secretQuestion;
        private String answer;

        public UpdateUserDescriptor() {
        }

        /**
         * Copy constructor.
         * A defensive copy of {@code tags} is used internally.
         */
        public UpdateUserDescriptor(UpdateUserDescriptor toCopy) {
            setUsername(toCopy.username);
            setPassword(toCopy.password);
            setSecretQuestion(toCopy.secretQuestion);
            setAnswer(toCopy.answer);
        }

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(username, password, secretQuestion, answer);
        }

        public void setUsername(Username username) {
            this.username = username;
        }

        public Optional<Username> getUsername() {
            return Optional.ofNullable(username);
        }

        public void setPassword(Password password) {
            this.password = password;
        }

        public Optional<Password> getPassword() {
            return Optional.ofNullable(password);
        }

        public void setSecretQuestion(String secretQuestion) {
            this.secretQuestion = secretQuestion;
        }

        public Optional<String> getSecretQuestion() {
            return Optional.ofNullable(secretQuestion);
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public Optional<String> getAnswer() {
            return Optional.ofNullable(answer);
        }

        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof UpdateUserDescriptor)) {
                return false;
            }

            UpdateUserDescriptor otherUpdateUserDescriptor = (UpdateUserDescriptor) other;
            return Objects.equals(username, otherUpdateUserDescriptor.username)
                    && Objects.equals(password , otherUpdateUserDescriptor.password)
                    && Objects.equals(secretQuestion, otherUpdateUserDescriptor.secretQuestion)
                    && Objects.equals(answer, otherUpdateUserDescriptor.answer);
        }

        @Override
        public String toString() {
            // does not show password for security reasons
            return new ToStringBuilder(this)
                    .add("username", username)
                    .add("secretQuestion", secretQuestion)
                    .add("answer", answer)
                    .toString();
        }
    }
}
