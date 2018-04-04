package dashboard;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class adminDashboardController implements Initializable {

    @FXML
    private AnchorPane holderPane;
    @FXML
    private JFXButton btnHome;
    @FXML
    AnchorPane frontOffice;
    @FXML
    AnchorPane inventory;
    @FXML
    AnchorPane guest;
    @FXML
    private JFXButton btnInventory;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
//        //Cache loaded fxmls
//        try
//        {
//            guest = FXMLLoader.load(getClass().getResource("/guestModules/guest.fxml"));
//            setNode(frontOffice);
//            System.out.println("op");
//        }
//        catch (IOException ex)
//        {
//            Logger.getLogger(adminDashboardController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    private void setNode(Node node)
    {
        holderPane.getChildren().clear();
        holderPane.getChildren().add((node));

        FadeTransition ft = new FadeTransition(Duration.millis(1000));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    @FXML
    private void switchInventory(ActionEvent event) throws Exception
    {
        inventory = FXMLLoader.load(getClass().getResource("/administrationModules/inventory/IMSFXMLDocument.fxml"));

        setNode(inventory);
    }

    @FXML
    private void switchHome(ActionEvent event) throws  Exception
    {
        frontOffice = FXMLLoader.load(getClass().getResource("/administrationModules/frontOffice/frontOffice.fxml"));

        setNode(frontOffice);
    }

}
