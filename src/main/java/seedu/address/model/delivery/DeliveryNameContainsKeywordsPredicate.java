package seedu.address.model.delivery;

import seedu.address.commons.util.StringUtil;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.Customer;

import java.util.List;
import java.util.function.Predicate;

/**
 * Tests that a {@code Delivery}'s {@code DeliveryName} matches any of the keywords given.
 */
public class DeliveryNameContainsKeywordsPredicate implements Predicate<Delivery> {
    private final List<String> keywords;

    public DeliveryNameContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Delivery delivery) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(delivery.getName().deliveryName, keyword));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof DeliveryNameContainsKeywordsPredicate)) {
            return false;
        }

        DeliveryNameContainsKeywordsPredicate otherNameContainsKeywordsPredicate
            = (DeliveryNameContainsKeywordsPredicate) other;
        return keywords.equals(otherNameContainsKeywordsPredicate.keywords);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keywords", keywords).toString();
    }
}
