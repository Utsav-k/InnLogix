package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class mainC extends Application
{
    public static Stage s = new Stage();
    @Override
    public void start(Stage stage) throws Exception
    {
        s = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/login/login.fxml"));

        Scene scene = new Scene(root);
        s.setScene(scene);
        s.setTitle("InnLogix Login");
        s.setResizable(false);
        s.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}