package baseline;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
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
import java.util.ArrayList;
import java.util.List;
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

    //private ArrayList<Item> items = new ArrayList<Item>();
    //@FXML
    //ObservableList<Item> itemList = FXCollections.observableArrayList(items);
    private List<Item> controllerItemList;

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
        ItemListStore handler = new ItemListStore();

        String description = descriptionField.getText();
        LocalDate date = datePicker.getValue();
        boolean marked = completedCheckMark.isSelected();
        Item newItem = new Item(description, date, marked);

        if(!getControllerItemList().isEmpty() && handler.validInputCheck(getControllerItemList(), description))
        {
            itemListView.getItems().add(newItem);
            controllerItemList.add(newItem);
            //handler.getItemList().add(newItem);
            //handler.addItem(description, date, marked);

            System.out.println(handler.getItems());
            System.out.println(controllerItemList);
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
        controllerItemList = itemList.getItemList();

        itemListView.getItems().addAll(itemList.getItems());
    }

    public void updateInfoLabel()
    {
        ItemListStore itemList = new ItemListStore();
        infoLabel.setText(itemList.toString());
    }


    public void listViewSelectedItem(Item item)
    {
        ItemListStore itemList = new ItemListStore();
        //selectedItem = item;
        itemListView.getItems().addAll(itemList.getItemList());
        updateInfoLabel();
    }

    public List<Item> getControllerItemList()
    {
        return controllerItemList;
    }


}
