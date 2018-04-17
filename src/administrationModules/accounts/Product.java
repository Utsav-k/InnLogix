package administrationModules.accounts;
import javafx.beans.property.SimpleStringProperty;

public class Product {
    private SimpleStringProperty month;
    private SimpleStringProperty id;
    private SimpleStringProperty price;
    private SimpleStringProperty quantity;

    public Product(String id, String month, String price, String  quantity) {
        this.month = new SimpleStringProperty(month);
        this.id = new SimpleStringProperty(id);
        this.price = new SimpleStringProperty(price);
        this.quantity = new SimpleStringProperty(quantity);
    }

    public String getQuantity() {
        return quantity.get();
    }

    public String getMonth() {
        return month.get();
    }

    public SimpleStringProperty monthProperty() {
        return month;
    }

    public void setMonth(String month) {
        this.month.set(month);
    }

    public SimpleStringProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity.set(quantity);
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }
}
