package seedu.address.logic.commands.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.Messages.MESSAGE_CUSTOMER_LISTED_OVERVIEW;
import static seedu.address.logic.Messages.MESSAGE_CUSTOMERS_MATCHED_LISTED;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalDeliveries.getTypicalDeliveryBook;
import static seedu.address.testutil.TypicalPersons.CARL;
import static seedu.address.testutil.TypicalPersons.ELLE;
import static seedu.address.testutil.TypicalPersons.FIONA;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.NameContainsKeywordsPredicate;

/**
 * Contains integration tests (interaction with the Model) for {@code FindCommand}.
 */
public class CustomerFindCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), getTypicalDeliveryBook(),
            new UserPrefs(), true);
    private Model expectedModel = new ModelManager(getTypicalAddressBook(), getTypicalDeliveryBook(),
            new UserPrefs(), true);

    @Test
    public void equals() {
        NameContainsKeywordsPredicate firstPredicate =
                new NameContainsKeywordsPredicate(Collections.singletonList("first"));
        NameContainsKeywordsPredicate secondPredicate =
                new NameContainsKeywordsPredicate(Collections.singletonList("second"));

        CustomerFindCommand findFirstCommand = new CustomerFindCommand(firstPredicate);
        CustomerFindCommand findSecondCommand = new CustomerFindCommand(secondPredicate);

        // same object -> returns true
        assertTrue(findFirstCommand.equals(findFirstCommand));

        // same values -> returns true
        CustomerFindCommand findFirstCommandCopy = new CustomerFindCommand(firstPredicate);
        assertTrue(findFirstCommand.equals(findFirstCommandCopy));

        // different types -> returns false
        assertFalse(findFirstCommand.equals(1));

        // null -> returns false
        assertFalse(findFirstCommand.equals(null));

        // different person -> returns false
        assertFalse(findFirstCommand.equals(findSecondCommand));
    }

    @Test
    public void execute_zeroKeywords_noPersonFound() {
<<<<<<< HEAD:src/test/java/seedu/address/logic/commands/FindCommandTest.java
        String expectedMessage = String.format(MESSAGE_CUSTOMER_LISTED_OVERVIEW, 0);
=======
        String expectedMessage = String.format(MESSAGE_CUSTOMERS_MATCHED_LISTED, 0, "");
>>>>>>> 0c6857649c6d1262a90ba82f836141e6d84e1f19:src/test/java/seedu/address/logic/commands/customer/CustomerFindCommandTest.java
        NameContainsKeywordsPredicate predicate = preparePredicate(" ");
        CustomerFindCommand command = new CustomerFindCommand(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel, true);
        assertEquals(Collections.emptyList(), model.getFilteredPersonList());
    }

    @Test
    public void execute_multipleKeywords_multiplePersonsFound() {
<<<<<<< HEAD:src/test/java/seedu/address/logic/commands/FindCommandTest.java
        String expectedMessage = String.format(MESSAGE_CUSTOMER_LISTED_OVERVIEW, 3);
=======
        String expectedMessage = String.format(MESSAGE_CUSTOMERS_MATCHED_LISTED, 3, "Kurz Elle Kunz");
>>>>>>> 0c6857649c6d1262a90ba82f836141e6d84e1f19:src/test/java/seedu/address/logic/commands/customer/CustomerFindCommandTest.java
        NameContainsKeywordsPredicate predicate = preparePredicate("Kurz Elle Kunz");
        CustomerFindCommand command = new CustomerFindCommand(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel, true);
        assertEquals(Arrays.asList(CARL, ELLE, FIONA), model.getFilteredPersonList());
    }

    @Test
    public void execute_zeroKeywordsLoggedOut_failure() {
        model.setLogoutSuccess();
        expectedModel.setLogoutSuccess();
        NameContainsKeywordsPredicate predicate = preparePredicate(" ");
        CustomerFindCommand command = new CustomerFindCommand(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        assertCommandFailure(command, model, Messages.MESSAGE_USER_NOT_AUTHENTICATED);
    }

    @Test
    public void execute_multipleKeywordsLoggedOut_failure() {
        model.setLogoutSuccess();
        expectedModel.setLogoutSuccess();
        NameContainsKeywordsPredicate predicate = preparePredicate("Kurz Elle Kunz");
        CustomerFindCommand command = new CustomerFindCommand(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        assertCommandFailure(command, model, Messages.MESSAGE_USER_NOT_AUTHENTICATED);
    }

    @Test
    public void toStringMethod() {
        NameContainsKeywordsPredicate predicate = new NameContainsKeywordsPredicate(Arrays.asList("keyword"));
        CustomerFindCommand customerFindCommand = new CustomerFindCommand(predicate);
        String expected = CustomerFindCommand.class.getCanonicalName() + "{predicate=" + predicate + "}";
        assertEquals(expected, customerFindCommand.toString());
    }

    /**
     * Parses {@code userInput} into a {@code NameContainsKeywordsPredicate}.
     */
    private NameContainsKeywordsPredicate preparePredicate(String userInput) {
        return new NameContainsKeywordsPredicate(Arrays.asList(userInput.split("\\s+")));
    }
}
