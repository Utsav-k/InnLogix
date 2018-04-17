package guestModules;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class accountsController implements Initializable {


    @FXML
    private TableView<Transaction> tableViewAccount;
    @FXML
    private TableColumn<Transaction,String> particulars;
    @FXML
    private TableColumn<Transaction,String> amount;

    ObservableList<Transaction> transAction= FXCollections.observableArrayList();
    @FXML
    private JFXButton backButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        particulars.setCellValueFactory(new PropertyValueFactory<>("transactionfield"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amountfield"));
        tableViewAccount.setItems(getAccount());

    }

    private ObservableList<Transaction> getAccount() {
        Transaction t1=new Transaction("WIFI DATA USAGE","1000.50");
        Transaction t2=new Transaction("RESTAURANT TABLE BOOKING","500.50");
        double tot=Double.parseDouble(t1.getAmountfield())+Double.parseDouble(t2.getAmountfield());
        Transaction total=new Transaction("TOTAL",Double.toString(tot));
        transAction.add(t1);
        transAction.add(t2);
        transAction.add(total);
        return transAction;
    }

    @FXML
    private void backButtonMethod(){
        Stage stage = (Stage)this.backButton.getScene().getWindow();
        stage.close();
    }
}
