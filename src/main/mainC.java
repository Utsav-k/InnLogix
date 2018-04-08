package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class mainC extends Application
{
   // public static Stage s = new Stage();
    @Override
    public void start(Stage stage) throws Exception
    {

        Parent pane1 = FXMLLoader.load(getClass().getResource("/login/login.fxml"));

        Scene scene = new Scene(pane1);
        stage.setScene(scene);
        stage.setTitle("InnLogix Login");
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}