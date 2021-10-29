package baseline;

import java.util.ArrayList;
import java.util.List;

public class ToDoList
{
    public String title;
    public List<Item> itemList = new ArrayList<>();

    public void ToDoList(String title)
    {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public List<Item> getItemList() {
        return itemList;
    }
    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
