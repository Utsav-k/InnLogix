package administrationModules.accounts;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

import static jdk.nashorn.internal.runtime.JSType.toInteger;

public class plotInventoryController implements Initializable {

	@FXML
	private BarChart<?, ?> CostChart;
	
	@FXML
	private CategoryAxis x;
	
	@FXML
	private NumberAxis y;

	@FXML
    private TextField productID;




	@Override
	public void initialize(URL url, ResourceBundle rb){

	}

	@FXML
	private void handleOKButtonAction(ActionEvent event) {
		XYChart.Series set1 = new XYChart.Series<>();

		if(toInteger(productID.getText()) == 101) {

			Product jan101 = new Product("101", "Jan", "200", "50");
			Product feb101 = new Product("101", "Feb", "200", "20");
			Product mar101 = new Product("101", "Mar", "200", "0");
			Product apr101 = new Product("101", "Apr", "200", "5");
			Product may101 = new Product("101", "May", "200", "10");
			Product jun101 = new Product("101", "Jun", "200", "02");
			Product jul101 = new Product("101", "Jul", "200", "25");
			Product aug101 = new Product("101", "Aug", "200", "60");
			Product sep101 = new Product("101", "Sep", "200", "0");
			Product oct101 = new Product("101", "Oct", "200", "20");
			Product nov101 = new Product("101", "Nov", "200", "10");
			Product dec101 = new Product("101", "Dec", "200", "5");

			set1.getData().add(new XYChart.Data("Jan", toInteger(jan101.getQuantity())));
			set1.getData().add(new XYChart.Data("Feb", toInteger(feb101.getQuantity())));
			set1.getData().add(new XYChart.Data("Mar", toInteger(mar101.getQuantity())));
			set1.getData().add(new XYChart.Data("Apr", toInteger(apr101.getQuantity())));
			set1.getData().add(new XYChart.Data("May", toInteger(may101.getQuantity())));
			set1.getData().add(new XYChart.Data("Jun", toInteger(jun101.getQuantity())));
			set1.getData().add(new XYChart.Data("Jul", toInteger(jul101.getQuantity())));
			set1.getData().add(new XYChart.Data("Aug", toInteger(aug101.getQuantity())));
			set1.getData().add(new XYChart.Data("Sep", toInteger(sep101.getQuantity())));
			set1.getData().add(new XYChart.Data("Oct", toInteger(oct101.getQuantity())));
			set1.getData().add(new XYChart.Data("Nov", toInteger(nov101.getQuantity())));
			set1.getData().add(new XYChart.Data("Dec", toInteger(dec101.getQuantity())));

			CostChart.getData().addAll(set1);


		}

		if(toInteger(productID.getText()) == 102) {


			Product jan102 = new Product("102", "Jan", "100", "0");
			Product feb102 = new Product("102", "Feb", "100", "10");
			Product mar102 = new Product("102", "Mar", "100", "0");
			Product apr102 = new Product("102", "Apr", "100", "4");
			Product may102 = new Product("102", "May", "100", "30");
			Product jun102 = new Product("102", "Jun", "100", "02");
			Product jul102 = new Product("102", "Jul", "100", "84");
			Product aug102 = new Product("102", "Aug", "100", "69");
			Product sep102 = new Product("102", "Sep", "100", "0");
			Product oct102 = new Product("102", "Oct", "100", "17s");
			Product nov102 = new Product("102", "Nov", "100", "39");
			Product dec102 = new Product("102", "Dec", "100", "9");

			set1.getData().add(new XYChart.Data("Jan", toInteger(jan102.getQuantity())));
			set1.getData().add(new XYChart.Data("Feb", toInteger(feb102.getQuantity())));
			set1.getData().add(new XYChart.Data("Mar", toInteger(mar102.getQuantity())));
			set1.getData().add(new XYChart.Data("Apr", toInteger(apr102.getQuantity())));
			set1.getData().add(new XYChart.Data("May", toInteger(may102.getQuantity())));
			set1.getData().add(new XYChart.Data("Jun", toInteger(jun102.getQuantity())));
			set1.getData().add(new XYChart.Data("Jul", toInteger(jul102.getQuantity())));
			set1.getData().add(new XYChart.Data("Aug", toInteger(aug102.getQuantity())));
			set1.getData().add(new XYChart.Data("Sep", toInteger(sep102.getQuantity())));
			set1.getData().add(new XYChart.Data("Oct", toInteger(oct102.getQuantity())));
			set1.getData().add(new XYChart.Data("Nov", toInteger(nov102.getQuantity())));
			set1.getData().add(new XYChart.Data("Dec", toInteger(dec102.getQuantity())));


			CostChart.getData().addAll(set1);
		}

	}
	@FXML
	private void handleBackButtonAction(ActionEvent event) throws IOException {
		Parent next_page_parent = FXMLLoader.load(getClass().getResource("fxmlInventory.fxml"));
		Scene next_page_scene = new Scene(next_page_parent);
		Stage next_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		next_stage.setScene(next_page_scene);
		next_stage.show();

	}
}
