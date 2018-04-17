package guestModules;

import javafx.beans.property.SimpleStringProperty;

public class Transaction {

    private SimpleStringProperty transactionfield, amountfield;

    public Transaction(String transactionfield, String amountfield) {
        this.transactionfield =new SimpleStringProperty(transactionfield);
        this.amountfield =new SimpleStringProperty(amountfield);
    }

    public String getTransactionfield() {
        return transactionfield.get();
    }

    public SimpleStringProperty transactionfieldProperty() {
        return transactionfield;
    }

    public void setTransactionfield(String transactionfield) {
        this.transactionfield.set(transactionfield);
    }

    public String getAmountfield() {
        return amountfield.get();
    }

    public SimpleStringProperty amountfieldProperty() {
        return amountfield;
    }

    public void setAmountfield(String amountfield) {
        this.amountfield.set(amountfield);
    }
}
