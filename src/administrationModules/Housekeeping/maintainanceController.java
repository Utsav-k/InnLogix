package administrationModules.Housekeeping;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class maintainanceController implements Initializable {

    @FXML
    private TableView<RoomInventory> tableViewMain;
    @FXML
    private TableColumn<RoomInventory,String> roomNo;
    @FXML
    private TableColumn<RoomInventory,String> soap;
    @FXML
    private TableColumn<RoomInventory,String> waterBottle;
    @FXML
    private TableColumn<RoomInventory,String> towel;

    @FXML
    private JFXTextField roomNoText;
    @FXML
    private JFXTextField soapText;
    @FXML
    private JFXTextField waterText;
    @FXML
    private JFXTextField towelText;

    @FXML
    private JFXButton addButton;
    @FXML
    private JFXButton backButton;

    ObservableList<RoomInventory> roomInventory= FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        roomNo.setCellValueFactory(new PropertyValueFactory<>("RoomNo"));
        soap.setCellValueFactory(new PropertyValueFactory<>("Soap"));
        waterBottle.setCellValueFactory(new PropertyValueFactory<>("WaterBottle"));
        towel.setCellValueFactory(new PropertyValueFactory<>("Towel"));

        //load dummy data
        tableViewMain.setItems(getRoomInventoryRecord());

    }

    private ObservableList<RoomInventory> getRoomInventoryRecord() {

        RoomInventory SampleInventory=new RoomInventory("001","1","2","2");
        roomInventory.add(SampleInventory);
        roomInventory.add(new RoomInventory("002","3","1","1"));
        roomInventory.add(new RoomInventory("003","5","5","2"));
        roomInventory.add(new RoomInventory("004","2","3","1"));

        return roomInventory;
    }

    //add button
    @FXML
    private void addButtonMethod(ActionEvent event)
    {
            roomInventory.add(new RoomInventory(roomNoText.getText(),soapText.getText(),waterText.getText(),towelText.getText()));
    }

    //back button
    @FXML
    private void backButtonMethod(ActionEvent event)
    {
           Stage next_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           next_stage.close();
    }
}
