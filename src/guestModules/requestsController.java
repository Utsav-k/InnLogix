package guestModules;

import administrationModules.Housekeeping.housekeepingController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class requestsController implements Initializable {

    @FXML
    private JFXButton submitButton;
    @FXML
    private JFXDatePicker date;
    @FXML
    private JFXTimePicker time;
    @FXML
    private JFXTextField roomText;
    @FXML
    private JFXTextField requestMisc;
    @FXML
    private Label label;
    @FXML
    private JFXButton backButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void datePickerMethod(){

        LocalDate today=LocalDate.now();
        LocalDate d=date.getValue();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        String requestDate = "When: "+(today).format(fmt)+" | Request: "+ requestMisc.getText();
        //System.out.println(requestDate);
        administrationModules.Housekeeping.housekeepingController hkobj=new administrationModules.Housekeeping.housekeepingController();
        if (roomText.getText().length()>0) {
            housekeepingController.getRecord();
            housekeepingController.count = 1;
            housekeepingController.guests.get(Integer.parseInt(roomText.getText())-1).setRequest(requestDate);
        } else{
                label.setText("INVALID ROOM NUMBER");
        }
    }

    @FXML
    private void backButtonMethod(){
        Stage stage = (Stage)this.backButton.getScene().getWindow();
        stage.close();
    }
}
