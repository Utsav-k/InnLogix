package administrationModules.restaurant;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UpdatesController {
	
	@FXML private TextField inputNumber;
	@FXML private Label message;
	

	public void confirm(ActionEvent event) {
		String enteredNumber = inputNumber.getText();
		
		try {
			
			if (enteredNumber.length() != 13 || !enteredNumber.substring(0, 1).equals("+")) {
				throw new Exception();
			}
	

			Double.parseDouble(enteredNumber.substring(1));



		

			ManageOrderController.getWindow().close();
			
		} catch (Exception e) {

			message.setVisible(true);
			message.setText("Invalid. e.g +447867662716");
		}

	}
	

	public void cancel(ActionEvent event) {

		ManageOrderController.getWindow().close();
	}

}
