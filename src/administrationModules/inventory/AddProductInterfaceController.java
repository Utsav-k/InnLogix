package administrationModules.inventory;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


        
        
public class AddProductInterfaceController implements Initializable {

 
    @FXML private JFXRadioButton inHouseButton, outsourcedButton; 
    @FXML private JFXTextField companyNameField, productPriceField, productMaxField,  productMinField, productNameTextField, productLnvField, productIDTextField;
    @FXML private Label companyNameLabel;

    @FXML
    TableView<productPart>  partsTable, partsTable1;

    @FXML
    private TableColumn<productPart, Integer> partsID, partsLevel, partsID1, partsLevel1;
   
    @FXML
    private TableColumn<productPart, Double> partsCost, partsCost1;
    
    @FXML
    private TableColumn<productPart, String> partsName, partsName1;
    
    private IMSFXMLDocumentController documentController; 
   
    Product productSelected;
    productPart productPartSelected;
    Boolean editData = false;
    ObservableList<productPart> productProductParts = FXCollections.observableArrayList();
    ObservableList<productPart> existingProductProductParts = FXCollections.observableArrayList();
    
    
    @FXML
    void productPartEditAction(ActionEvent event) {
        
        if (productPartSelected != null) {
            try {
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AddProductPartInterface.fxml"));
                Parent root;
                root = (Parent) loader.load();
                Stage stage = new Stage();
                stage.setTitle("Modify Product productPart Window");
                stage.setScene(new Scene(root));
                
                loader.<AddProductPartInterfaceController>getController()
                        .setParentController(this);

                AddProductPartInterfaceController api = loader.getController();
                
                api.setPart(productPartSelected);
                stage.show();

            } catch (IOException ex) {
                Logger.getLogger(IMSFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error!");
            alert.setHeaderText("Please, Select at-least one part to perform modify operation!");
            alert.setContentText(null);

            alert.showAndWait();
        }

    }

    
    @FXML
    void productPartDeleteAction(ActionEvent event) {
        
        if (productPartSelected != null) {
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Causion!");
            alert.setHeaderText("Are you sure you want to delete productPart with ID : " + productPartSelected.getPartsID() + "?");
            alert.setContentText(null);
            
            Optional<ButtonType> result = alert.showAndWait();
            
            
            if (result.get() == ButtonType.OK) {
                partsTable.getItems().remove(productPartSelected);
                productProductParts.remove(productPartSelected);
                
                documentController.parts.remove(productPartSelected);
                documentController.partsTable.getItems().remove(productPartSelected);
            }
        }else {
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error!");
            alert.setHeaderText("Please, Select at-least one part to perform delete operation!");
            alert.setContentText(null);

            alert.showAndWait();
        }

    }

    
    @FXML
    void productPartDeAssociateAction(ActionEvent event) {
        
        if (productPartSelected != null) {
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Causion!");
            alert.setHeaderText("Are you sure you want to De-Associate productPart with ID : " + productPartSelected.getPartsID() + " From this Product?");
            alert.setContentText(null);
            
            Optional<ButtonType> result = alert.showAndWait();
            
            if (result.get() == ButtonType.OK) {
                
                partsTable.getItems().remove(productPartSelected);
                productProductParts.remove(productPartSelected);
                productPartSelected.setAssociatedPartID(-1);
            }
        }else {
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error!");
            alert.setHeaderText("Please, Select at-least one part to perform delete operation!");
            alert.setContentText(null);

            alert.showAndWait();
        }

    }

    
    @FXML
    void closeButtonAction(ActionEvent event){
            
            final Node source = (Node) event.getSource();
            final Stage stage = (Stage) source.getScene().getWindow();
            stage.close();

    }
    
    
    @FXML
    private void addProductAssociatedPart(ActionEvent event) {
        
        try {
            
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("AddProductPartInterface.fxml"));
                    Parent root;
                    root = (Parent) loader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Add Product productPart Window");
                    stage.setScene(new Scene(root));
                    
                    loader.<AddProductPartInterfaceController>getController()
                            .setParentController(this);
                    
                    AddProductPartInterfaceController api = loader.getController();
                    
                    api.setID(documentController.generatePartsID());
                    api.setAssociatedPart(Integer.parseInt(productIDTextField.getText()));
                    stage.show();
                    
                    
        } catch (IOException ex) {
                    Logger.getLogger(IMSFXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    @FXML
    void productSaveButtonAction(ActionEvent event){
        
        if(productProductParts.isEmpty() == false || existingProductProductParts.isEmpty() == false){
            
            if (Integer.parseInt(productMaxField.getText()) > Integer.parseInt(productMinField.getText())) {
                
                if (Integer.parseInt(productLnvField.getText()) < Integer.parseInt(productMaxField.getText())) {
                    
                    if (editData == true) {
                        
                        documentController.updateProduct(
                                Integer.parseInt(productIDTextField.getText()),
                                productNameTextField.getText(),
                                Integer.parseInt(productLnvField.getText()),
                                Double.parseDouble(productPriceField.getText()),
                                productSelected,
                                Integer.parseInt(productMaxField.getText()),
                                Integer.parseInt(productMinField.getText())
                        );

                        
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Success!");
                        alert.setHeaderText("Successfully Updated Product Information!");
                        alert.setContentText(null);
                        alert.showAndWait();
                    } else {
                        
                        
                        documentController.addNewProduct(
                                Integer.parseInt(productIDTextField.getText()),
                                productNameTextField.getText(),
                                Integer.parseInt(productLnvField.getText()),
                                Double.parseDouble(productPriceField.getText()),
                                Integer.parseInt(productMaxField.getText()),
                                Integer.parseInt(productMinField.getText())
                        );

                        
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Success!");
                        alert.setHeaderText("Successfully Added new Product!");
                        alert.setContentText(null);
                        alert.showAndWait();
                    }

                    
                    final Node source = (Node) event.getSource();
                    final Stage stage = (Stage) source.getScene().getWindow();
                    stage.close();
                } else {
                    
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error!");
                    alert.setHeaderText("Max value can not be lower then inventory level value!");
                    alert.setContentText(null);
                    alert.showAndWait();
                }

            } else {
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
                alert.setHeaderText("Max value can not be lower then min value!");
                alert.setContentText(null);
                alert.showAndWait();
            }
        } else {
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Products must have atleast one part!");
            alert.setContentText(null);
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

        
        partsID.setCellValueFactory(new PropertyValueFactory<>("partsID"));
        partsLevel.setCellValueFactory(new PropertyValueFactory<>("partsLevel"));
        partsCost.setCellValueFactory(new PropertyValueFactory<>("partsCost"));
        partsName.setCellValueFactory(new PropertyValueFactory<>("partsName"));
        
        partsID1.setCellValueFactory(new PropertyValueFactory<>("partsID"));
        partsLevel1.setCellValueFactory(new PropertyValueFactory<>("partsLevel"));
        partsCost1.setCellValueFactory(new PropertyValueFactory<>("partsCost"));
        partsName1.setCellValueFactory(new PropertyValueFactory<>("partsName"));
        
        partsTable.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                
                productPartSelected = partsTable.getSelectionModel().getSelectedItem();

            }
        });
    }    
    
    
    void setParentController(IMSFXMLDocumentController documentController) {
        this.documentController = documentController;
    }

    
    void setData(Product productSelected) {
        
        productIDTextField.setText(""+productSelected.getProductID());
        productNameTextField.setText(productSelected.getProductName());
        productLnvField.setText("" + productSelected.getProductLevel());
        productPriceField.setText("" + productSelected.getProductCost());
        productMaxField.setText("" + productSelected.getProductMax());
        productMinField.setText("" + productSelected.getProductMin());
        this.productSelected = productSelected;
        editData = true;
    }

    
    void setData(int generateProductsID) {
        productIDTextField.setText(""+generateProductsID);
    }
    
    
    void addToTempProductTableView(int pID, String pName, int pLevel, double pCost, int pMax, int pMin, String pCompMac, Boolean inHouse, int asID){
                productProductParts.add(new productPart( pID, pName, pLevel, pCost, pMax, pMin, pCompMac, inHouse, asID));
        
         partsTable1.getItems().clear();
         partsTable1.getItems().setAll(productProductParts);
         
         documentController.addNewPart(pID, pName, pLevel, pCost, pMax, pMin, pCompMac, inHouse, asID);

    }
    
    
    void updatePart(int pID, String pName, int pLevel, double pCost, productPart selectedProductPart, int pMax, int pMin, String pCompMach, Boolean inHouse, int asID) {
        
        productPartSelected.setPartsCost(pID);
        productPartSelected.setPartsName(pName);
        productPartSelected.setPartsLevel(pLevel);
        productPartSelected.setPartsCost(pCost);
        productPartSelected.setPartMax(pMax);
        productPartSelected.setPartMin(pMin);
        productPartSelected.setCompanyNameOrMachineID(pCompMach);
        productPartSelected.setInHouse(inHouse);
        productPartSelected.setAssociatedPartID(asID);
        partsTable.getItems().clear();
        partsTable.getItems().setAll(existingProductProductParts);
        
        documentController.updatePart(pID, pName, pLevel, pCost, selectedProductPart, pMax, pMin, pCompMach, inHouse, asID);
        
    }
    


}
