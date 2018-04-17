package administrationModules.accounts;
import com.sun.javafx.scene.control.TableColumnComparatorBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
public class InventoryController implements Initializable {
    @FXML private TableView<Product> tableView;
    @FXML private TableColumn<Product, String> monthColumn;
    @FXML private TableColumn<Product, String> idColumn;
    @FXML private TableColumn<Product, String> priceColumn;
    @FXML private TableColumn<Product, String> quantityColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        monthColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("month"));
        idColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("id"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("price"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("quantity"));

        // loading the data

        tableView.setItems(getProduct());
    }
    public ObservableList<Product> getProduct(){
        ObservableList<Product> product = FXCollections.observableArrayList();

        Product jan101 = new Product("101", "Jan" , "200" , "50");
        Product feb101 = new Product("101", "Feb" , "200" , "20");
        Product mar101 = new Product("101", "Mar" , "200" , "0");
        Product apr101 = new Product("101", "Apr" , "200" , "5");
        Product may101 = new Product("101", "May" , "200" , "10");
        Product jun101 = new Product("101", "Jun" , "200" , "02");
        Product jul101 = new Product("101", "Jul" , "200" , "25");
        Product aug101 = new Product("101", "Aug" , "200" , "60");
        Product sep101 = new Product("101", "Aug" , "200" , "0");
        Product oct101 = new Product("101", "Aug" , "200" , "20");
        Product nov101 = new Product("101", "Aug" , "200" , "10");
        Product dec101 = new Product("101", "Aug" , "200" , "5");

        product.add(jan101);
        product.add(feb101);
        product.add(mar101);
        product.add(apr101);
        product.add(may101);
        product.add(jun101);
        product.add(jul101);
        product.add(aug101);
        product.add(sep101);
        product.add(oct101);
        product.add(nov101);
        product.add(dec101);

        Product jan102 = new Product("102", "Jan" , "100" , "0");
        Product feb102 = new Product("102", "Feb" , "100" , "10");
        Product mar102 = new Product("102", "Mar" , "100" , "0");
        Product apr102 = new Product("102", "Apr" , "100" , "4");
        Product may102 = new Product("102", "May" , "100" , "30");
        Product jun102 = new Product("102", "Jun" , "100" , "02");
        Product jul102 = new Product("102", "Jul" , "100" , "84");
        Product aug102 = new Product("102", "Aug" , "100" , "69");
        Product sep102 = new Product("102", "Aug" , "100" , "0");
        Product oct102 = new Product("102", "Aug" , "100" , "17s");
        Product nov102 = new Product("102", "Aug" , "100" , "39");
        Product dec102 = new Product("102", "Aug" , "100" , "9");

        product.add(jan102);
        product.add(feb102);
        product.add(mar102);
        product.add(apr102);
        product.add(may102);
        product.add(jun102);
        product.add(jul102);
        product.add(aug102);
        product.add(sep102);
        product.add(oct102);
        product.add(nov102);
        product.add(dec102);

        return product;
    }
    @FXML
    private void changeScene(ActionEvent event) throws IOException {
        Parent next_page_parent = FXMLLoader.load(getClass().getResource("front.fxml"));
        Scene next_page_scene = new Scene(next_page_parent);
        Stage next_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        next_stage.setScene(next_page_scene);
        next_stage.show();
    }

    @FXML
    private void generatePlot(ActionEvent event) throws IOException{
        Parent next_page_parent = FXMLLoader.load(getClass().getResource("plotInventory.fxml"));
        Scene next_page_scene = new Scene(next_page_parent);
        Stage next_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        next_stage.setScene(next_page_scene);
        next_stage.show();
    }

}
