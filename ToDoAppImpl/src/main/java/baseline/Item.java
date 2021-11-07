package baseline;

import java.time.LocalDate;

public class Item
{
    public String description;
    public LocalDate dueDate;
    public boolean marked;

    public Item(String description, LocalDate dueDate)
    {
        this.description = description;
        this.dueDate = dueDate;
        this.marked = false;
    }
    public Item(String description, LocalDate dueDate, boolean marked)
    {
        this.description = description;
        this.dueDate = dueDate;
        this.marked = marked;
    }

    public String getDescription() {
        return description;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public boolean isMarked() {
        return marked;
    }

    public String toString()
    {
        String str = (isMarked()) ? "Yes" : "No";
        return String.format("Description: %s\nDate: %s\nCompleted: %s", getDescription(), getDueDate(), str);
    }
}