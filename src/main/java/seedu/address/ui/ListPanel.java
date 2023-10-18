package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Customer;

/**
 * Panel containing the list of persons.
 */
public class ListPanel extends UiPart<Region> {
    private static final String FXML = "PersonListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(ListPanel.class);

    @FXML
    private ListView<ListItem> listItems;

    /**
     * Creates a {@code PersonListPanel} with the given {@code ObservableList}.
     */
//    public PersonListPanel(ObservableList<Customer> customerList) {
//        super(FXML);
//        personListView.setItems(customerList);
//        personListView.setCellFactory(listView -> new PersonListViewCell());
//    }
    public ListPanel(ObservableList<ListItem> item) {
        super(FXML);
        System.out.println("LIST " + item);
        listItems.setItems(item);
        listItems.setCellFactory(listView -> new PersonListViewCell());
    }

    public void setListItems(ObservableList<ListItem> item) {
        listItems.setItems(item);
        listItems.setCellFactory(listView -> new PersonListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class PersonListViewCell extends ListCell<ListItem> {
        @Override
        protected void updateItem(ListItem item, boolean empty) {
            super.updateItem(item, empty);

            if (empty || item == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new PersonCard(item).getRoot());
            }
        }
    }

}
