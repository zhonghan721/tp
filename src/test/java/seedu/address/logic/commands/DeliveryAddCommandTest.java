package seedu.address.logic.commands;


import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_DELIVERY_DATE;
import static seedu.address.logic.commands.CommandTestUtil.TOO_LARGE_CUSTOMER_ID;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.delivery.DeliveryAddCommand;
import seedu.address.logic.commands.delivery.DeliveryAddCommand.DeliveryAddDescriptor;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.DeliveryBook;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.delivery.Delivery;
import seedu.address.model.person.Customer;
import seedu.address.model.user.User;
import seedu.address.testutil.DeliveryAddDescriptorBuilder;
import seedu.address.testutil.DeliveryBuilder;
import seedu.address.testutil.PersonBuilder;
import seedu.address.ui.ListItem;

public class DeliveryAddCommandTest {

    @Test
    public void constructor_nullDeliveryAddDescriptor_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new DeliveryAddCommand(null));
    }

    @Test
    public void execute_deliveryAcceptedByModel_addSuccessful() {
        PersonBuilder personBuilder = new PersonBuilder();
        Customer validCustomer = personBuilder.build();

        ModelStubAcceptingDeliveryAdded modelStub = new ModelStubAcceptingDeliveryAdded();
        Delivery validDelivery = new DeliveryBuilder().withCustomer(validCustomer).build();

        CommandResult commandResult = null;
        try {
            commandResult = new DeliveryAddCommand(new DeliveryAddDescriptorBuilder(validDelivery).build())
                    .execute(modelStub);
        } catch (CommandException e) {
            e.printStackTrace();
        }

        assertEquals(String.format(DeliveryAddCommand.MESSAGE_SUCCESS, Messages.format(validDelivery)),
                commandResult.getFeedbackToUser());

    }

    @Test
    public void execute_invalidPerson_throwsCommandException() {
        PersonBuilder personBuilder = new PersonBuilder();
        Customer invalidCustomer = personBuilder.withCustomerId(TOO_LARGE_CUSTOMER_ID).build();

        ModelStub modelStub = new ModelStubAcceptingDeliveryAdded();
        Delivery validDelivery = new DeliveryBuilder().withCustomer(invalidCustomer).build();

        DeliveryAddCommand deliveryAddCommand = new DeliveryAddCommand(
                new DeliveryAddDescriptorBuilder(validDelivery).build());

        assertThrows(CommandException.class, Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX, () ->
                deliveryAddCommand.execute(modelStub));
    }

    @Test
    public void execute_invalidDeliveryDate_throwsCommandException() {
        PersonBuilder personBuilder = new PersonBuilder();
        Customer validCustomer = personBuilder.build();

        ModelStub modelStub = new ModelStubAcceptingDeliveryAdded();
        Delivery validDelivery =
                new DeliveryBuilder().withCustomer(validCustomer)
                        .withDeliveryDate(INVALID_DELIVERY_DATE).build();

        DeliveryAddCommand deliveryAddCommand = new DeliveryAddCommand(new
                DeliveryAddDescriptorBuilder(validDelivery).build());

        assertThrows(CommandException.class, Messages.MESSAGE_INVALID_DELIVERY_DATE, () ->
                deliveryAddCommand.execute(modelStub));
    }




    @Test
    public void equals() {
        Delivery gabrielMilk = new DeliveryBuilder().withName("Gabriel Milk").build();
        DeliveryAddDescriptor deliveryMilkAddDescriptor = new DeliveryAddDescriptorBuilder(gabrielMilk).build();
        DeliveryAddCommand addMilkCommand = new DeliveryAddCommand(deliveryMilkAddDescriptor);

        Delivery gambeRice = new DeliveryBuilder().withName("Gambe Rice").build();
        DeliveryAddDescriptor deliveryRiceAddDescriptor = new DeliveryAddDescriptorBuilder(gambeRice).build();
        DeliveryAddCommand addRiceCommand = new DeliveryAddCommand(deliveryRiceAddDescriptor);

        // same object -> returns true
        assertTrue(addMilkCommand.equals(addMilkCommand));

        // same values -> returns true
        DeliveryAddCommand addMilkCommandCopy = new DeliveryAddCommand(deliveryMilkAddDescriptor);
        assertTrue(addMilkCommandCopy.equals(addMilkCommandCopy));

        // different types -> returns false
        assertFalse(addMilkCommand.equals(1));

        // null -> returns false
        assertFalse(addMilkCommandCopy.equals(null));

        // different person -> returns false
        assertFalse(addMilkCommand.equals(addRiceCommand));
    }
    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setUiListDelivery() {

            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setUiListCustomer() {

            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<ListItem> getUiList() {
            return null;
        }

        @Override
        public Path getAddressBookFilePath() {

            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBookFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addPerson(Customer customer) {

            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBook(ReadOnlyBook<Customer> newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyBook<Customer> getAddressBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasPerson(Customer customer) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deletePerson(Customer target) {

            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setPerson(Customer target, Customer editedCustomer) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Customer> getFilteredPersonList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredPersonList(Predicate<Customer> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getDeliveryBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setDeliveryBookFilePath(Path deliveryBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setDeliveryBook(ReadOnlyBook<Delivery> deliveryBook) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyBook<Delivery> getDeliveryBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Optional<Delivery> getDelivery(int id) {
            return Optional.empty();
        }

        @Override
        public boolean hasDelivery(Delivery delivery) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteDelivery(Delivery target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addDelivery(Delivery customer) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setDelivery(Delivery target, Delivery editedCustomer) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Delivery> getFilteredDeliveryList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Delivery> getSortedDeliveryList() {
            return null;
        }

        @Override
        public void updateFilteredDeliveryList(Predicate<Delivery> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void sortFilteredDeliveryList(Comparator<Delivery> comparator) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean getUserLoginStatus() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setLoginSuccess() {

            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setLogoutSuccess() {

            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean userMatches(User user) {

            throw new AssertionError("This method should not be called.");
        }

        @Override
        public User getStoredUser() {
            return null;
        }

        @Override
        public void registerUser(User user) {

        }

        @Override
        public void setLoggedInUser(User user) {

        }

        @Override
        public void deleteUser() {

        }
    }

    /**
     * A Model stub that contains a single delivery.
     */
    private class ModelStubWithDelivery extends ModelStub {
        private final Delivery delivery;

        ModelStubWithDelivery(Delivery delivery) {
            requireNonNull(delivery);
            this.delivery = delivery;
        }

        @Override
        public boolean hasDelivery(Delivery delivery) {
            requireNonNull(delivery);
            return this.delivery.isSameDelivery(delivery);
        }
    }

    /**
     * A Model stub that always accept the person being added.
     */
    private class ModelStubAcceptingDeliveryAdded extends ModelStub {
        final ArrayList<Delivery> deliveriesAdded = new ArrayList<>();

        @Override
        public boolean hasDelivery(Delivery delivery) {
            requireNonNull(delivery);
            return deliveriesAdded.stream().anyMatch(delivery::isSameDelivery);
        }

        @Override
        public void addDelivery(Delivery delivery) {
            requireNonNull(delivery);
            deliveriesAdded.add(delivery);
        }

        @Override
        public ReadOnlyBook<Delivery> getDeliveryBook() {
            return new DeliveryBook();
        }

        @Override
        public ReadOnlyBook<Customer> getAddressBook() {
            PersonBuilder personBuilder = new PersonBuilder();
            Customer validCustomer = personBuilder.build();
            AddressBook addressBook = new AddressBook();
            addressBook.addPerson(validCustomer);
            return addressBook;
        }
    }

    private class ModelwithDuplicateDelivery extends ModelStub {

        final ArrayList<Delivery> deliveriesAdded = new ArrayList<>();
        ModelwithDuplicateDelivery() {
            final PersonBuilder personBuilder = new PersonBuilder();
            final Customer validCustomer = personBuilder.build();
            final Delivery validDelivery = new DeliveryBuilder().withCustomer(validCustomer).build();
            deliveriesAdded.add(validDelivery);
        }
        @Override
        public boolean hasDelivery(Delivery delivery) {
            requireNonNull(delivery);
            return deliveriesAdded.stream().anyMatch(delivery::isSameDelivery);
        }
        @Override
        public void addDelivery(Delivery delivery) {
            requireNonNull(delivery);
            deliveriesAdded.add(delivery);
        }

        @Override
        public ReadOnlyBook<Delivery> getDeliveryBook() {
            return new DeliveryBook();
        }

        @Override
        public ReadOnlyBook<Customer> getAddressBook() {
            PersonBuilder personBuilder = new PersonBuilder();
            Customer validCustomer = personBuilder.build();
            AddressBook addressBook = new AddressBook();
            addressBook.addPerson(validCustomer);
            return addressBook;
        }
    }
}

