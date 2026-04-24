package application;

import application.model.ClothingDataStore;
import application.model.FoodDataStore;
import application.model.clothes;
import application.model.food;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class salesController {

    @FXML private TextField searchField;
    @FXML private TableView<Object> resultTable;
    @FXML private TableColumn<Object, String> idColumn;
    @FXML private TableColumn<Object, String> nameColumn;
    @FXML private TableColumn<Object, Double> priceColumn;
    @FXML private TableColumn<Object, Double> quantityColumn;
    @FXML private TableColumn<Object, String> onSaleColumn;

    @FXML private Text discountLabel;
    @FXML private TextField discountField;
    @FXML private Button applyDiscountButton;

    private food selectedFood;
    private clothes selectedClothing;

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        quantityColumn.setCellValueFactory(cellData -> {
            Object item = cellData.getValue();
            if (item instanceof food f) {
                return f.quantityProperty().asObject();
            } else if (item instanceof clothes c) {
                return c.quantityProperty().asObject();
            }
            return null;
        });

        onSaleColumn.setCellValueFactory(new PropertyValueFactory<>("onSale"));

        // Hide elements initially
        resultTable.setVisible(false);
        discountLabel.setVisible(false);
        discountField.setVisible(false);
        applyDiscountButton.setVisible(false);
    }

    @FXML
    private void handleSearch() {
        String searchId = searchField.getText().trim();
        ObservableList<Object> foundItems = FXCollections.observableArrayList();

        // Reset selections
        selectedFood = null;
        selectedClothing = null;

        // Search food
        for (food f : FoodDataStore.getFoodList()) {
            if (f.getId().equalsIgnoreCase(searchId)) {
                foundItems.add(f);
                selectedFood = f;
                break;
            }
        }

        // Search clothes if not found in food
        if (foundItems.isEmpty()) {
            for (clothes c : ClothingDataStore.getClothingList()) {
                if (c.getId().equalsIgnoreCase(searchId)) {
                    foundItems.add(c);
                    selectedClothing = c;
                    break;
                }
            }
        }

        if (!foundItems.isEmpty()) {
            resultTable.setItems(foundItems);
            resultTable.setVisible(true);
            discountLabel.setVisible(true);
            discountField.setVisible(true);
            applyDiscountButton.setVisible(true);
        } else {
            resultTable.setVisible(false);
            discountLabel.setVisible(false);
            discountField.setVisible(false);
            applyDiscountButton.setVisible(false);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Product Not Found");
            alert.setHeaderText(null);
            alert.setContentText("No product found with ID: " + searchId);
            alert.showAndWait();
        }
    }

    @FXML
    private void handleDiscount(ActionEvent event) {
        try {
            double discount = Double.parseDouble(discountField.getText());

            if (selectedFood != null) {
                double newPrice = selectedFood.getPrice() * (1 - discount / 100);
                selectedFood.priceProperty().set(newPrice);
            } else if (selectedClothing != null) {
                double newPrice = selectedClothing.getPrice() * (1 - discount / 100);
                selectedClothing.priceProperty().set(newPrice);
            }

            resultTable.refresh();

        } catch (NumberFormatException e) {
            System.out.println("Invalid discount input.");
        }
    }

    @FXML
    private void backToAdmin(ActionEvent event) {
        try {
            Parent saleRoot = FXMLLoader.load(getClass().getResource("Admin_Dashboard.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(saleRoot));
            stage.setTitle("Admin Dashboard");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
