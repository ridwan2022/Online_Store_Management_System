package application;

import application.model.ClothingDataStore;
import application.model.clothes;
import application.model.FoodDataStore;
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
import javafx.stage.Stage;

public class purchaseProductController {

    @FXML private TextField searchField;
    @FXML private TextField quantityField;
    @FXML private Button buyNow;
    @FXML private TableView<Object> resultTable;  // Object to handle both food & clothes
    @FXML private TableColumn<Object, String> idColumn;
    @FXML private TableColumn<Object, String> nameColumn;
    @FXML private TableColumn<Object, Double> priceColumn;
    @FXML private TableColumn<Object, Double> quantityColumn;
    @FXML private TableColumn<Object, String> onSaleColumn;

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
    }

    @FXML
    public void handleSearch(ActionEvent event) {
        String searchId = searchField.getText().trim();
        if (searchId.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Input Required", "Please enter a product ID to search.");
            return;
        }

        ObservableList<Object> foundItems = FXCollections.observableArrayList();

        // Search food list
        for (food f : FoodDataStore.getFoodList()) {
            if (f.getId().equalsIgnoreCase(searchId)) {
                foundItems.add(f);
                break;  // stop after first found item, remove if want multiple results
            }
        }

        // Search clothes list if not found in food
        if (foundItems.isEmpty()) {
            for (clothes c : ClothingDataStore.getClothingList()) {
                if (c.getId().equalsIgnoreCase(searchId)) {
                    foundItems.add(c);
                    break;
                }
            }
        }

        if (!foundItems.isEmpty()) {
            resultTable.setItems(foundItems);
            resultTable.setVisible(true);
            buyNow.setVisible(true);
        } else {
            resultTable.getItems().clear();
            resultTable.setVisible(false);
            showAlert(Alert.AlertType.INFORMATION, "Not Found", "No product found with ID: " + searchId);
        }
    }

    @FXML
    public void handleSave(ActionEvent event) {
        Object selected = resultTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            System.out.println("No product selected.");
            return;
        }

        System.out.println("Purchased Product:");
        System.out.println(selected.toString()); // Ensure your food/clothes classes override toString()
    }
    @FXML
    public void handleBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Customer_Dashboard.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Customer Dashboard");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load Customer Dashboard.");
        }
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

