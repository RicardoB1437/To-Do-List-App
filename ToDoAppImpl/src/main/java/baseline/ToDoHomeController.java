package baseline;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;

public class ToDoHomeController {

    @FXML
    private MenuItem EditListButton;
    @FXML
    private MenuItem RemoveListButton;
    @FXML
    private MenuItem ShowListButton;
    @FXML
    private Button addListButton;
    @FXML
    private ListView<?> list;
    @FXML
    private ContextMenu listContextMenu;
    @FXML
    private Button loadListButton;
    @FXML
    private Button saveListButton;

    @FXML
    void addList(ActionEvent event) {
        //this will pop up a new screen that will allow you to input values for the new toDoList
        //adds the toDoList with inputted values into the list containing all toDoLists
    }

    @FXML
    void editList(ActionEvent event) {
        //this will pop up the same screen as add list and allows you to change values
        //wont add the list to toDoList since it already exists, so it will just update the data
    }

    @FXML
    void loadListFromMemory(ActionEvent event) {
        //this will pull any file you have in your memory that contains lists and parse it
        //will then take the parsed data and make the toDoLists and add them to list
    }

    @FXML
    void removeList(ActionEvent event) {
        //removes the toDoList from the list
    }

    @FXML
    void saveListToMemory(ActionEvent event) {
        //allows you to save in the list to a file
        //most likely going to do csv for the list information
    }

    @FXML
    void showList(ActionEvent event) {
        //pops a screen up showing the information for the toDoList selected
        //this screen will not allow you to change information
    }

}