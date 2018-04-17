package administrationModules.Housekeeping;
import administrationModules.Housekeeping.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.sun.rowset.CachedRowSetImpl;
//import database.dbUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

//import static database.dbUtil.*;


public class housekeepingController implements Initializable{


        @FXML
        private TableView<Record> tableView;
        @FXML
        private TableColumn<Record,String> roomNo;
        @FXML
        private TableColumn<Record,String> roomType;
        @FXML
        private TableColumn<Record,String> status;
        @FXML
        private TableColumn<Record,String> availability;
        @FXML
        private TableColumn<Record,String> attendant;
        @FXML
        private TableColumn<Record,String> guest;
        @FXML
        private TableColumn<Record,String> request;

        @FXML
        private JFXButton backToDashboard;
        @FXML
        private JFXButton maintainance;
        @FXML
        private JFXButton assignAttendant;

        @FXML
        private Label validation;

        @FXML
        private JFXTextField roomNoText;
        @FXML
        private JFXTextField attendantText;

        public static ObservableList<Record> guests = FXCollections.observableArrayList();
   public  static int count = 0;

        @Override
         public void initialize(URL url, ResourceBundle rb) {

            roomNo.setCellValueFactory(new PropertyValueFactory<>("RoomNo"));
            roomType.setCellValueFactory(new PropertyValueFactory<>("RoomType"));
            status.setCellValueFactory(new PropertyValueFactory<>("Status"));
            availability.setCellValueFactory(new PropertyValueFactory<>("Availability"));
            attendant.setCellValueFactory(new PropertyValueFactory<>("Attendant"));
            guest.setCellValueFactory(new PropertyValueFactory<>("Guest"));
            request.setCellValueFactory(new PropertyValueFactory<>("Request"));
            //load dummy data
            //if(count!=1)
                tableView.setItems(getRecord());

         }

        public static  ObservableList<Record> getRecord() {

            if(count!=1) {
                Record SampleGuestRecord1 = new Record("001", "Single", "Occupied", "Mr.A ", "Jerry", "Reserve a table");
                Record SampleGuestRecord2 = new Record("002", "Single", "Dirty", "Mr.B ", "Jerry", "Call a cab");
                Record SampleGuestRecord3 = new Record("003", "Duplex", "Available", "Mr.C", "Carl", "Housekeeping");
                Record SampleGuestRecord4 = new Record("004", "Duplex", "Occupied", "Mr.D ", "Bob", "Tea");

                guests.add(SampleGuestRecord1);
                guests.add(SampleGuestRecord2);
                guests.add(SampleGuestRecord3);
                guests.add(SampleGuestRecord4);
            }
            /* to get  any new records that are created ie any new customers added or updated ADD FEATURE*/

            return guests;
        }


        //maintainance
        @FXML
        private void maintainanceButtonMethod(ActionEvent event)
        {
            try {
                Parent next_page_parent = FXMLLoader.load(getClass().getResource("/administrationModules/Housekeeping/maintainancePage.fxml"));
                Scene next_page_scene = new Scene(next_page_parent);
                Stage next_stage=new Stage();
                next_stage.setScene(next_page_scene);
                next_stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        @FXML
        private void assignAttendantButtonMethod(ActionEvent event)
        {
            if (roomNoText.getText()!=null) {

                    Record rec=guests.get(Integer.parseInt(roomNoText.getText())-1);
                 System.out.println(Integer.parseInt(roomNoText.getText()));
                    rec.setRequest("");System.out.println(Integer.parseInt(roomNoText.getText()));
                    rec.setAttendant(attendantText.getText());
                    guests.remove(Integer.parseInt(rec.getRoomNo())-1,Integer.parseInt(rec.getRoomNo()));
                    guests.add(Integer.parseInt(rec.getRoomNo()),rec);
                    tableView.setItems(guests);


            } else {
                this.validation.setText("INVALID ENTRY");
            }


        }

           //back to admin Dashboard
        @FXML
        private void backToDashboarduttonMethod(ActionEvent event)
        {
                Stage stage = (Stage)this.backToDashboard.getScene().getWindow();
                stage.close();

            try {

                login.LoginController object = new login.LoginController();
                object.adminLogin();
            }
            catch (Exception localException)
            {
                localException.printStackTrace();
            }
        }

//        public void addRequest(String room,String req){
//            guests = getRecord();
//            count = 1;
//            int rm=Integer.parseInt(room);
//            Record rec=guests.get(rm);
//            rec.setRequest(req);
//            guests.remove(rm,rm++);
//            guests.add(Integer.parseInt(rec.getRoomNo()),rec);
//            tableView.setItems(guests);
//
//        }
    }


