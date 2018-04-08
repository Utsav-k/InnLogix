package administrationModules.restaurant;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;



public class NewOrderController implements Initializable {
	
	@FXML private Label total;
	@FXML private ComboBox<String> cbItems, cbTables;
	@FXML private TextField txtQuantity;
	@FXML private Button btnOrder;
	@FXML private TableView<ItemObject> orderTable;
	@FXML private TableColumn<ItemObject, String> quantityColumn;
	@FXML private TableColumn<ItemObject, String> itemColumn;
	@FXML private TableColumn<ItemObject, Integer> priceColumn;
	@FXML private TextArea txtComments;
	
	public ObservableList<ItemObject> itemList = FXCollections.observableArrayList();
	public HashMap<String, Integer> orderList2 = new HashMap<String, Integer>();
	public int table;
	public int subTotal = 0;


	public ArrayList<ItemObject> exprimentOrderList = new ArrayList<ItemObject>();


	ObservableList<String> dropdownList = FXCollections.observableArrayList(Items.items.keySet());
	


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		txtQuantity.setText("1");

		
		


		

		quantityColumn.setCellValueFactory(new PropertyValueFactory<ItemObject, String>("quantity"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<ItemObject, Integer>("price"));
		itemColumn.setCellValueFactory(new PropertyValueFactory<ItemObject, String>("name"));
		

		cbItems.setItems(dropdownList);
		

		cbTables.setItems(hasOrders(Platform.getAllTables()));
		

		cbItems.getSelectionModel().selectFirst();
			
	}
	

	public void Home(ActionEvent event) throws IOException {
		

		Platform.getScene().home();
	}
	


	public void makeOrder(ActionEvent event) throws IOException {
		

		String tableNumber = cbTables.getSelectionModel().getSelectedItem(); 
		table = Integer.parseInt(tableNumber);
		

		Orders order = new Orders(table); 
		

		order.addMultipleOrderItems(orderList2);
		order.addMultipleItemBuffer(exprimentOrderList);
		

		order.addComments(txtComments.getText());
		

		order.displayOrder(); 
		

		

		exprimentOrderList.removeAll(exprimentOrderList);
		

		Platform.putOrder(order, order.getOrderID()); 
		

		Platform.getTable(table).orderID = order.getOrderID(); 
		

		table = 0;
		

		Platform.getScene().home();
		












		
	}
	

	public void changeCombo(ActionEvent event) {
		btnOrder.setDisable(false);
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


		subTotal += Items.getItemPrice(text) * (quantity2);
		

		total.setText("" + subTotal + ".00");
	

		orderTable.getItems().add(item);
		

		if (!orderTable.getItems().isEmpty()) {
			cbTables.setDisable(false);
		}	
	}
	


	public static ObservableList<String> hasOrders(HashMap<Integer, Tables> map) {
		

		ObservableList<String> tablesOlist = FXCollections.observableArrayList();
		for (Map.Entry<Integer, Tables> table : map.entrySet()) {
			if (table.getValue().orderID == 0) {
				tablesOlist.add(table.getKey().toString());
			}
		}
		return tablesOlist;
	}
}