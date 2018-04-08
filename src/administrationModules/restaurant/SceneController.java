package administrationModules.restaurant;

import java.io.IOException;

import dashboard.MenusController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SceneController {
	

		MenusController dash = new MenusController();
		public void home() throws IOException {
			

			Parent root = FXMLLoader.load(getClass().getResource("/administrationModules/restaurant/Homepage.fxml"));
			Scene scene = new Scene(root, 900, 500);
			scene.getStylesheets().add(getClass().getResource("resStyle.css").toExternalForm());
			dash.getStage().setScene(scene);
			dash.getStage().show();
		
		}
		

		public void manageOrder() throws IOException {
			

			Parent root = FXMLLoader.load(getClass().getResource("/administrationModules/restaurant/ManageOrder.fxml"));
			Scene scene = new Scene(root, 900, 500);
			scene.getStylesheets().add(getClass().getResource("resStyle.css").toExternalForm());
			dash.getStage().setScene(scene);
			dash.getStage().show();
		
		}
		

		public void manageEmployees() throws IOException {
			

			Parent root = FXMLLoader.load(getClass().getResource("/administrationModules/restaurant/ManageEmployees.fxml"));
			Scene scene = new Scene(root, 900, 500);
			scene.getStylesheets().add(getClass().getResource("resStyle.css").toExternalForm());
			dash.getStage().setScene(scene);
			dash.getStage().show();

		}

}
