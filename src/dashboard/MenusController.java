package dashboard;

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


public class MenusController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private StackPane fabsContainer;
    @FXML
    private AnchorPane paneUsers;
    @FXML
    private AnchorPane paneTickets;
    @FXML
    private AnchorPane paneBuses;
    @FXML
    private AnchorPane paneDrivers;
    @FXML
    private HBox boxMenus;
    public static Stage resStage, invStage, frOffStage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        setUpRipples();


    }


    @FXML
    private void switchToFrontOffice(MouseEvent event) {
        try
        {
            frOffStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/administrationModules/frontOffice/RoomDB.fxml"));
            Scene scene = new Scene(root);

            frOffStage.setScene(scene);
            frOffStage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenusController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void switchToInventory(MouseEvent event) {
        try
        {
             invStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/administrationModules/inventory/IMSFXMLDocument.fxml"));
            Scene scene = new Scene(root);

            invStage.setScene(scene);
            invStage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenusController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void switchToRestaurant(MouseEvent event) {
        try {
             resStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/administrationModules/restaurant/Homepage.fxml"));
            Scene scene = new Scene(root);

            resStage.setScene(scene);
            resStage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenusController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void setUpRipples() {
        JFXRippler ripplerUser = new JFXRippler(paneUsers, JFXRippler.RipplerMask.RECT, JFXRippler.RipplerPos.FRONT);
        JFXRippler ripplerDriver = new JFXRippler(paneDrivers, JFXRippler.RipplerMask.RECT, JFXRippler.RipplerPos.FRONT);
        JFXRippler ripplerBuses = new JFXRippler(paneBuses, JFXRippler.RipplerMask.RECT, JFXRippler.RipplerPos.FRONT);
        JFXRippler ripplerTickets = new JFXRippler(paneTickets, JFXRippler.RipplerMask.RECT, JFXRippler.RipplerPos.FRONT);

        boxMenus.getChildren().addAll(ripplerUser, ripplerDriver, ripplerBuses, ripplerTickets);
    }

    public Stage getStage()
    {
        return resStage;
    }

}
