package administrationModules.restaurant;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import dashboard.MenusController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomepageController implements Initializable {


	MenusController dash = new MenusController();
	@FXML private Label lblPlatformTotal;
	

	@FXML private Button btn1 = new Button("1");
	@FXML private Button btn2 = new Button("2");
	@FXML private Button btn3 = new Button("3");
	@FXML private Button btn4 = new Button("4");
	@FXML private Button btn5 = new Button("5");
	@FXML private Button btn6 = new Button("6");
	@FXML private Button btn7 = new Button("7");
	@FXML private Button btn8 = new Button("8");
	@FXML private Button btn9 = new Button("9");
	@FXML
	AnchorPane newOrder;

	@FXML private Button menuManager = new Button();
	@FXML private Button staffManager = new Button();
	@FXML public AnchorPane test;
	

	public ArrayList<Button> allButtons = new ArrayList<Button>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		lblPlatformTotal.setText("INR: " + Platform.getTotal() + ".00");
		addButtons();
		setButtonColour(allButtons);
		
		for (Button button : allButtons) {
			button.hoverProperty().addListener( (e) -> {
				int tableNumber = Integer.parseInt(button.getText());
				Tables table = Platform.getTable(tableNumber);
				Orders order = Platform.getOrder(table.getOrderID());
				System.out.println(button.getText());
			});
		}

		Employees test = new Employees("Manager", "Mr. A", "a", "a7", "password");
		Platform.setLoggedIn(test);
		Employees manager = new Employees("Staff", "Mr. B", "b", "b1", "password");
		Employees staff = new Employees("Staff", "Mr. C", "c", "c2", "password");
		Employees jake = new Employees("Staff", "Mr. D", "d", "d3", "password");
		Employees albert = new Employees("Staff", "Mr. E", "e", "e4", "password");

		Platform.putEmployee(manager, manager.getUsername());
		Platform.putEmployee(staff, staff.getUsername());
		Platform.putEmployee(test, test.getUsername());
		Platform.putEmployee(jake, jake.getUsername());
		Platform.putEmployee(albert, albert.getUsername());

		Items.addItem("Item A", 40);
		Items.addItem("Item B", 15);
		Items.addItem("Item C", 65);
		Items.addItem("Item D", 55);
		Items.addItem("Item E", 5);
		Items.addItem("Item F", 10);
		Items.addItem("Item G", 50);
		Items.addItem("Item H", 35);
		Items.addItem("Item I", 80);

		for (int i = 0; i < 9; i++) {
			Tables table = new Tables();
			Platform.putTable(table.tableNumber, table);
		}

//		Random rand = new Random();
//
//		for (int i = 0; i < 5; i++) {
//			Orders newOrder = new Orders(i+2);
//
//			newOrder.addItemBuffer(Items.itemObjects.get(Items.itemObjects.keySet().toArray()[rand.nextInt(8)]));
//			newOrder.addItemBuffer(Items.itemObjects.get(Items.itemObjects.keySet().toArray()[rand.nextInt(8)]));
//			newOrder.addItemBuffer(Items.itemObjects.get(Items.itemObjects.keySet().toArray()[rand.nextInt(8)]));
//			newOrder.addItemBuffer(Items.itemObjects.get(Items.itemObjects.keySet().toArray()[rand.nextInt(8)]));
//			Platform.putOrder(newOrder, newOrder.getOrderID());
//			Platform.getTable(newOrder.getOrderID()).orderID = newOrder.getOrderID();
//		}
		
	}
	
	public void setButtonColour(ArrayList<Button> allButtons) {
		
		Collection<Tables> allTables = Platform.getAllTables().values();
		ArrayList<Integer> availableTables = new ArrayList<Integer>();
		

		for (Tables table : allTables ) {

			if ( table.getOrderID() == 0) {
				availableTables.add(table.tableNumber);
			}
		}
		
		for (Button button : allButtons ) {
			if ( !availableTables.contains(Integer.parseInt(button.getText()))) {
				button.setStyle("-fx-color: #F06767;}");
			}
		}
	}
	

	public void addButtons() {
		allButtons.removeAll(allButtons);
		allButtons.add(btn1);
		allButtons.add(btn2);
		allButtons.add(btn3);
		allButtons.add(btn4);
		allButtons.add(btn5);
		allButtons.add(btn6);
		allButtons.add(btn7);
		allButtons.add(btn8);
		allButtons.add(btn9);	
	}
	

	public void modifyOrder(ActionEvent event) throws Exception {
		
		Tables table;
		Orders order;
		

		String selectedButton = event.getSource().toString().substring(35, 36);
		
		try {
			
			table = Platform.getTable(Integer.parseInt(selectedButton));
			order = Platform.getOrder(table.getOrderID());
			

			Variables.setOrder(order.getOrderID());
			

			goToModifyPage();
			

			order.displayOrder();
			
		} catch (Exception e) {
			System.out.println("This table is currently empty.");
			goToOrder();
		}
	}
	
	

	public void goToModifyPage() throws IOException {
	

		FXMLLoader loader =  new FXMLLoader();
		Parent root = loader.load(getClass().getResource("/administrationModules/restaurant/ModifyOrder.fxml").openStream());
		Scene scene = new Scene(root, 900, 500);
		scene.getStylesheets().add(getClass().getResource("resStyle.css").toExternalForm());
		dash.getStage().setScene(scene);
		
	}
	

	public void goToOrder() throws IOException {


		Parent root = FXMLLoader.load(getClass().getResource("/administrationModules/restaurant/NewOrder.fxml"));
		Scene scene = new Scene(root, 900, 500);
		scene.getStylesheets().add(getClass().getResource("resStyle.css").toExternalForm());
		dash.getStage().setScene(scene);
		dash.getStage().show();

	}
	


	

	public void newOrder(ActionEvent event) throws IOException {


		Parent root = FXMLLoader.load(getClass().getResource("/administrationModules/restaurant/NewMenuItem.fxml"));

		Scene scene = new Scene(root, 900, 500);
		scene.getStylesheets().add(getClass().getResource("resStyle.css").toExternalForm());
		MenusController.resStage.setScene(scene);
		MenusController.resStage.show();


	}
	

	public void goToOrder(ActionEvent event) throws IOException {


		Parent root = FXMLLoader.load(getClass().getResource("/administrationModules/restaurant/NewOrder.fxml"));
		Scene scene = new Scene(root, 900, 500);
		scene.getStylesheets().add(getClass().getResource("resStyle.css").toExternalForm());
		dash.getStage().setScene(scene);
		dash.getStage().show();

	}


	public void goToOrderManager(ActionEvent event) throws IOException {


		Parent root = FXMLLoader.load(getClass().getResource("/administrationModules/restaurant/ManageOrder.fxml"));
		Scene scene = new Scene(root, 900, 500);
		scene.getStylesheets().add(getClass().getResource("resStyle.css").toExternalForm());
		dash.getStage().setScene(scene);
		dash.getStage().show();

	}

	

	public void goToEmployeeManager(ActionEvent event) throws IOException {


		Parent root = FXMLLoader.load(getClass().getResource("/administrationModules/restaurant/ManageEmployees.fxml"));
		Scene scene = new Scene(root, 900, 500);
		scene.getStylesheets().add(getClass().getResource("resStyle.css").toExternalForm());
		dash.getStage().setScene(scene);
		dash.getStage().show();

	}
	
	

	public void logout(ActionEvent event) throws IOException {


		Parent root = FXMLLoader.load(getClass().getResource("/administrationModules/restaurant/Login.fxml"));
		Scene scene = new Scene(root, 900, 500);
		scene.getStylesheets().add(getClass().getResource("resStyle.css").toExternalForm());
		dash.getStage().setScene(scene);
		dash.getStage().show();

	}

}
