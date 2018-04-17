package administrationModules.accounts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RevenueController implements Initializable {

    private double gym=30,spa=40,bhall=70,restaurant=50,bookings=90,others=15 ;

    private double totalRevenue = gym+spa+bhall+restaurant+bookings+others;

    @FXML
    private PieChart pieChart;

    @Override
    public void initialize(URL url, ResourceBundle rb){

    }

    public void handleActionButton(javafx.event.ActionEvent actionEvent) {
        ObservableList<PieChart.Data> pieChartData
                = FXCollections.observableArrayList(
                new PieChart.Data("GYM",  (gym/totalRevenue)*100),

                new PieChart.Data("SPA", (spa/totalRevenue)*100),
                new PieChart.Data("Banquet Hall",(bhall/totalRevenue)*100),
                new PieChart.Data("Restaurant",(restaurant/totalRevenue)*100),
                new PieChart.Data("Bookings",(bookings/totalRevenue)*100),
                new PieChart.Data("Others", (others/totalRevenue)*100));

        pieChart.setData(pieChartData);
    }

    public void backButtonAction(javafx.event.ActionEvent actionEvent) throws IOException{
        Parent next_page_parent = FXMLLoader.load(getClass().getResource("front.fxml"));
        Scene next_page_scene = new Scene(next_page_parent);
        Stage next_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        next_stage.setScene(next_page_scene);
        next_stage.show();
    }
}
