/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrationModules.frontOffice;

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
    ObservableList<Room> roomList = FXCollections.observableArrayList();


@FXML
private JFXButton AddGButton;

    @FXML
    private TableView<Room> roomTable;
    @FXML
    private TableColumn<Room, Integer> roomNumCol;
    @FXML
    private TableColumn<Room, String> roomTypeCol;
    @FXML
    private TableColumn<Room, String> roomStatusCol;
    @FXML
    private TableColumn<Room, String> roomGuestCol;
    @FXML
    private TableColumn<Room, String> roomAttendantCol;
    @FXML
    private TableColumn<Room, String> roomRequestCol;
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
        roomTable.getItems().setAll(roomList());
        roomNumCol.setCellValueFactory(new PropertyValueFactory<>("roomNum"));
        roomTypeCol.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        roomStatusCol.setCellValueFactory(new PropertyValueFactory<>("roomStatus"));
        roomGuestCol.setCellValueFactory(new PropertyValueFactory<>("roomGuest"));
        roomAttendantCol.setCellValueFactory(new PropertyValueFactory<>("roomAttendant"));
        roomRequestCol.setCellValueFactory(new PropertyValueFactory<>("roomRequest"));

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
        roomList.removeAll(roomList);
        roomTable.getItems().setAll(roomList());
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
    private void removeRoom(ActionEvent event) {
        Room room = roomTable.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Causion!");
        alert.setHeaderText("Are you sure you want to delete ?");
        alert.setContentText(null);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            // Upon conformation remove the selected part from the table
            roomTable.getItems().remove(room);
            roomList.remove(room);

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

    public ObservableList<Room> roomList() {

        roomList.add(new Room(1, "single", "occupied", "Mr. A", "Adam", "meal order"));
        roomList.add(new Room(2, "duplex", "ready", "Mr. B", "Bob", "maintenance"));
        roomList.add(new Room(3, "single", "not ready", "Mr. C", "Carl", "demand for extra bed"));
        return roomList;
    }

}
