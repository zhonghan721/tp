package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PASSWORD;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PASSWORD_CONFIRM;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SORT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STATUS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.CliSyntax.PREFIX_USER;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.customer.CustomerEditCommand.EditPersonDescriptor;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.person.Customer;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.testutil.EditPersonDescriptorBuilder;


/**
 * Contains helper methods for testing commands.
 */
public class CommandTestUtil {

    // Delivery
    public static final String VALID_VIEW_DELIVERY_ID = " 1";
    public static final String INVALID_VIEW_DELIVERY_ID = "11";
    public static final String VALID_NAME_GABRIELS_MILK = "Gabriel Milk";
    public static final String VALID_NAME_JAMES_MILK = "Jame Milk";
    public static final String INVALID_NOTE = "";
    public static final String VALID_NOTE = "VALID NOTE";
    public static final String INVALID_STATUS = "INVALID";
    public static final String VALID_STATUS_CREATED = "CREATED";
    public static final String VALID_STATUS_SHIPPED = "SHIPPED";
    public static final String VALID_STATUS_COMPLETED = "COMPLETED";
    public static final String VALID_STATUS_CANCELLED = "CANCELLED";
    public static final String INVALID_ID_NEGATIVE = "-1";
    public static final String INVALID_ID_NAN = "NaN";

    // Customer
    public static final String VALID_NAME_AMY = "Amy Bee";
    public static final String VALID_NAME_BOB = "Bob Choo";
    public static final String VALID_PHONE_AMY = "11111111";
    public static final String VALID_PHONE_BOB = "22222222";
    public static final String VALID_EMAIL_AMY = "amy@example.com";
    public static final String VALID_EMAIL_BOB = "bob@example.com";
    public static final String VALID_ADDRESS_AMY = "Block 312, Amy Street 1";
    public static final String VALID_ADDRESS_BOB = "Block 123, Bobby Street 3";
    public static final String VALID_TAG_HUSBAND = "husband";
    public static final String VALID_TAG_FRIEND = "friend";
    public static final String VALID_USERNAME_AARON = "aAron1sMe";
    public static final String VALID_USERNAME_FOODBEAR = "FoodBear";
    // password string is qwerty1234
    public static final String VALID_PASSWORD_AARON = "qwerty1234";
    public static final String VALID_HASHED_PASSWORD_AARON =
            "17F80754644D33AC685B0842A402229ADBB43FC9312F7BDF36BA24237A1F1FFB";
    // password string is BEARYf00d
    public static final String VALID_PASSWORD_FOODBEAR = "BEARYf00d";
    public static final String VALID_HASHED_PASSWORD_FOODBEAR =
            "26CC1E3D7988F3AE6FB06859123B5046A5A84D47611092037E059F66E1C0E461";

    public static final String NAME_DESC_AMY = " " + PREFIX_NAME + VALID_NAME_AMY;
    public static final String NAME_DESC_BOB = " " + PREFIX_NAME + VALID_NAME_BOB;
    public static final String PHONE_DESC_AMY = " " + PREFIX_PHONE + VALID_PHONE_AMY;
    public static final String PHONE_DESC_BOB = " " + PREFIX_PHONE + VALID_PHONE_BOB;
    public static final String EMAIL_DESC_AMY = " " + PREFIX_EMAIL + VALID_EMAIL_AMY;
    public static final String EMAIL_DESC_BOB = " " + PREFIX_EMAIL + VALID_EMAIL_BOB;
    public static final String ADDRESS_DESC_AMY = " " + PREFIX_ADDRESS + VALID_ADDRESS_AMY;
    public static final String ADDRESS_DESC_BOB = " " + PREFIX_ADDRESS + VALID_ADDRESS_BOB;
    public static final String TAG_DESC_FRIEND = " " + PREFIX_TAG + VALID_TAG_FRIEND;
    public static final String TAG_DESC_HUSBAND = " " + PREFIX_TAG + VALID_TAG_HUSBAND;
    public static final String USERNAME_DESC_AARON = " " + PREFIX_USER + VALID_USERNAME_AARON;
    public static final String USERNAME_DESC_FOODBEAR = " " + PREFIX_USER + VALID_USERNAME_FOODBEAR;
    public static final String PASSWORD_DESC_AARON = " " + PREFIX_PASSWORD + VALID_PASSWORD_AARON;
    public static final String PASSWORD_CONFIRM_DESC_AARON = " " + PREFIX_PASSWORD_CONFIRM + VALID_PASSWORD_AARON;
    public static final String PASSWORD_DESC_FOODBEAR = " " + PREFIX_PASSWORD + VALID_PASSWORD_FOODBEAR;
    public static final String PASSWORD_CONFIRM_DESC_FOODBEAR = " " + PREFIX_PASSWORD_CONFIRM + VALID_PASSWORD_FOODBEAR;

