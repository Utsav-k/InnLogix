/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrationModules.frontOffice;

import administrationModules.Housekeeping.Record;
import administrationModules.Housekeeping.housekeepingController;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Alert.AlertType;

public class RoomsController implements Initializable {
    //Room room = new Room();
    ObservableList<Record> roomList = FXCollections.observableArrayList();
    //housekeepingController hcObj = new housekeepingController();
    public static int roomDBcount = 0;
@FXML
private JFXButton AddGButton;
    @FXML
    private JFXButton refreshTable;
    @FXML
    private JFXButton removeRoom;

    @FXML
    private TableView<Record> roomTable;
    @FXML
    private TableColumn<Record, String> roomNumCol;
    @FXML
    private TableColumn<Record, String> roomTypeCol;
    @FXML
    private TableColumn<Record, String> roomStatusCol;
    @FXML
    private TableColumn<Record, String> roomGuestCol;
    @FXML
    private TableColumn<Record, String> roomAttendantCol;
    @FXML
    private TableColumn<Record, String> roomRequestCol;
//    @FXML
//    private JFXButton refresh;
//    @FXML
//    private JFXButton but_movie;
//    @FXML
//    private JFXButton but_remove;
//    @FXML
//    private JFXButton mov;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

            roomTable.getItems().setAll(housekeepingController.getRecord());
            housekeepingController.count=1;
            roomNumCol.setCellValueFactory(new PropertyValueFactory<>("RoomNo"));
            roomTypeCol.setCellValueFactory(new PropertyValueFactory<>("RoomType"));
            roomStatusCol.setCellValueFactory(new PropertyValueFactory<>("Status"));
            roomGuestCol.setCellValueFactory(new PropertyValueFactory<>("Guest"));
            roomAttendantCol.setCellValueFactory(new PropertyValueFactory<>("Attendant"));
            roomRequestCol.setCellValueFactory(new PropertyValueFactory<>("Request"));

            System.out.println(roomTable.getSelectionModel().getSelectedIndex());



}
//    public void initCols() {
//        roomNumCol.setCellValueFactory(new PropertyValueFactory<>("roomNumCol"));
//        roomTypeCol.setCellValueFactory(new PropertyValueFactory<>("roomTypeCol"));
//        roomStatusCol.setCellValueFactory(new PropertyValueFactory<>("roomStatusCol"));
//        roomGuestCol.setCellValueFactory(new PropertyValueFactory<>("roomGuestCol"));
//        roomAttendantCol.setCellValueFactory(new PropertyValueFactory<>("roomAttendantCol"));
//        roomRequestCol.setCellValueFactory(new PropertyValueFactory<>("roomRequestCol"));
//    }

    private void refresh() {
        roomTable.getItems().clear();
        housekeepingController.getRecord().removeAll(housekeepingController.getRecord());
        roomTable.getItems().setAll(housekeepingController.getRecord());

    }

    @FXML
    private void refreshTable(ActionEvent event) {
        refresh();
    }

    @FXML
    private void addGuest(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/administrationModules/frontOffice/RegisterGuest.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Add guest");
        stage.setScene(new Scene(parent));
//        stage.initOwner(((Stage) but_theatre.getScene().getWindow()));
//        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }

    @FXML
    private void openGDB(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/administrationModules/frontOffice/GuestDB.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Guest Database");
        stage.setScene(new Scene(parent));
//        stage.initOwner(((Stage) but_theatre.getScene().getWindow()));
//        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }

    @FXML
    private void removeRoom(ActionEvent event) {
        Record room = roomTable.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Causion!");
        alert.setHeaderText("Are you sure you want to delete ?");
        alert.setContentText(null);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            // Upon conformation remove the selected part from the table
            roomTable.getItems().remove(room);
            housekeepingController.getRecord().remove(room);

        }

    }

    //    @FXML
//    private void roomDetails(ActionEvent event) {
//        try{
//            Room room= table.getSelectionModel().getSelectedItem();
//            ticketbooking.ui.mainui.user.showmovie.ShowRoomController.id=movie.getId();  //TODO
//           loadWindow("/ticketbooking/ui/mainui/user/showmovie/showRoom.fxml","Aurora"); //TODO
//        }
//        catch(Exception ex)
//        {
//            ex.printStackTrace();
//        }
//    }

//    public ObservableList<Record> roomList() {
//
//        roomList.add(new Record("1", "single", "occupied", "Mr. A", "Adam", "meal order"));
//        roomList.add(new Record("2", "duplex", "ready", "Mr. B", "Bob", "maintenance"));
//        roomList.add(new Record("3", "single", "not ready", "Mr. C", "Carl", "demand for extra bed"));
//        return roomList;
//    }

}
