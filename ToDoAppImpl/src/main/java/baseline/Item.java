package baseline;

public class Item
{
    public String description;
    public String dueDate;
    public boolean marked;

    public void Item(String description, String dueDate)
    {
        this.description = description;
        this.dueDate = dueDate;
        this.marked = false;
    }
    public void Item(String description, String dueDate, boolean marked)
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

    public String getDueDate() {
        return dueDate;
    }
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isMarked() {
        return marked;
    }
    public void setMarked(boolean marked) {
        this.marked = marked;
    }
}