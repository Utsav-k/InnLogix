package login;

import main.*;
import dashboard.*;
import guestModules.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginController implements Initializable{

    @FXML
    private JFXComboBox<String> type;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton loginButton;
    @FXML
    private Label wrongCreds;

    static boolean flag1 = false;


    ArrayList<User> users = new ArrayList<User>();

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

        User admin = new User("adminT", "admin", "yello");
        User guest = new User("guestT", "guest", "foo");
        users.add(admin);
        users.add(guest);

        type.getItems().add("admin"); //Change Selection colour
        type.getItems().add("guest");
    }

    @FXML
    private void loginButtonMethod(ActionEvent event)
    {
        try
        {

            if (isLogin(username.getText(), type.getValue(), password.getText()))
            {
                Stage stage = (Stage)this.loginButton.getScene().getWindow();
                stage.close();

                switch (type.getValue())
                {
                    case "admin":
                    {
                        adminLogin();
                    }
                    break;
                    case "guest": {
                        guestLogin();
                    }
                }
            }
            else
            {
                this.wrongCreds.setText("Wrong Credentials");
            }
        }
        catch (Exception localException)
        {
            localException.printStackTrace();
        }
    }

    public void guestLogin()
    {
        try
        {
            Stage userStage = new Stage();
            FXMLLoader guestLoader = new FXMLLoader();
            Pane root = (Pane)guestLoader.load(getClass().getResource("/guestModules/guest.fxml").openStream());
            GuestController GuestController = (GuestController)guestLoader.getController();

            Scene scene = new Scene(root);
            userStage.setScene(scene);
            userStage.setTitle("Guest Dashboard");
            userStage.setResizable(false);
            userStage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void adminLogin()
    {

        try
        {
          //Stage adminStage = new Stage();
            //FXMLLoader adminLoader = new FXMLLoader();
            AnchorPane adminroot = FXMLLoader.load(getClass().getResource("/dashboard/adminDashboard.fxml"));
            //adminDashboardController adminController = (adminDashboardController) adminLoader.getController();

            Scene adminscene = new Scene(adminroot);

            mainC.s.setScene(adminscene);
            mainC.s.setTitle("Admin Dashboard");
            mainC.s.setResizable(false);
            mainC.s.show();
            //System.out.println("ol");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    boolean isLogin(String username, String type, String password)
    {

        System.out.println(users.size());
        for(int j = 0; j < users.size();j++)
        {
            if(users.get(j).getUsername().compareTo(username) == 0 && users.get(j).getType().compareTo(type) == 0 && users.get(j).getPassword().compareTo(password) == 0)
            {
                System.out.println("opo");

                flag1 = true;
                break;

            }
            else
            {
                flag1 = false;
            }
        }
        System.out.println(flag1);
        return flag1;
    }
    }



