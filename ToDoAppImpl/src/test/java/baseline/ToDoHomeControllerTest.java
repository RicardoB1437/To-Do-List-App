package baseline;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ToDoHomeControllerTest {

    @Test
    void deleteAllItemsFunction()
    {
        ToDoHomeController tester = new ToDoHomeController();
        ArrayList<Item> testList = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date1 = "2021-10-10";
        String date2 = "2020-12-12";
        LocalDate localDate1 = LocalDate.parse(date1, formatter);
        LocalDate localDate2 = LocalDate.parse(date2, formatter);

        testList.add(new Item("fffff", localDate1, true));
        testList.add(new Item("aaaaa", localDate2, false));

        tester.deleteAllItemsFunction(testList);

        int expected = 0;
        int actual = 0;

        if(!testList.isEmpty())
            actual++;

        assertEquals(expected, actual);

    }

    @Test
    void deleteItemFunction()
    {
        ToDoHomeController tester = new ToDoHomeController();
        ArrayList<Item> testList = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date1 = "2021-10-10";
        String date2 = "2020-12-12";
        LocalDate localDate1 = LocalDate.parse(date1, formatter);
        LocalDate localDate2 = LocalDate.parse(date2, formatter);

        testList.add(new Item("fffff", localDate1, true));

        //item being deleted / tested if exists
        Item testItem = new Item("aaaaa", localDate2, false);
        testList.add(testItem);

        tester.deleteItemFunction(1, testList);

        int expected = 0;
        int actual = 0;
        //check if the list contains the testItem (item that was deleted)
        for(int i=0;i<testList.size();i++)
        {
            if(testList.get(i).getDescription().equals(testItem.getDescription()) && testList.get(i).getDueDate().equals(testItem.getDueDate()) && testList.get(i).isMarked() == testItem.isMarked())
                actual++;
        }

        assertEquals(expected, actual);
    }

    @Test
    void addItemFunction()
    {
        ToDoHomeController tester = new ToDoHomeController();
        ArrayList<Item> testList = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date1 = "2021-10-10";
        String date2 = "2020-12-12";
        LocalDate localDate1 = LocalDate.parse(date1, formatter);
        LocalDate localDate2 = LocalDate.parse(date2, formatter);

        testList.add(new Item("fffff", localDate1, true));

        //item being added / tested if exists
        Item testItem = new Item("aaaaa", localDate2, false);
        testList.add(testItem);

        int expected = 1;
        int actual = 0;

        for(int i=0;i<testList.size();i++)
        {
            if(testList.get(i).getDescription().equals(testItem.getDescription()) && testList.get(i).getDueDate().equals(testItem.getDueDate()) && testList.get(i).isMarked() == testItem.isMarked())
                actual++;
        }

        assertEquals(expected, actual);
    }

    @Test
    void editFunction()
    {
        ToDoHomeController tester = new ToDoHomeController();
        ArrayList<Item> testList = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date1 = "2021-10-10";
        String date2 = "2020-12-12";
        String date3 = "2020-10-12";
        LocalDate localDate1 = LocalDate.parse(date1, formatter);
        LocalDate localDate2 = LocalDate.parse(date2, formatter);
        LocalDate localDate3 = LocalDate.parse(date3, formatter);

        testList.add(new Item("fffff", localDate1, true));

        //item being injected / tested if exists
        Item testItem = new Item("aaaaa", localDate2, false);
        //item being replaced / tested if exists
        Item testItem2 = new Item("sssss", localDate3, false);
        testList.add(testItem);

        tester.editFunction(1, testList, testItem2);

        int expectedReplaceTest = 0;
        int actualReplaceTest = 0;
        int expectedInjectTest = 1;
        int actualInjectTest = 0;

        //check if the list contains the testItem (item that was edited)
        for(int i=0;i<testList.size();i++)
        {
            //check for item that was replaced
            if(testList.get(i).getDescription().equals(testItem.getDescription()) && testList.get(i).getDueDate().equals(testItem.getDueDate()) && testList.get(i).isMarked() == testItem.isMarked())
                actualReplaceTest++;
            //check for item that was injected
            if(testList.get(i).getDescription().equals(testItem2.getDescription()) && testList.get(i).getDueDate().equals(testItem2.getDueDate()) && testList.get(i).isMarked() == testItem2.isMarked())
                actualInjectTest++;
        }

        assertEquals(expectedReplaceTest, actualReplaceTest);
        assertEquals(expectedInjectTest, actualInjectTest);
    }

    @Test
    void loadListFromMemory()
    {
        FileParse tester = new FileParse();
        String fileName = "C:\\Users\\Ricardo\\Desktop\\guiTestFile.txt";
        ArrayList<Item> actualList = tester.loadFile(fileName);
        ArrayList<Item> testList = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date1 = "2021-10-10";
        String date2 = "2020-12-12";
        LocalDate localDate1 = LocalDate.parse(date1, formatter);
        LocalDate localDate2 = LocalDate.parse(date2, formatter);

        testList.add(new Item("fffff", localDate1, true));
        testList.add(new Item("aaaaa", localDate2, false));

        //flags to check comparisons between values of both lists
        int expectedDescriptionFlag = 0;
        int actualDescriptionFlag = 0;
        int expectedDueDateFlag = 0;
        int actualDueDateFlag = 0;
        int expectedMarkedFlag = 0;
        int actualMarkedFlag = 0;

        for(int i=0;i<testList.size();i++)
        {
            if(!actualList.get(i).getDescription().equals(testList.get(i).getDescription()))
                actualDescriptionFlag++;
            if(!actualList.get(i).getDueDate().equals(testList.get(i).getDueDate()))
                actualDueDateFlag++;
            if(actualList.get(i).isMarked() != testList.get(i).isMarked())
                actualMarkedFlag++;
        }

        assertEquals(expectedDescriptionFlag, actualDescriptionFlag);
        assertEquals(expectedDueDateFlag, actualDueDateFlag);
        assertEquals(expectedMarkedFlag, actualMarkedFlag);
    }

    @Test
    void saveListToMemory()
    {
        FileSave fs = new FileSave();
        FileParse tester = new FileParse();
        String fileName = "C:\\Users\\Ricardo\\Desktop\\guiSaveFile.txt";
        ArrayList<Item> actualList;
        ArrayList<Item> testList = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date1 = "2021-10-10";
        String date2 = "2020-12-12";
        LocalDate localDate1 = LocalDate.parse(date1, formatter);
        LocalDate localDate2 = LocalDate.parse(date2, formatter);

        testList.add(new Item("fffff", localDate1, true));
        testList.add(new Item("aaaaa", localDate2, false));
        try
        {
            fs.saveFile(fileName, testList);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        actualList = tester.loadFile(fileName);

        //flags to check comparisons between values of both lists
        int expectedDescriptionFlag = 0;
        int actualDescriptionFlag = 0;
        int expectedDueDateFlag = 0;
        int actualDueDateFlag = 0;
        int expectedMarkedFlag = 0;
        int actualMarkedFlag = 0;

        for(int i=0;i<actualList.size();i++)
        {
            if(!actualList.get(i).getDescription().equals(testList.get(i).getDescription()))
                actualDescriptionFlag++;
            if(!actualList.get(i).getDueDate().equals(testList.get(i).getDueDate()))
                actualDueDateFlag++;
            if(actualList.get(i).isMarked() != testList.get(i).isMarked())
                actualMarkedFlag++;
        }

        assertEquals(expectedDescriptionFlag, actualDescriptionFlag);
        assertEquals(expectedDueDateFlag, actualDueDateFlag);
        assertEquals(expectedMarkedFlag, actualMarkedFlag);
    }

    @Test
    void radioButtonChanged()
    {
        //idk how to test this tbh
    }

    @Test
    void validInputCheck()
    {
        ToDoHomeController tester = new ToDoHomeController();
        String str1 = "";
        String str2 = "aaaaa";
        boolean expected1 = false;
        boolean expected2 = true;
        boolean actual1 = tester.validInputCheck(str1);
        boolean actual2 = tester.validInputCheck(str2);

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }
}