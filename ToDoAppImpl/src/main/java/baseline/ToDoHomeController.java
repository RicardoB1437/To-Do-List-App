package baseline;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class ToDoHomeController {

    ObservableList<ToDoList> lists = FXCollections.observableArrayList();
    ObservableList<String> listTitles = FXCollections.observableArrayList();

    @FXML
    private ToggleGroup FilterGroup;
    @FXML
    private Button addListButton;
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
    private Button deleteListButton;
    @FXML
    private TextField descriptionField;
    @FXML
    private Button editItemButton;
    @FXML
    private Button editListButton;
    @FXML
    private ChoiceBox<Item> itemDropDown;
    @FXML
    private ChoiceBox<String> listDropDown;
    @FXML
    private Button loadListButton;
    @FXML
    private Button saveListButton;
    @FXML
    private TextField titleField;
    @FXML
    private Button viewItemButton;

    @FXML
    void addList(ActionEvent event) {
        ToDoList handler = new ToDoList();

        String title = titleField.getText();
        ToDoList list = new ToDoList(title);
        if(title.equals("") || listTitles.contains(title))
        {
            //say that title cant be empty
            return;
        }
        handler.addList(getLists(), list);
        listTitles.add(title);
    }

    @FXML
    void deleteAllItems(ActionEvent event) {

    }

    @FXML
    void deleteItem(ActionEvent event) {

    }

    @FXML
    void deleteList(ActionEvent event) {

    }

    @FXML
    void addItem(ActionEvent event) {

    }

    @FXML
    void editItem(ActionEvent event) {

    }

    @FXML
    void editList(ActionEvent event) {

    }

    @FXML
    void loadListFromMemory(ActionEvent event) {

    }

    @FXML
    void saveListToMemory(ActionEvent event) {

    }

    @FXML
    void viewItem(ActionEvent event) {

    }

    public ObservableList<ToDoList> getLists() {
        return lists;
    }

    public void setLists(ObservableList<ToDoList> lists) {
        this.lists = lists;
    }

    public ObservableList<String> getListTitles() {
        return listTitles;
    }

    public void setListTitles(ObservableList<String> listTitles) {
        this.listTitles = listTitles;
    }

    private final StringProperty twoWayInput = new SimpleStringProperty("");

    @FXML
    public void initialize()
    {
        listDropDown.setItems(listTitles);
    }
}
