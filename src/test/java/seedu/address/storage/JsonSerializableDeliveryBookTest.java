package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.DeliveryBook;
import seedu.address.testutil.TypicalDeliveries;
import seedu.address.testutil.TypicalPersons;

public class JsonSerializableDeliveryBookTest {

    private static final Path TEST_DATA_FOLDER =
        Paths.get("src", "test", "data", "JsonSerializableDeliveryBookTest");
    private static final Path TYPICAL_DELIVERIES_FILE =
        TEST_DATA_FOLDER.resolve("typicalDeliveriesDeliveryBook.json");
    private static final Path INVALID_DELIVERY_FILE =
        TEST_DATA_FOLDER.resolve("invalidDeliveryDeliveryBook.json");
    private static final Path DUPLICATE_DELIVERY_FILE =
        TEST_DATA_FOLDER.resolve("duplicateDeliveryBook.json");

    @Test
    public void toModelType_typicalDeliveriesFile_success() throws Exception {
        JsonSerializableDeliveryBook dataFromFile = JsonUtil.readJsonFile(TYPICAL_DELIVERIES_FILE,
            JsonSerializableDeliveryBook.class).get();
        DeliveryBook deliveryBookFromFile =
            dataFromFile.toModelType(Optional.of(TypicalPersons.getTypicalAddressBook()));
        DeliveryBook typicalDeliveriesDeliveryBook = TypicalDeliveries.getTypicalDeliveryBook();
        assertEquals(deliveryBookFromFile, typicalDeliveriesDeliveryBook);
    }

    @Test
    public void toModelType_invalidPersonFile_throwsIllegalValueException() throws Exception {
        JsonSerializableDeliveryBook dataFromFile = JsonUtil.readJsonFile(INVALID_DELIVERY_FILE,
            JsonSerializableDeliveryBook.class).get();
        assertThrows(IllegalValueException.class, ()
            -> dataFromFile.toModelType(Optional.of(TypicalPersons.getTypicalAddressBook())));
    }

    @Test
    public void toModelType_duplicatePersons_throwsIllegalValueException() throws Exception {
        JsonSerializableDeliveryBook dataFromFile = JsonUtil.readJsonFile(DUPLICATE_DELIVERY_FILE,
            JsonSerializableDeliveryBook.class).get();
        assertThrows(IllegalValueException.class, JsonSerializableDeliveryBook.MESSAGE_DUPLICATE_DELIVERY, ()
            -> dataFromFile.toModelType(Optional.of(TypicalPersons.getTypicalAddressBook())));
    }
}
