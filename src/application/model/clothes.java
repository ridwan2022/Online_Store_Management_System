package application.model;

import javafx.beans.property.*;

public class clothes {
    private final StringProperty id;
    private final StringProperty name;
    private final DoubleProperty price;
    private final DoubleProperty quantity;
    private final StringProperty brand;
    private final StringProperty size;
    private final StringProperty subcategory;
    private final StringProperty onSale;

    public clothes(String id, String name, double price, double quantity, String brand, String size, String subcategory, String onSale) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.quantity = new SimpleDoubleProperty(quantity);
        this.brand = new SimpleStringProperty(brand);
        this.size = new SimpleStringProperty(size);
        this.subcategory = new SimpleStringProperty(subcategory);
        this.onSale = new SimpleStringProperty(onSale);
    }

    public StringProperty idProperty() { return id; }
    public StringProperty nameProperty() { return name; }
    public DoubleProperty priceProperty() { return price; }
    public DoubleProperty quantityProperty() { return quantity; }
    public StringProperty brandProperty() { return brand; }
    public StringProperty sizeProperty() { return size; }
    public StringProperty subcategoryProperty() { return subcategory; }
    public StringProperty onSaleProperty() { return onSale; }

    public String getId() { return id.get(); }
    public String getName() { return name.get(); }
    public double getPrice() { return price.get(); }
    public double getQuantity() { return quantity.get(); }
    public String getBrand() { return brand.get(); }
    public String getSize() { return size.get(); }
    public String getSubcategory() { return subcategory.get(); }
    public String getOnSale() { return onSale.get(); }
    @Override
    public String toString() {
        return "Clothes [ID=" + getId() +
               ", Name=" + getName() +
               ", Price=" + getPrice() +
               ", Quantity=" + getQuantity() +
               ", Brand=" + getBrand() +
               ", Size=" + getSize() +
               ", Subcategory=" + getSubcategory() +
               ", On Sale=" + getOnSale() + "]";
    }

}
