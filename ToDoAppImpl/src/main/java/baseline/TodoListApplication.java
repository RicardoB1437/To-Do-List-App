/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Ricardo Barrios
 */

package baseline;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TodoListApplication extends javafx.application.Application
{
    private static ArrayList<Item> items;

    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("ToDoListHome.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static ArrayList<Item> getItems()
    {
        return items;
    }

    public static void main(String[] args)
    {
        items = new ArrayList<Item>();
        launch(args);
    }
}