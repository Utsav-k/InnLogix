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


public class GuestController implements Initializable {

    @FXML
    private JFXButton requestButton;
    @FXML
    private JFXButton accountsButton;
    @FXML
    private JFXButton exitButton;

    @FXML
    private AnchorPane guestPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void requestsButtonMethod(javafx.event.ActionEvent event ) {
        try {
            Parent next_page_parent = FXMLLoader.load(getClass().getResource("/guestModules/requestsPage.fxml"));
            Scene next_page_scene = new Scene(next_page_parent);
            Stage next_stage = new Stage();
            next_stage.setScene(next_page_scene);
            next_stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void checkAccountsButtonMethod(javafx.event.ActionEvent event) {
        try {
            Parent next_page_parent = FXMLLoader.load(getClass().getResource("/guestModules/accountsPage.fxml"));
            Scene next_page_scene = new Scene(next_page_parent);
            Stage next_stage = new Stage();
            next_stage.setScene(next_page_scene);
            next_stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void exitButtonMethod(){

        Stage stage = (Stage)this.exitButton.getScene().getWindow();
        stage.close();

        try {
            Parent next_page_parent = FXMLLoader.load(getClass().getResource("/login/login.fxml"));
            Scene next_page_scene = new Scene(next_page_parent);
            Stage next_stage=new Stage();
            next_stage.setScene(next_page_scene);
            next_stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void openAdditional(javafx.event.ActionEvent event) throws IOException{
        Parent next_page_parent = FXMLLoader.load(getClass().getResource("additional.fxml"));
        Scene next_page_scene = new Scene(next_page_parent);
        Stage next_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        next_stage.setScene(next_page_scene);
        next_stage.show();

    }

}