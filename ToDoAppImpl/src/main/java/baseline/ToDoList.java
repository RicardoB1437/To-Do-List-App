package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class ToDoList
{
    public String title;
    ObservableList<Item> items = FXCollections.observableArrayList();

    public ToDoList()
    {

    }
    public ToDoList(String title)
    {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public List<Item> getItems() {
        return items;
    }
    public void setItems(ObservableList<Item> itemList) {
        this.items = itemList;
    }
    public void addList(ObservableList<ToDoList> lists, ToDoList list)
    {
        lists.add(list);
    }
}
