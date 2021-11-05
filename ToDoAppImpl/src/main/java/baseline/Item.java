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
    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isMarked() {
        return marked;
    }
    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public String toString()
    {
        String str = (isMarked()) ? "Yes" : "No";
        return String.format("Description: %s\nDate: %s\nCompleted: %s", getDescription(), getDueDate(), str);
    }
}