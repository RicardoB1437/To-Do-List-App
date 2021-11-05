package baseline;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ToDoHomeController {

    @FXML
    private ToggleGroup FilterGroup;
    @FXML
    private Button addItemButton;
    @FXML
    private CheckBox completedCheckMark;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Button deleteAllItemsButton;
    @FXML
    private Button deleteItemButton;
    @FXML
    private TextField descriptionField;
    @FXML
    private Button editItemButton;
    @FXML
    private ListView<Item> itemListView;
    @FXML
    private Button loadListButton;
    @FXML
    private Button saveListButton;
    @FXML
    private Button viewItemButton;
    @FXML
    private Label infoLabel;
    @FXML
    private Label errLabel;

    private Item selectedItem;
    @FXML
    ObservableList<Item> items = FXCollections.observableArrayList();

    @FXML
    void deleteAllItems(ActionEvent event) {

    }

    @FXML
    void deleteItem(ActionEvent event) {
        ItemListStore itemList = new ItemListStore();
        //String description = //selected index
    }

    @FXML
    void addItem(ActionEvent event) {
        ItemListStore itemList = new ItemListStore();

        String description = descriptionField.getText();
        LocalDate date = datePicker.getValue();
        boolean marked = completedCheckMark.isSelected();
        Item newItem = new Item(description, date, marked);

        if(itemList.validInputCheck(items, description))
        {
            itemList.plusNumItems();
            items.add(newItem);
            errLabel.setText("");
        }
        else
        {
            errLabel.setText("Invalid Input");
        }
        descriptionField.clear();
    }

    @FXML
    void editItem(ActionEvent event) {

    }

    @FXML
    void loadListFromMemory(ActionEvent event) {

    }

    @FXML
    void saveListToMemory(ActionEvent event) {

    }

    @FXML
    public void initialize()
    {
        ItemListStore itemList = new ItemListStore();
        itemList.setNumItems(0);
        itemListView.setItems(items);
    }

    public void updateInfoLabel()
    {
        ItemListStore itemList = new ItemListStore();
        infoLabel.setText(itemList.toString());
    }


    public void listViewSelectedItem(Item item)
    {
        //ItemListStore itemList = new ItemListStore();
        selectedItem = itemListView.getSelectionModel().getSelectedItem();
        itemListView.getItems().addAll(items);
        updateInfoLabel();
    }

    /*
    public void changeScenes(ActionEvent event, Item item) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ToDoListAddItem.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);

        //access controller to call methods
        ToDoHomeController controller = loader.getController();
        controller.listViewSelectedItem(item);

        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    */
}
