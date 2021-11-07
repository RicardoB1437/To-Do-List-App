package baseline;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileParse
{
    public ArrayList<Item> loadFile(String fileName) throws RuntimeException
    {
        ArrayList<String> fileLines = new ArrayList<>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = "";
            while((line=reader.readLine())!=null)
            {
                fileLines.add(line);
            }
            reader.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException("File not found", e);
        }
        return convertFileToList(fileLines);
    }

    private ArrayList<Item> convertFileToList(List<String> fileLines)
    {
        ArrayList<Item> itemList = new ArrayList<>();
        for (String s : fileLines)
        {
            String[] arr = s.split(",");
            String description = arr[0];

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String date = arr[1];
            //convert String to LocalDate
            LocalDate localDate = LocalDate.parse(date, formatter);

            boolean marked = arr[2].equals("Yes");

            Item newItem = new Item(description, localDate, marked);
            itemList.add(newItem);
        }
        return itemList;
    }
}
