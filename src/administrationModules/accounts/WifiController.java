package administrationModules.accounts;

import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static jdk.nashorn.internal.runtime.JSType.toInteger;

public class WifiController implements Initializable {

    @FXML
    private BarChart<?, ?> DataChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;


    @Override
    public void initialize(URL url, ResourceBundle rb){

    }


    @FXML
    private void handleGenerateButtonAction(ActionEvent event) {
        XYChart.Series set1 = new XYChart.Series<>();


        set1.getData().add(new XYChart.Data("1",736));
        set1.getData().add(new XYChart.Data("2",783));
        set1.getData().add(new XYChart.Data("3",100));
        set1.getData().add(new XYChart.Data("4",200));
        set1.getData().add(new XYChart.Data("5",83));
        set1.getData().add(new XYChart.Data("6",90));
        set1.getData().add(new XYChart.Data("7",0));
        set1.getData().add(new XYChart.Data("8",82));
        set1.getData().add(new XYChart.Data("9",1200));

        DataChart.getData().addAll(set1);


    }
    @FXML
    private void handleBackButtonAction(ActionEvent event) throws IOException {
        Parent next_page_parent = FXMLLoader.load(getClass().getResource("front.fxml"));
        Scene next_page_scene = new Scene(next_page_parent);
        Stage next_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        next_stage.setScene(next_page_scene);
        next_stage.show();

    }

}
