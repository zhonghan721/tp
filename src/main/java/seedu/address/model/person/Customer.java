package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.tag.Tag;

/**
 * Represents a Customer in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Customer {

    // Customer ID Generation
    private static int customerCount = 1;

    // Identity fields
    private final int customerId;
    private final Name name;
    private final Phone phone;
    private final Email email;

    // Data fields
    private final Address address;

    @Deprecated
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Customer(Name name, Phone phone, Email email, Address address, Set<Tag> tags) {
        requireAllNonNull(name, phone, email, address, tags);
        this.customerId = customerCount++;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.tags.addAll(tags);
    }

    /**
     * Creates a customer with a given customerId.
     * To be used only when creating customer from storage file.
     *
     * @param customerId Customer id of the customer.
     * @param name Name of the customer.
     * @param phone Phone number of the customer.
     * @param email Email of the customer.
     * @param address Address of the customer.
     * @param tags Tags associated with the customer.
     */
    public Customer(int customerId, Name name, Phone phone, Email email, Address address, Set<Tag> tags) {
        requireAllNonNull(name, phone, email, address, tags);
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.tags.addAll(tags);
    }

    public Name getName() {
        return name;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    public static void setCustomerCount(int count) {
        Customer.customerCount = count + 1;
    }

    /**
     * Returns current customerCount.
     * Used by {@code PersonBuilder} to create customer with expected customerId.
     *
     * @return customerCount
     */
    public static int getCustomerCount() {
        return Customer.customerCount;
    }

    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Customer otherCustomer) {
        if (otherCustomer == this) {
            return true;
        }

        return otherCustomer != null
            && otherCustomer.getName().equals(getName());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Customer)) {
            return false;
        }

        Customer otherCustomer = (Customer) other;
        return customerId == otherCustomer.customerId
            && name.equals(otherCustomer.name)
            && phone.equals(otherCustomer.phone)
            && email.equals(otherCustomer.email)
            && address.equals(otherCustomer.address)
            && tags.equals(otherCustomer.tags);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(customerId, name, phone, email, address, tags);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .add("customerId", customerId)
            .add("name", name)
            .add("phone", phone)
            .add("email", email)
            .add("address", address)
            .add("tags", tags)
            .toString();
    }

}
