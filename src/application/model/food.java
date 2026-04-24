package application.model;

import javafx.beans.property.*;

public class food {
    private final StringProperty id;
    private final StringProperty name;
    private final DoubleProperty price;
    private final DoubleProperty quantity;
    private final StringProperty onSale;
    private final StringProperty expiryDate;
    private final StringProperty manufacturingDate;
    

    public food(String id, String name, double price, double quantity,String onSale,String expiryDate, String manufacturingDate) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.quantity = new SimpleDoubleProperty(quantity);
        this.onSale = new SimpleStringProperty(onSale);
        this.expiryDate = new SimpleStringProperty(expiryDate);
        this.manufacturingDate = new SimpleStringProperty(manufacturingDate);
    }

    public StringProperty idProperty() { return id; }
    public StringProperty nameProperty() { return name; }
    public DoubleProperty priceProperty() { return price; }
    public DoubleProperty quantityProperty() { return quantity; }
    public StringProperty onSaleProperty() { return onSale; }
    public StringProperty expiryDateProperty() { return expiryDate; }
    public StringProperty manufacturingDateProperty() { return manufacturingDate; }

    public String getId() { return id.get(); }
    public String getName() { return name.get(); }
    public double getPrice() { return price.get(); }
    public double getQuantity() { return quantity.get(); }
    public String getonSale() { return onSale.get(); }
    public String getExpiryDate() { return expiryDate.get(); }
    public String getManufacturingDate() { return manufacturingDate.get(); }
    @Override
    public String toString() {
        return "Food [ID=" + getId() +
               ", Name=" + getName() +
               ", Price=" + getPrice() +
               ", Quantity=" + getQuantity() +
               ", On Sale=" + getonSale() +
               ", Expiry Date=" + getExpiryDate() +
               ", Manufacturing Date=" + getManufacturingDate() + "]";
    }
}

