package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ToDoHomeController {

    @FXML
    private ToggleGroup FilterGroup;
    @FXML
    private RadioButton allItemsFilterButton;
    @FXML
    private RadioButton completedItemsFilterButton;
    @FXML
    private RadioButton incompletedItemsFilterButton;
    @FXML
    private CheckBox completedCheckMark;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField descriptionField;
    @FXML
    private ListView<Item> itemListView;
    @FXML
    private Label errLabel;

    private ArrayList<Item> itemList = new ArrayList<Item>();
    @FXML
    ObservableList<Item> filteredItems = FXCollections.observableArrayList(itemList);

    @FXML
    public void deleteAllItems(ActionEvent event)
    {
        //simply remove items from list and then remove items from list view
        this.itemList = deleteAllItemsFunction(this.itemList);
        itemListView.getItems().clear();
    }

    //testable delete all function
    public ArrayList<Item> deleteAllItemsFunction(ArrayList<Item> items)
    {
        //simply remove items from list and then remove items from list view
        items.removeAll(items);
        return items;
    }

    @FXML
    public void deleteItem(ActionEvent event)
    {
        int selectedIdx = itemListView.getSelectionModel().getSelectedIndex();
        itemListView.getItems().remove(selectedIdx);
        this.itemList = deleteItemFunction(selectedIdx, this.itemList);
    }

    //testable delete function
    public ArrayList<Item> deleteItemFunction(int id, ArrayList<Item> items)
    {
        items.remove(id);
        return items;
    }

    @FXML
    private void addItem(ActionEvent event) {
        if(addItemFunction() != null)
        {
            itemListView.getItems().add(addItemFunction());
            itemList.add(addItemFunction());

            System.out.println(itemList);
            errLabel.setText("");
            //clears all fields after item is added
            descriptionField.clear();
            datePicker.setValue(null);
            completedCheckMark.setSelected(false);
        }
        else
        {
            errLabel.setText("Invalid Input");
        }
    }

    //testable add function
    public Item addItemFunction()
    {
        String description = descriptionField.getText();
        LocalDate date = datePicker.getValue();
        boolean marked = completedCheckMark.isSelected();
        Item newItem = new Item(description, date, marked);

        if(validInputCheck(description))
            return newItem;
        else
            return null;
    }

    @FXML
    private void editItem(ActionEvent event)
    {
        int selectedIdx = itemListView.getSelectionModel().getSelectedIndex();
        if(addItemFunction() != null)
        {
            this.itemList = editFunction(selectedIdx, this.itemList, addItemFunction());
            itemListView.getItems().set(selectedIdx, addItemFunction());
        }
        descriptionField.clear();
        datePicker.setValue(null);
        completedCheckMark.setSelected(false);
    }
    //testable edit function
    public ArrayList<Item> editFunction(int id, ArrayList<Item> items, Item newItem)
    {
        items.set(id, newItem);
        return items;
    }

    @FXML
    public void loadListFromMemory(ActionEvent event)
    {
        FileParse fp = new FileParse();
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("text files", "*.txt"));
        File f = fc.showOpenDialog(null);

        ArrayList<Item> tempList;
        if(f != null)
        {
            tempList = fp.loadFile(f.getAbsolutePath());
            updateGuiWithLoadedList(tempList);
            errLabel.setText("");
            System.out.println(f.getAbsolutePath());
        }
        else
        {
            errLabel.setText("Invalid File");
        }
    }

    @FXML
    public void saveListToMemory(ActionEvent event)
    {
        FileSave fs = new FileSave();
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("text files", "*.txt"));
        File f = fc.showSaveDialog(null);
        try
        {
            fs.saveFile(f.getAbsolutePath(), this.itemList);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    //load list helper function
    private void updateGuiWithLoadedList(ArrayList<Item> tempItems)
    {
        this.itemList = tempItems;
        this.filteredItems.clear();
        this.filteredItems.addAll(tempItems);
        itemListView.getItems().clear();
        itemListView.getItems().addAll(this.filteredItems);
    }

    // radio button filter helper functions
    private List<Item> getMarkedItems(List<Item> items)
    {
        List<Item> tempList = new ArrayList<>();
        for (Item item : items)
        {
            if (item.isMarked())
                tempList.add(item);
        }
        return tempList;
    }

    private List<Item> getUnmarkedItems(List<Item> items)
    {
        List<Item> tempList = new ArrayList<>();
        for (Item item : items)
        {
            if (!item.isMarked())
                tempList.add(item);
        }
        return tempList;
    }

    private List<Item> getAllItems(List<Item> items)
    {
        return items;
    }

    public void radioButtonChanged()
    {
        List<Item> filterItems;
        //changes the contents of the filter list and pushes the changes to the gui list view
        if(FilterGroup.getSelectedToggle().equals(this.allItemsFilterButton))
        {
            filterItems = getAllItems(this.itemList);
            this.filteredItems.clear();
            this.filteredItems.addAll(filterItems);
            itemListView.getItems().clear();
            itemListView.getItems().addAll(this.filteredItems);
        }
        if(FilterGroup.getSelectedToggle().equals(this.completedItemsFilterButton))
        {
            filterItems = getMarkedItems(this.itemList);
            this.filteredItems.clear();
            this.filteredItems.addAll(filterItems);
            itemListView.getItems().clear();
            itemListView.getItems().addAll(this.filteredItems);
        }
        if(FilterGroup.getSelectedToggle().equals(this.incompletedItemsFilterButton))
        {
            filterItems = getUnmarkedItems(this.itemList);
            this.filteredItems.clear();
            this.filteredItems.addAll(filterItems);
            itemListView.getItems().clear();
            itemListView.getItems().addAll(this.filteredItems);
        }
        System.out.println(this.filteredItems);
    }

    @FXML
    public void initialize()
    {
        itemListView.getItems().addAll(filteredItems);

        //handles the initialization of the filters
        FilterGroup = new ToggleGroup();
        this.allItemsFilterButton.setToggleGroup(FilterGroup);
        this.completedItemsFilterButton.setToggleGroup(FilterGroup);
        this.incompletedItemsFilterButton.setToggleGroup(FilterGroup);
        this.allItemsFilterButton.setSelected(true);
        this.allItemsFilterButton.requestFocus();
    }

    public boolean validInputCheck(String description)
    {
        if(description.equals("null") || description.isEmpty() || description.length() > 256)
        {
            return false;
        }
        return true;
    }

}