    public static final String INVALID_NAME_DESC = " " + PREFIX_NAME + "James&"; // '&' not allowed in names
    public static final String INVALID_PHONE_DESC = " " + PREFIX_PHONE + "911a"; // 'a' not allowed in phones
    public static final String INVALID_EMAIL_DESC = " " + PREFIX_EMAIL + "bob!yahoo"; // missing '@' symbol
    public static final String INVALID_ADDRESS_DESC = " " + PREFIX_ADDRESS; // empty string not allowed for addresses
    public static final String INVALID_TAG_DESC = " " + PREFIX_TAG + "hubby*"; // '*' not allowed in tags

    public static final String INVALID_USERNAME_DESC = " " + PREFIX_USER
        + "thisIs^myName"; // '^' not allowed in username
    public static final String INVALID_PASSWORD_DESC = " " + PREFIX_PASSWORD + "qwerty"; // lesser than 8 characters
    public static final String INVALID_PASSWORD_CONFIRM_DESC = " " + PREFIX_PASSWORD_CONFIRM + "qwerty";
    public static final String PREAMBLE_WHITESPACE = "\t  \r  \n";
    public static final String PREAMBLE_NON_EMPTY = "NonEmptyPreamble";

    public static final String VALID_DELIVERY_LIST_ALL = " " + PREFIX_STATUS + "all";
    public static final String VALID_DELIVERY_LIST_CREATED = " " + PREFIX_STATUS + "created";
    public static final String VALID_DELIVERY_LIST_SHIPPED = " " + PREFIX_STATUS + "SHIPPED";
    public static final String VALID_DELIVERY_LIST_COMPLETED = " " + PREFIX_STATUS + "completed";
    public static final String VALID_DELIVERY_LIST_CANCELLED = " " + PREFIX_STATUS + "cancelled";

    public static final String INVALID_DELIVERY_LIST = " " + PREFIX_STATUS + "invalid";
    public static final String VALID_DELIVERY_LIST_SORT_ASC = " " + PREFIX_SORT + "asc";
    public static final String VALID_DELIVERY_LIST_SORT_DESC = " " + PREFIX_SORT + "desc";
    public static final String INVALID_DELIVERY_LIST_SORT = " " + PREFIX_SORT + "invalid";
    public static final EditPersonDescriptor DESC_AMY;
    public static final EditPersonDescriptor DESC_BOB;

    static {
        DESC_AMY = new EditPersonDescriptorBuilder().withName(VALID_NAME_AMY)
            .withPhone(VALID_PHONE_AMY).withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY)
            .withTags(VALID_TAG_FRIEND).build();
        DESC_BOB = new EditPersonDescriptorBuilder().withName(VALID_NAME_BOB)
            .withPhone(VALID_PHONE_BOB).withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB)
            .withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND).build();
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel}
     */
    public static void assertCommandSuccess(Command command, Model actualModel, CommandResult expectedCommandResult,
                                            Model expectedModel) {
        try {
            CommandResult result = command.execute(actualModel);
            assertEquals(expectedCommandResult, result);
            assertEquals(expectedModel, actualModel);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandResult, Model)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccess(Command command, Model actualModel, String expectedMessage,
                                            Model expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandResult, Model)}
     * that takes a string {@code expectedMessage} and {@code refreshListCommand}.
     */
    public static void assertCommandSuccess(Command command, Model actualModel, String expectedMessage,
                                            Model expectedModel, boolean refreshListCommand) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage, refreshListCommand);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandResult, Model)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandListSuccess(Command command, Model actualModel, String expectedMessage,
                                                Model expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage, true);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - the address book, filtered person list and selected person in {@code actualModel} remain unchanged
     */
    public static void assertCommandFailure(Command command, Model actualModel, String expectedMessage) {
        // we are unable to defensively copy the model for comparison later, so we can
        // only do so by copying its components.
        AddressBook expectedAddressBook = new AddressBook(actualModel.getAddressBook());
        List<Customer> expectedFilteredList = new ArrayList<>(actualModel.getFilteredPersonList());

        assertThrows(CommandException.class, expectedMessage, () -> command.execute(actualModel));
        assertEquals(expectedAddressBook, actualModel.getAddressBook());
        assertEquals(expectedFilteredList, actualModel.getFilteredPersonList());
    }

    /**
     * Updates {@code model}'s filtered list to show only the person at the given {@code targetIndex} in the
     * {@code model}'s address book.
     */
    public static void showPersonAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredPersonList().size());

        Customer customer = model.getFilteredPersonList().get(targetIndex.getZeroBased());
        final String[] splitName = customer.getName().fullName.split("\\s+");
        model.updateFilteredPersonList(new NameContainsKeywordsPredicate(Arrays.asList(splitName[0])));

        assertEquals(1, model.getFilteredPersonList().size());
    }

}
