package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ItemListStore
{
    private List<Item> itemList = new ArrayList<>();

    public List<Item> getItemList() {
        return itemList;
    }

    @FXML
    private ObservableList<Item> items = FXCollections.observableArrayList(getItemList());


    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public ObservableList<Item> getItems()
    {
        return items;
    }

    public void addItem(String description, LocalDate dueDate, boolean marked)
    {
        Item newItem = new Item(description, dueDate, marked);
        getItemList().add(newItem);

    }

    //each item is going to have a unique description so only checking for description match
    public void deleteItem(String description)
    {
        for(int i=0;i<getItemList().size();i++)
        {
            if(getItemList().get(i).getDescription().equals(description))
                getItemList().remove(getItemList().get(i));
        }
    }

    public boolean validInputCheck(List<Item> items, String description)
    {
        ToDoHomeController handler = new ToDoHomeController();
        if((description.equals("null") || description.isEmpty()))
        {
            return false;
        }
        else
        {
            //System.out.println(getItemList().size());
            //System.out.println(getItemList());
            for (int i = 0; i < handler.getControllerItemList().size(); i++)
            {
                System.out.println(description);
                System.out.println(getItemList().get(i).getDescription());
                if (!getItemList().isEmpty() && getItemList().get(i).getDescription().equals(description))
                    return false;
            }
        }
        return true;
    }
}
