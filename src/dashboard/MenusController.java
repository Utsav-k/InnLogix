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
    private HBox boxMenus;
    public static Stage resStage, invStage, frOffStage,hkpStage, analStage ;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //setUpRipples();


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


    @FXML
    private void switchToHKp(MouseEvent event) {
        try
        {
            hkpStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/administrationModules/Housekeeping/housekeeping.fxml"));
            Scene scene = new Scene(root);

            hkpStage.setScene(scene);
            hkpStage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenusController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void switchToAnal(MouseEvent event) {
        try
        {
            analStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/administrationModules/accounts/front.fxml"));
            Scene scene = new Scene(root);

            analStage.setScene(scene);
            analStage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenusController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }




    public Stage getStage()
    {
        return resStage;
    }

}
