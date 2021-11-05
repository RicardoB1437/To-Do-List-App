package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.time.LocalDate;

public class ItemListStore
{
    @FXML
    ObservableList<Item> items = FXCollections.observableArrayList();

    private int numItems;

    public ObservableList<Item> getItems()
    {
        return items;
    }

    public void setNumItems(int num)
    {
        this.numItems = num;
    }

    public void plusNumItems()
    {
        setNumItems(getNumItems() + 1);
    }

    public void minusNumItems()
    {
        setNumItems(getNumItems() + 1);
    }

    public int getNumItems()
    {
        return numItems;
    }

    public void addItem(String description, LocalDate dueDate, boolean marked)
    {
        Item newItem = new Item(description, dueDate, marked);
        items.add(newItem);
    }

    //each item is going to have a unique description so only checking for description match
    public void deleteItem(String description)
    {
        for(int i=0;i<items.size();i++)
        {
            if(items.get(i).getDescription().equals(description))
                items.remove(items.get(i));
        }
    }

    public boolean validInputCheck(ObservableList<Item> items, String description)
    {
        if((description.equals("null") || description.isEmpty()))
        {
            return false;
        }
        else
        {
            System.out.println(getItems().size());
            for(int i=0;i<getNumItems();i++)
            {
                System.out.println(description);
                System.out.println(items.get(i).getDescription());
                if(!getItems().isEmpty() && items.get(i).getDescription().equals(description))
                    return false;
            }
        }
        return true;
    }
}
