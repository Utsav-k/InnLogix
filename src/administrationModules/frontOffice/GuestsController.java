
package administrationModules.frontOffice;

import administrationModules.Housekeeping.housekeepingController;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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

public class GuestsController implements Initializable {
    //Room room = new Room();
    public  static ObservableList<Guest> guestList = FXCollections.observableArrayList();




    @FXML
    public TableView<Guest> guestTable;
    @FXML
    private TableColumn<Guest, String> gNameCol;
    @FXML
    private TableColumn<Guest, String> gAddrCol;
    @FXML
    private TableColumn<Guest, String> gCityCol;
    @FXML
    private TableColumn<Guest, Integer> gConCol;
    @FXML
    private TableColumn<Guest, String> gEmailCol;
    @FXML
    private TableColumn<Guest, Integer> gRoomCol;
    @FXML
    private TableColumn<Guest, LocalDate> gStart;
    @FXML
    private TableColumn<Guest, LocalDate> gEnd;

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
        guestTable.getItems().setAll(guestList());
        gNameCol.setCellValueFactory(new PropertyValueFactory<>("guestName"));
        gAddrCol.setCellValueFactory(new PropertyValueFactory<>("guestAddr"));
        gCityCol.setCellValueFactory(new PropertyValueFactory<>("guestCity"));
        gConCol.setCellValueFactory(new PropertyValueFactory<>("guestContact"));
        gEmailCol.setCellValueFactory(new PropertyValueFactory<>("guestEmail"));
        gRoomCol.setCellValueFactory(new PropertyValueFactory<>("guestRoom"));
        gStart.setCellValueFactory(new PropertyValueFactory<>("guestStartDate"));
        gEnd.setCellValueFactory(new PropertyValueFactory<>("guestEndDate"));

        System.out.println(guestTable.getSelectionModel().getSelectedIndex());

    }

//
//    private void refresh() {
//        roomTable.getItems().clear();
//        roomList.removeAll(roomList);
//        roomTable.getItems().setAll(roomList());
//    }

    @FXML
    private void AddGuest(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/administrationModules/frontOffice/RegisterGuest.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Add guest");
        stage.setScene(new Scene(parent));
//        stage.initOwner(((Stage) but_theatre.getScene().getWindow()));
//        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }

    @FXML
    private void removeGuest(ActionEvent event) {
        Guest guest = guestTable.getSelectionModel().getSelectedItem();

        guestList.remove(guest);
        guestTable.getItems().setAll(guestList);
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

    public ObservableList<Guest> guestList() {

        guestList.add(new Guest("Mr.A","6.b st", "Delhi", "995562", "1", "12-6-18", "20-6-18", "xyz@gmail.com" ));
        guestList.add(new Guest("Mr.B","7.b st", "Kolkata", "656221", "2", "15-6-18", "25-6-18", "xyz@gmail.com" ));
        return guestList;
    }

}
