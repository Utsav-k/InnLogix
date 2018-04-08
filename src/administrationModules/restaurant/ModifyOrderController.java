package administrationModules.restaurant;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ModifyOrderController implements Initializable {
	
	private static Stage window;
	private int orderID = Variables.getOrder();
	private Orders ordermate = Platform.getOrder(orderID);

	@FXML private Label lblOrderNumber, lblTotal;
	@FXML private TableView<ItemObject> tvItemTable;
	@FXML private TableColumn<ItemObject, String> item;
	@FXML private TableColumn<ItemObject, Integer> price;
	@FXML private TableColumn<ItemObject, String> quantity;
	@FXML private TextArea txtComments;
	@FXML private ComboBox<String> cbItems;
	@FXML private TextField txtQuantity;
	
	public HashMap<String, Integer> orderList2 = new HashMap<String, Integer>();
	

	public ObservableList<ItemObject> itemList = FXCollections.observableArrayList(Platform.getOrder(orderID).orderItemObjects());
	

	public ArrayList<ItemObject> exprimentOrderList = ordermate.orderItemObjects();
	

	ObservableList<String> dropdownList = FXCollections.observableArrayList(Items.items.keySet());
	

	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		

		lblOrderNumber.setText("Order " + orderID);
		lblOrderNumber.setVisible(true);
		

		lblTotal.setText("£" + ordermate.getOrderTotalObjects() + ".00" );
		

		tvItemTable.setItems(itemList);
		

		item.setCellValueFactory(new PropertyValueFactory<ItemObject, String>("name"));
		price.setCellValueFactory(new PropertyValueFactory<ItemObject, Integer>("price"));
		quantity.setCellValueFactory(new PropertyValueFactory<ItemObject, String>("quantity"));
		

		txtComments.setText(Platform.getOrder(orderID).getComments());
		

		cbItems.setItems(dropdownList);
		txtQuantity.setText("1");
		txtQuantity.setDisable(true);
		cbItems.getSelectionModel().selectFirst();
		

	}
	

	public void deleteItem(ActionEvent event) {
		

		Orders order = Platform.getOrder(orderID);
		

		ObservableList<ItemObject> allItems;
				

		ItemObject itemSelected;
				

		allItems = tvItemTable.getItems();
				

		itemSelected = tvItemTable.getSelectionModel().getSelectedItem();
				

		allItems.remove(itemSelected);
		
		

		

		order.removeItemBuffer(itemSelected);
		

		lblTotal.setText("£" + order.getOrderTotalObjects() + ".00" );
	}
	
	

	public void Home(ActionEvent event) throws IOException {
		

		Platform.getOrder(orderID).addComments(txtComments.getText());
		

		Platform.getScene().home();
	
	}
	

	public void deleteConformation(ActionEvent event) throws IOException {
		
		Variables.setOrderSelected(ordermate);

		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		Parent root = FXMLLoader.load(getClass().getResource("/administrationModules/restaurant/ModifyConfirmBox.fxml"));
		Scene scene = new Scene(root, 300, 200);
		scene.getStylesheets().add(getClass().getResource("resStyle.css").toExternalForm());
		window.setScene(scene);
		window.show();
	}
	

	public static Stage getWindow() {
		return window;	
	}
	
	

	public void addItem(ActionEvent event) {
		

		String text = cbItems.getSelectionModel().getSelectedItem();
		int quantity2 = Integer.parseInt(txtQuantity.getText());
				
		
		if (orderList2.containsKey(text)) {
			orderList2.put(text, orderList2.get(text) + quantity2);
		}
		
		else {
			orderList2.put(text, quantity2);
		}
		

		ItemObject item = new ItemObject(text, Items.getItemPrice(text), quantity2+"");


		exprimentOrderList.add(item);


		lblTotal.setText("£" + ordermate.getOrderTotalObjects() + ".00");
	

		tvItemTable.getItems().add(item);
		
	}
	
	
}
