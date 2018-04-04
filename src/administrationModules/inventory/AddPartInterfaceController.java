package administrationModules.inventory;

import com.jfoenix.controls.JFXButton;
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

public class AddPartInterfaceController implements Initializable {

    
    @FXML private JFXTextField partCompanyNameField, partPriceField, partMaxField,  partMinField, partNameTextField, partLnvField, partIDTextField,partMachineIDField;
    @FXML private JFXRadioButton inHouseButton, outsourcedButton;
    @FXML private Label partCompanyNameLabel, partMachineIDLabel;
    @FXML private JFXButton partSaveButton, closeButton;
    

    productPart selectedProductPart;

    Boolean editData = false, inHouse = true;

    private IMSFXMLDocumentController documentController;
    private AddProductInterfaceController documentController1;

    int asProID = -1;

    @FXML
    void closeButtonAction(ActionEvent event)
    {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void outsourceButtonPress(ActionEvent event) 
    {
        

        partCompanyNameField.setVisible(true);
        partCompanyNameLabel.setVisible(true);
        
        inHouseButton.setSelected(false);
        inHouse = false;
        outsourcedButton.setSelected(true);

        partMachineIDField.setVisible(false);
        partMachineIDLabel.setVisible(false);

    }
    

    @FXML
    void inHouseButtonAction(ActionEvent event)
    {
        
        partCompanyNameField.setVisible(false);
        partCompanyNameLabel.setVisible(false);
        
        outsourcedButton.setSelected(false);
        inHouse = true;
        inHouseButton.setSelected(true);
        
        
        partMachineIDField.setVisible(true);
        partMachineIDLabel.setVisible(true);
    }
    
    
    @FXML
    void partSaveButtonAction(ActionEvent event) {
        if (Integer.parseInt(partMaxField.getText()) > Integer.parseInt(partMinField.getText())) {
            if (Integer.parseInt(partLnvField.getText()) < Integer.parseInt(partMaxField.getText())) {
                String companyNameOrMachineID;
                if (inHouse) {
                    companyNameOrMachineID = partMachineIDField.getText();
                } else {
                    companyNameOrMachineID = partCompanyNameField.getText();
                }

                
                if (editData == true) {
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

                    
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success!");
                    alert.setHeaderText("Successfully Updated productPart Data!");
                    alert.setContentText(null);
                    alert.showAndWait();

                } else {    
                    documentController.addNewPart(
                            Integer.parseInt(partIDTextField.getText()), 
                            partNameTextField.getText(),
                            Integer.parseInt(partLnvField.getText()), 
                            Double.parseDouble(partPriceField.getText()), 
                            Integer.parseInt(partMaxField.getText()), 
                            Integer.parseInt(partMinField.getText()), 
                            companyNameOrMachineID,
                            inHouse,
                            asProID
                    );

                    
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success!");
                    alert.setHeaderText("Successfully Added new productPart!");
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
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

    }

    
    void setParentController(IMSFXMLDocumentController documentController) {
        this.documentController = documentController;
    }

    
    void setData(productPart selectedProductPart) {

        this.selectedProductPart = selectedProductPart;
        partIDTextField.setText(String.valueOf(selectedProductPart.getPartsID()));      
        partNameTextField.setText("" + selectedProductPart.getPartsName());                 
        partLnvField.setText("" + selectedProductPart.getPartsLevel());                  
        partPriceField.setText("" + selectedProductPart.getPartsCost());               
        editData = true;                        
        partMaxField.setText("" + selectedProductPart.getPartMax());
        partMinField.setText("" + selectedProductPart.getPartMin());
        if (selectedProductPart.inHouse) {
            inHouseButtonAction(null);
            partMachineIDField.setText("" + selectedProductPart.getCompanyNameOrMachineID());      
        } else {
            outsourceButtonPress(null);
            partCompanyNameField.setText("" + selectedProductPart.getCompanyNameOrMachineID());        
        }
    }

    
    void setID(int generateID) {
        partIDTextField.setText(String.valueOf(generateID));
    }
    
    
    void setAssociatedPart(int asProID) {
        this.asProID = asProID;
    }
    
}
