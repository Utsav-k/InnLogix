package guestModules;


import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class AdditionalController implements Initializable{

    @FXML
    private JFXButton bmi;

    @FXML
    private JFXButton review;

    @FXML
    private JFXButton back;

    @Override
    public  void initialize(URL url, ResourceBundle rb){

    }
    @FXML
    private void handleBmiButton(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent next_page_parent = FXMLLoader.load(getClass().getResource("bmi.fxml"));
        Scene next_page_scene = new Scene(next_page_parent);
        Stage next_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        next_stage.setScene(next_page_scene);
        next_stage.show();

    }
    @FXML
    private void handleReviewButton(javafx.event.ActionEvent actionEvent) {
    }
    @FXML
    private void handleBackButton(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent next_page_parent = FXMLLoader.load(getClass().getResource("guest.fxml"));
        Scene next_page_scene = new Scene(next_page_parent);
        Stage next_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        next_stage.setScene(next_page_scene);
        next_stage.show();
    }
}
