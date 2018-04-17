package administrationModules.accounts;

import com.jfoenix.controls.JFXRippler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FrontController  implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private StackPane fabsContainer;

    @FXML
    private HBox boxMenus;
    public static Stage resStage, invStage, frOffStage,hkpStage ;


    // Method to return ObservableList or Order objects
    @Override
    public void initialize(URL url, ResourceBundle rb){

    }


    @FXML
    private void openInventory(MouseEvent event) throws IOException {
        Parent next_page_parent = FXMLLoader.load(getClass().getResource("fxmlInventory.fxml"));
        Scene next_page_scene = new Scene(next_page_parent);
        Stage next_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        next_stage.setScene(next_page_scene);
        next_stage.show();
    }
    @FXML
    private void openLol(MouseEvent event) throws IOException {
        Parent next_page_parent = FXMLLoader.load(getClass().getResource("fxmlLol.fxml"));
        Scene next_page_scene = new Scene(next_page_parent);
        Stage next_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        next_stage.setScene(next_page_scene);
        next_stage.show();
    }
    @FXML
    private void openRevenue(MouseEvent event) throws IOException {
        Parent next_page_parent = FXMLLoader.load(getClass().getResource("fxmlRevenue.fxml"));
        Scene next_page_scene = new Scene(next_page_parent);
        Stage next_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        next_stage.setScene(next_page_scene);
        next_stage.show();
    }
    @FXML
    private void openWifi(MouseEvent event) throws IOException {
        Parent next_page_parent = FXMLLoader.load(getClass().getResource("fxmlWifi.fxml"));
        Scene next_page_scene = new Scene(next_page_parent);
        Stage next_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        next_stage.setScene(next_page_scene);
        next_stage.show();
    }
}
