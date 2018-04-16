package administrationModules.inventory;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class IMSFXMLDocumentController implements Initializable {

   
    @FXML
    TableView<Product> productTable;

    @FXML
    private TableColumn<Product, Integer> productID, productLevel;
    
    @FXML
    private TableColumn<Product, Double> productCost;
    
    @FXML
    private TableColumn<Product, String> productName;
    
    @FXML
    private JFXTextField productFilterString;
    
    @FXML
    TableView <productPart>  partsTable;
    
    @FXML
    private TableColumn<productPart, Integer> partsID, partsLevel;
    
    @FXML
    private TableColumn<productPart, Double> partsCost;
    
    @FXML
    private TableColumn<productPart, String> partsName;
    
    @FXML
    private JFXTextField partsFilterString;
   
    
  
    ObservableList<productPart> parts = FXCollections.observableArrayList();
    ObservableList<Product> products = FXCollections.observableArrayList();
    
    Boolean inHouse; 
    productPart selectedPart = null;
    Product productSelected = null;
    SortedList<productPart> sortedData;
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        productTable.getItems().setAll(products());
       
        productID.setCellValueFactory(new PropertyValueFactory<>("productID"));
        productLevel.setCellValueFactory(new PropertyValueFactory<>("productLevel"));
        productCost.setCellValueFactory(new PropertyValueFactory<>("productCost"));
        productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        productTable.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                
              
                productSelected = productTable.getSelectionModel().getSelectedItem();
                
            }
        });
       
        partsTable.getItems().setAll(parts());

        partsID.setCellValueFactory(new PropertyValueFactory("partsID"));
        partsLevel.setCellValueFactory(new PropertyValueFactory("partsLevel"));
        partsCost.setCellValueFactory(new PropertyValueFactory("partsCost"));
        partsName.setCellValueFactory(new PropertyValueFactory("partsName"));
        
        partsTable.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                
              
                selectedPart = partsTable.getSelectionModel().getSelectedItem();
                
            }
        });
        
    }

  
    @FXML
    void partAddButtonAction(ActionEvent event) {
        
      
        try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("AddPartInterface.fxml"));    
                    Parent root = (Parent) loader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Add productPart Window");
                    stage.setScene(new Scene(root));
                    loader.<AddPartInterfaceController>getController()
                            .setParentController(this);
                    AddPartInterfaceController api = loader.getController();
                    api.setID(generatePartsID());
                    stage.show();
                    
                    
        } catch (IOException ex) {
                    Logger.getLogger(IMSFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
  
    @FXML
    void partsModifyButtonAction(ActionEvent event) {
        
      
        if (selectedPart != null) {
            try {
              
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AddPartInterface.fxml"));    
                Parent root = (Parent) loader.load();
                Stage stage = new Stage();
                stage.setTitle("Modify productPart Window");

                stage.setScene(new Scene(root));
                loader.<AddPartInterfaceController>getController()
                        .setParentController(this);

                AddPartInterfaceController api = loader.getController();
              
                api.setData(selectedPart);
                stage.show();

            } catch (IOException ex) {
                Logger.getLogger(IMSFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{      
          
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error!");
            alert.setHeaderText("Please, Select a part to modify");
            alert.setContentText(null);

            alert.showAndWait();
        }
    }
    
  
    @FXML
    void deletePartsAction(ActionEvent event) {
        
      
        if (selectedPart != null && selectedPart.getAssociatedPartID() == -1) {
            Alert alert = new Alert(AlertType.CONFIRMATION);

            alert.setTitle("Causion!");
            alert.setHeaderText("Are you sure you want to delete productPart ID : " + selectedPart.getPartsID() + "?");
            alert.setContentText(null);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) { 
             
                    partsTable.getItems().remove(selectedPart);
                    parts.remove(selectedPart);
                
            }
            
        } 
        
      
        else if (selectedPart != null && selectedPart.getAssociatedPartID() != -1) {

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Error!");
            alert.setHeaderText("Selected part is associated with Product ID : " + selectedPart.associatedPartID + "\nCan't delete the item directly, Please, Go to the modify part section.");
            alert.setContentText(null);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("AddProductInterface.fxml"));
                    Parent root = (Parent) loader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Update Product Window");

                    stage.setScene(new Scene(root));
                    loader.<AddProductInterfaceController>getController()
                            .setParentController(this);

                  
                    for (Product p : products) {
                        if (selectedPart.associatedPartID == p.getProductID()) {
                            productSelected = p;
                        }
                    }

                    AddProductInterfaceController api = loader.getController();
                    api.setData(productSelected);

                  
                    for (productPart p : parts) {
                        if (productSelected.getProductID() == p.getAssociatedPartID()) {
                            api.existingProductProductParts.add(p);
                        }
                    }

                    api.partsTable.getItems().setAll(api.existingProductProductParts);

                    stage.show();

                } catch (IOException ex) {
                    Logger.getLogger(IMSFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
              
            }
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Error!");
            alert.setHeaderText("Please, Select at-least one part to perform delete operation!");
            alert.setContentText(null);

            alert.showAndWait();
        }
    }
    

    @FXML
    void partsSearchButtonAction(ActionEvent event) {
        FilteredList<productPart> filteredData = new FilteredList<>(parts,p -> true);
        
                    filteredData.setPredicate(productPart -> {
                      
                            if (partsFilterString.getText() == null || partsFilterString.getText().isEmpty()) {
                                return true;
                            }

                          
                          
                            String lowerCaseFilter = partsFilterString.getText().toLowerCase();

                            if(productPart.getPartsName().toLowerCase().contains(lowerCaseFilter)) {
                                return true;
                            } 
                            
                            return false;
                        });
               


        sortedData = new SortedList<>(filteredData);


        sortedData.comparatorProperty().bind(partsTable.comparatorProperty());


        partsTable.setItems(sortedData);

    }
    

    @FXML
    void productAddButtonAction(ActionEvent event){
        
        try {
                    FXMLLoader loader1 = new FXMLLoader(getClass().getResource("AddProductInterface.fxml"));  
                    Parent root1 = (Parent) loader1.load();
                    Stage stage1 = new Stage();
                    stage1.setTitle("Add Product Window");
                    stage1.setScene(new Scene(root1));
                    loader1.<AddProductInterfaceController>getController()
                            .setParentController(this);
                    AddProductInterfaceController api = loader1.getController();
                    api.setData(generateProductsID());
                    stage1.show();
                    
        } catch (IOException ex) {
                    Logger.getLogger(IMSFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
  
    @FXML
    void productModifyButtonAction(ActionEvent event) {
        
        if (productSelected != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AddProductInterface.fxml"));
                Parent root = (Parent) loader.load();
                Stage stage = new Stage();
                stage.setTitle("Update Product Window");

                stage.setScene(new Scene(root));
                loader.<AddProductInterfaceController>getController()
                        .setParentController(this);

                AddProductInterfaceController api = loader.getController();
                api.setData(productSelected);     

              
                for (productPart p : parts) {
                    if (productSelected.getProductID() == p.getAssociatedPartID()) {
                        api.existingProductProductParts.add(p);
                    }
                }

              
                api.partsTable.getItems().setAll(api.existingProductProductParts);

                stage.show();

            } catch (IOException ex) {
                Logger.getLogger(IMSFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Error!");
            alert.setHeaderText("Please, Select at-least one part to modify!");
            alert.setContentText(null);

            alert.showAndWait();
        }
    }
    
  
    int generatePartsID(){
        int a = 1;
        
        for( productPart o: parts){
            if(o.getPartsID() >= a){
                a = o.getPartsID() + 1;
            }
        }
        
        return a;
    }
    
  
    int generateProductsID(){
        int a = 1;
        
        for( Product o: products){
            if(o.getProductID() >= a){
                a = o.getProductID() + 1;
            }
        }
        
        return a;
    }
    
  
    @FXML
    void deleteProductSelected(ActionEvent event) {
        
      
        if (productSelected != null) {
            
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Causion!");
            alert.setHeaderText("Are you sure you want to delete productPart ID : " + productSelected.getProductID() + "?");
            String warningText = "Deleting this product will also delete assosciated parts:";
            
          
            for( productPart p: parts){
                if(p.getAssociatedPartID() == productSelected.getProductID()){
                    warningText += "\nProduct ID : "+p.getPartsID();
                }
            }
            alert.setContentText(warningText);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
              
                for (Iterator<productPart> p1 = parts.iterator(); p1.hasNext();) {
                    productPart p = p1.next();
                    if (p.getAssociatedPartID() == productSelected.getProductID()) {
                        
                        p1.remove();
                        partsTable.getItems().remove(p);
                        
                    }
                }
                
              
                productTable.getItems().remove(productSelected);
                products.remove(productSelected);
                
                Alert alert1 = new Alert(AlertType.INFORMATION);
                alert1.setTitle("Success!");
                alert1.setHeaderText("Successfully deleted product with all associated parts!");
                alert1.setContentText(null);

                alert1.showAndWait();
            }
        }else {
          
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Error!");
            alert.setHeaderText("Please, Select at-least one part to perform delete operation!");
            alert.setContentText(null);

            alert.showAndWait();
        }
        
    }
    
  
    @FXML
    void productSearchButtonAction(ActionEvent event) {
        FilteredList<Product> filteredData = new FilteredList<>(products,p -> true);
        
                    filteredData.setPredicate(Product -> {
                      
                            if (productFilterString.getText() == null || productFilterString.getText().isEmpty()) {
                                return true;
                            }

                          
                          
                            String lowerCaseFilter = productFilterString.getText().toLowerCase();

                            if(Product.getProductName().toLowerCase().contains(lowerCaseFilter)) {
                                return true;
                            } 
                            
                            return false;
                        });
               

      
        SortedList<Product> sortedData1 = new SortedList<>(filteredData);

      
        sortedData1.comparatorProperty().bind(productTable.comparatorProperty());

      
        productTable.setItems(sortedData1);

    } 
    
  
    public ObservableList<productPart> parts(){
        
        parts.add(new productPart(1, "productPart 1", 2, 71.78, 7, 3, "1", true, -1));
        parts.add(new productPart(2, "productPart 2", 3, 42.89, 10, 1, "Apple", false, 3));
        parts.add(new productPart(3, "productPart 3", 5, 63.87, 5, 1, "Samsung", false, 4));
        parts.add(new productPart(4, "productPart 4", 6, 54.78, 8, 2, "EA-Sports", false, 4));
        parts.add(new productPart(5, "productPart 5", 7, 78.89, 10, 1, "MainGear", false, 2));
        parts.add(new productPart(6, "productPart 6", 8, 73.87, 5, 1, "Intel", false, 1));
        parts.add(new productPart(7, "productPart 7", 5, 44.78, 8, 2, "AMD", false, 1));
        
        return parts;
        
    }
    
  
    public ObservableList<Product> products(){
        
        products.add(new Product(1, "Product 1", 2, 1.78, 12, 2));
        products.add(new Product(2, "Product 2", 3, 2.89, 12, 2));
        products.add(new Product(3, "Product 3", 1, 3.87, 12, 2));
        products.add(new Product(4, "Product 4", 4, 4.78, 12, 1));
        
        
        return products;
        
    }
    
  
    public void addNewPart(int pID, String pName, int pLevel, double pCost, int pMax, int pMin, String pCompMac, Boolean inHouse, int asID){
      
        parts.add(new productPart( pID, pName, pLevel, pCost, pMax, pMin, pCompMac, inHouse, asID));
        partsTable.getItems().clear();
        partsTable.getItems().setAll(parts);

    }
    
  
    public void addNewProduct(int pID, String pName, int pLevel, double pCost, int pMax, int pMin){
      
        products.add(new Product( pID, pName, pLevel, pCost, pMax, pMin));
        productTable.getItems().clear();
        productTable.getItems().setAll(products);

    }   

  
    void updatePart(int pID, String pName, int pLevel, double pCost, productPart selectedPart, int pMax, int pMin, String pCompMach, Boolean inHouse, int asID) {
      
        selectedPart.setPartsCost(pID);
        selectedPart.setPartsName(pName);
        selectedPart.setPartsLevel(pLevel);
        selectedPart.setPartsCost(pCost);
        selectedPart.setPartMax(pMax);
        selectedPart.setPartMin(pMin);
        selectedPart.setCompanyNameOrMachineID(pCompMach);
        selectedPart.setInHouse(inHouse);
        
        partsTable.getItems().clear();
        partsTable.getItems().setAll(parts);   
        
    }

  
    void updateProduct(int pID, String pName, int pLevel, double pCost, Product productSelected, int pMax, int pMin) {
      
        productSelected.setProductID(pID);
        productSelected.setProductName(pName);
        productSelected.setProductCost(pCost);
        productSelected.setProductLevel(pLevel);
        productSelected.setProductMax(pMax);
        productSelected.setProductMin(pMin);
        
        productTable.getItems().clear();
        productTable.getItems().setAll(products);
    }

}
