/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrationModules.frontOffice;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author ArKadius
 */
public class
RegisterGuestController implements Initializable {

//GuestsController gCon = new GuestsController();
    @FXML
    private JFXTextField gName;
    @FXML
    private JFXTextField gAddr;
    @FXML
    private JFXTextField gCity;
    @FXML
    private JFXTextField gContact;
    @FXML
    private JFXTextField gRoom;
    @FXML
    private JFXTextField gEmailID;

    @FXML
    private JFXDatePicker gStart;
    @FXML
    private JFXDatePicker gEnd;

    @FXML
    private JFXButton register;
    @FXML
    private JFXButton back;
    private void closeStage() {
        ((Stage) register.getScene().getWindow()).close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

//    @FXML
//    private void movieSearch(ActionEvent event) {
//        try{
//        String sql="Select id,name from movie where id="+movieid.getText();
//        ResultSet rs=DatabaseHandler.executeQuery(sql);
//        rs.next();
//        moviename.setText(rs.getString("name"));
//        rs.close();
//        DatabaseHandler.disconnect();
//        flag1=true;
//        }catch(SQLException|NullPointerException ex)
//        {
//            flag1=false;
//            moviename.setText("");
//            AlertMaker.showNotification("ID Error","Check the movie ID",AlertMaker.image_warning2);
//        }
//    }

//    @FXML
//    private void theatreSearch(ActionEvent event){
//        if(theatreid.getText()!=null)
//        {
//        try{
//        String sql="Select id,name,hall from theatre where id="+theatreid.getText();
//        ResultSet rs=DatabaseHandler.executeQuery(sql);
//        rs.next();
//        theatrename.setText(rs.getString("name"));
//        hall.setText(rs.getString("hall"));
//        rs.close();
//        DatabaseHandler.disconnect();
//        flag2=true;
//        }catch(NullPointerException | SQLException ex)
//        {
//            flag2=false;
//            theatrename.setText("");
//            hall.setText("");
//            AlertMaker.showNotification("ID Error","Check the Theatre ID",AlertMaker.image_warning2);
//        }
//        }
//    }
    private void insertShow()
    {
//       RoomsController rCon = new RoomsController();
//       rCon.roomList.add(new )
    }
    @FXML
    private void RegisterShow(ActionEvent event) throws IOException {
        String name = gName.getText();
        String addr = gAddr.getText();
        String city = gCity.getText();
        String con = gContact.getText();
        String room = gRoom.getText();
        //gStart.getValue();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MMM-yyy");
        String startString = ( gStart.getValue()).format(fmt);
        String endString = (gEnd.getValue()).format(fmt);


        String em = gEmailID.getText();

       Guest obj = new Guest(name, addr, city, con, room, startString, endString, em);
        GuestsController.guestList.add(obj);//gCon.guestTable.getItems().setAll(gCon.guestList);
        Parent parent = FXMLLoader.load(getClass().getResource("/administrationModules/frontOffice/GuestDB.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Room DB");
        stage.setScene(new Scene(parent));
//        stage.initOwner(((Stage) but_theatre.getScene().getWindow()));
//        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }

    @FXML
    private void goBack(ActionEvent event) {
        closeStage();
    }
    
}
