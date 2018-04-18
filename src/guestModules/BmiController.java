package guestModules;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class BmiController implements Initializable {

    @FXML
    public JFXTextField weight;

    @FXML
    public JFXTextField height;

    @FXML
    public JFXButton calculateButton;

    @FXML
    public JFXButton backButton;

    @FXML
    public Label bmiresult;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }



    public void calculateBmi(ActionEvent actionEvent) {
        double w =  Double.parseDouble(weight.getText());
        double h =  Double.parseDouble(height.getText());
        h /= 100;
        System.out.println(w/(h*h));
        double result = w/(h*h);

        DecimalFormat df = new DecimalFormat(".##");
        String result2 = df.format(result);

        String report;
        if(result<18.5) report="are in Underweight Category.";
        else if(result>=18.5 && result <25) report = "are in normal weight category.";
        else if(result>=25 && result <30) report = "are in over weight category.";
        else if(result>=30 && result <40) report = "are suffering from Obesity."+'\n'+ "You need to workout more.";
        else report = "should consult a doctor."+'\n'+ "You have morbid obesity.";
        String res = result2;
        String text = "Your BMI is "+res+"."+'\n'+ "You "+report;
        bmiresult.setText(text);

    }

    @FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        Parent next_page_parent = FXMLLoader.load(getClass().getResource("additional.fxml"));
        Scene next_page_scene = new Scene(next_page_parent);
        Stage next_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        next_stage.setScene(next_page_scene);
        next_stage.show();
    }



}
