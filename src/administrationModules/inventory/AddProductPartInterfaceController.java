package administrationModules.inventory;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AddProductPartInterfaceController implements Initializable {

    @FXML private JFXTextField partCompanyNameField, partPriceField, partMaxField,  partMinField, partNameTextField, partLnvField, partIDTextField,partMachineIDField;
    @FXML private JFXRadioButton inHouseButton, outsourcedButton;
    @FXML private Label partCompanyNameLabel, partMachineIDLabel;
    @FXML private javafx.scene.control.Button closeButton;
    
    
    
    productPart selectedProductPart;
    
    Boolean editData = false, inHouse = true;
    
    private AddProductInterfaceController documentController;
    
    
    int asProID = -1;
    
    
    @FXML
    void closeButtonAction(ActionEvent event){
        
            final Node source = (Node) event.getSource();
            final Stage stage = (Stage) source.getScene().getWindow();
            stage.close();

    }
    
    @FXML
    void outsourceButtonPress(ActionEvent event) {
        
        
        partCompanyNameField.setVisible(true);
        partCompanyNameLabel.setVisible(true);
        
        inHouseButton.setSelected(false);
        inHouse = false;
        outsourcedButton.setSelected(true);
       
        
        partMachineIDField.setVisible(false);
        partMachineIDLabel.setVisible(false);
        

    }
    
    
    @FXML
    void inHouseButtonAction(ActionEvent event){
        
        
        partCompanyNameField.setVisible(false);
        partCompanyNameLabel.setVisible(false);
        
        outsourcedButton.setSelected(false);
        inHouse = true;
        inHouseButton.setSelected(true);
        
        
        partMachineIDField.setVisible(true);
        partMachineIDLabel.setVisible(true);
     
    }
    
    
    @FXML
    void partSaveButtonAction(ActionEvent event){
        
        if (Integer.parseInt(partMaxField.getText()) > Integer.parseInt(partMinField.getText())) {
            if (Integer.parseInt(partLnvField.getText()) < Integer.parseInt(partMaxField.getText())) {
                String companyNameOrMachineID;
                if (inHouse) {
                    companyNameOrMachineID = partMachineIDField.getText();
                } else {
                    companyNameOrMachineID = partCompanyNameField.getText();
                }
                if (editData == false) {
                    documentController.addToTempProductTableView(
                            Integer.parseInt(partIDTextField.getText()), 
                            partNameTextField.getText(),
                            Integer.parseInt(partLnvField.getText()), 
                            Double.parseDouble(partPriceField.getText()), 
                            Integer.parseInt(partMaxField.getText()), 
                            Integer.parseInt(partMinField.getText()), 
                            companyNameOrMachineID,
                            inHouse,
                            asProID);

                    
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success!");
                    alert.setHeaderText("Successfully Added new productPart!");
                    alert.setContentText(null);
                    alert.showAndWait();

                } else {

                    documentController.updatePart(
                            Integer.parseInt(partIDTextField.getText()), 
                            partNameTextField.getText(),
                            Integer.parseInt(partLnvField.getText()), 
                            Double.parseDouble(partPriceField.getText()), 
                            selectedProductPart, 
                            Integer.parseInt(partMaxField.getText()), 
                            Integer.parseInt(partMinField.getText()), 
                            companyNameOrMachineID,
                            inHouse,
                            asProID
                    );

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
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

    }

    
    void setParentController(AddProductInterfaceController documentController) {
        this.documentController = documentController;
    }

    void setID(int generateID) {
        partIDTextField.setText(String.valueOf(generateID));
    }

    void setAssociatedPart(int asProID) {
        this.asProID = asProID;
    }

    void setPart(productPart productPartSelected) {

        partIDTextField.setText(String.valueOf(productPartSelected.getPartsID()));      
        partNameTextField.setText("" + productPartSelected.getPartsName());                 
        partLnvField.setText("" + productPartSelected.getPartsLevel());                  
        partPriceField.setText("" + productPartSelected.getPartsCost());               
        editData = true;                        
        partMaxField.setText("" + productPartSelected.getPartMax());
        partMinField.setText("" + productPartSelected.getPartMin());
        if (productPartSelected.inHouse) {
            inHouseButtonAction(null);
            partMachineIDField.setText("" + productPartSelected.getCompanyNameOrMachineID());      
        } else {
            outsourceButtonPress(null);
            partCompanyNameField.setText("" + productPartSelected.getCompanyNameOrMachineID());        
        }
        editData = true;
        selectedProductPart = productPartSelected;
    }

}
