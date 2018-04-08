package administrationModules.restaurant;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;


import dashboard.MenusController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ManageOrderController implements Initializable  {

	private static Stage window;
	@FXML private TableView<Orders> tvOrderTable;
	@FXML private TableColumn<Orders, Integer> id;
	@FXML private TableColumn<Orders, Integer> tableNumber;
	@FXML private TableColumn<Orders, String> date;
	@FXML private TableColumn<Orders, String> orderTotal;
	@FXML private TableColumn<Orders, String> itemsOrdered;
	@FXML private Button delete;
	@FXML private Button modify;
	@FXML private TextField filterField;
	private int sourceIndex;
	private int visibleIndex;
	SortedList<Orders> sortedData;
	MenusController dash = new MenusController();
	

	public ObservableList<Orders> orders = FXCollections.observableArrayList(Platform.getAllOrders().values());
	public FilteredList<Orders> filteredData = new FilteredList<>(orders, p -> true);
		
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		


		tvOrderTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		

		tvOrderTable.getSelectionModel().selectedItemProperty().addListener((order) -> {

			if ( !tvOrderTable.getSelectionModel().isEmpty() ) {
				modify.setDisable(false);
				delete.setDisable(false);
			}
			
			else {
				modify.setDisable(true);
				delete.setDisable(true);
			}
		});
		

		tvOrderTable.setItems(orders);
		

		id.setCellValueFactory(new PropertyValueFactory<Orders, Integer>("orderID"));
		tableNumber.setCellValueFactory(new PropertyValueFactory<Orders, Integer>("tableNumber"));
		date.setCellValueFactory(new PropertyValueFactory<Orders, String>("timeOfOrder"));
		orderTotal.setCellValueFactory(new PropertyValueFactory<Orders, String>("orderTotalObjects"));
		itemsOrdered.setCellValueFactory(new PropertyValueFactory<Orders, String>("itemOrderedString"));
				 
	

	
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
	            filteredData.setPredicate(order -> {

	                if (newValue == null || newValue.isEmpty()) {
	                    return true;
	                }

	                String lowerCaseFilter = newValue.toLowerCase();

	                if ((order.getTableNumber() + "").contains(lowerCaseFilter)) {
	                    return true;
	                } 
	               
	                else if ((order.getOrderID() + "").toLowerCase().contains(lowerCaseFilter)) {
	                    return true;
	                } 
	                
	                else if ((order.getItemOrderedString()).toLowerCase().contains(lowerCaseFilter)) {
	                    return true;
	                }
	                
	                return false;
	            });
	        });
		 
		 sortedData = new SortedList<>(filteredData);
		 sortedData.comparatorProperty().bind(tvOrderTable.comparatorProperty());		 
		 tvOrderTable.setItems(sortedData);

	}

	

	public void deleteConformation(ActionEvent event ) throws IOException {
		
		visibleIndex = tvOrderTable.getSelectionModel().getSelectedIndex();
		sourceIndex = sortedData.getSourceIndexFor(orders, visibleIndex);
		
		Variables.setMasterData(orders);
		Variables.setSourceIndex(sourceIndex);
		Variables.setVisibleIndex(visibleIndex);
		
		Variables.setOrderSelected(tvOrderTable.getSelectionModel().getSelectedItem());
		Variables.setAllOrders(tvOrderTable);
		
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		Parent root = FXMLLoader.load(getClass().getResource("/administrationModules/restaurant/ManageConfirmBox.fxml"));
		Scene scene = new Scene(root, 300, 200);
		scene.getStylesheets().add(getClass().getResource("resStyle.css").toExternalForm());
		window.setScene(scene);
		window.show();
	}


	public void modifyOrder(ActionEvent event) throws IOException {
		

		Orders orderSelected;
				

		orderSelected = tvOrderTable.getSelectionModel().getSelectedItem();
				
		Variables.setOrder(orderSelected.getOrderID());
		

		FXMLLoader loader =  new FXMLLoader();
		Parent root = loader.load(getClass().getResource("/administrationModules/restaurant/ModifyOrder.fxml").openStream());
		Scene scene = new Scene(root, 900, 500);
		scene.getStylesheets().add(getClass().getResource("resStyle.css").toExternalForm());
		dash.getStage().setScene(scene);
		
	}
	

	public void closeOrder(ActionEvent event) {
		

		Orders orderSelected;
						

		orderSelected = tvOrderTable.getSelectionModel().getSelectedItem();
		

		if (orderSelected.getTableNumber() != 0) {
		Platform.getTable(orderSelected.getTableNumber()).setOrderID(0);
		}
		
		orderSelected.setTableNumber(0);
		

		tvOrderTable.refresh();
		
	}


	public static Stage getWindow() {
		return window;
	}
	
	

	public void exportSelectedItems(ActionEvent event) throws IOException { 
		
		String path;
		
		final DirectoryChooser directoryChooser = new DirectoryChooser();
		
		final File chosenDirectory = directoryChooser.showDialog(dash.getStage());
		
		if (chosenDirectory != null) {
			
			path = chosenDirectory.getAbsolutePath() + "/order_data.csv/";
			System.out.println(path);
			

			ObservableList<Orders> ordersSelected;
			

			ordersSelected = tvOrderTable.getSelectionModel().getSelectedItems();
			

			Platform.exportToFile(ordersSelected, path);
		}
		
		else {
			System.out.println("NO DIRECTORY SELECTED");
		}
		
			
	}
	

	public void Home(ActionEvent event) throws IOException {
		

		Platform.getScene().home();
	}
	

	public void importOrders(ActionEvent event) throws IOException {
		

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Upload CSV");
		

		fileChooser.getExtensionFilters().addAll( new FileChooser.ExtensionFilter("CSV", "*.csv"));
		

		File file = fileChooser.showOpenDialog(dash.getStage());
		String path = "";
		
		try {
			if (file != null) {
				path = file.getPath();
				System.out.println(path);
			}
			


			

			Platform.getScene().manageOrder();
			
			}
		
		catch (FileNotFoundException e) {
			System.out.println("NO FILE SELECTED");
		}
	}
	
	

	public void updates(ActionEvent event ) throws IOException {
		
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		Parent root = FXMLLoader.load(getClass().getResource("/administrationModules/restaurant/Updates.fxml"));
		Scene scene = new Scene(root, 300, 200);
		scene.getStylesheets().add(getClass().getResource("resStyle.css").toExternalForm());
		window.setScene(scene);
		window.show();
	}

}
