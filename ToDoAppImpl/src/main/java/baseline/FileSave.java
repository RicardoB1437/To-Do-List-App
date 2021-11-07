package baseline;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class FileSave
{
    public void saveFile(String fileName, List<Item> items) throws IOException
    {
        try
        {
            FileWriter writer = new FileWriter(fileName);
            for(int i=0;i<items.size();i++)
            {
                String description = items.get(i).getDescription();
                LocalDate localDate = items.get(i).getDueDate();
                String str = (items.get(i).isMarked()) ? "Yes" : "No";
                writer.write(description + "," + localDate + "," + str + "\n");
            }
            writer.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException("File not created", e);
        }
    }
}
